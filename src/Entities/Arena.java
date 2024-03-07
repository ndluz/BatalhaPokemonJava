package Entities;

import java.util.Random;

public class Arena {
	private Pokemon p1;
	private Pokemon p2;

	public Arena () {}
	
	public int setOrder() {
		int first = new Random().nextInt(2) + 1;
		return first;
	}
	
	public void startFight(Pokemon p1, Pokemon p2) throws InterruptedException {
		System.out.println("========== BATTLE START =============");
		Thread.sleep(3000);
		
		boolean winner = false;
		int roundCount = 1;
		int firstMove = this.setOrder();
		
		if (firstMove == 1) {
		    this.p1 = p1;
		    this.p2 = p2;
		} else {
		    this.p1 = p2;
		    this.p2 = p1;
		}
		
		while (winner != true) {
			int roundResult = 0;
			System.out.printf("Round #%d\n\n", roundCount);
			Thread.sleep(2000);
			
			System.out.printf("First to move (ATK): %s\n", this.p1.getName());
			System.out.printf("Second to move (DEF): %s\n\n", this.p2.getName());
			Thread.sleep(2000);
			
			System.out.println("FIGHT!!!!\n");
			Thread.sleep(2000);
			
			System.out.printf("%s attacks with attack force: %d\n", this.p1.getName(), this.p1.getAtk());
			System.out.printf("%s defends with defense force: %d\n\n", this.p2.getName(), this.p2.getDef());
			
			if (this.p1.getAtk() > this.p2.getDef()) {
				roundResult = this.p1.getAtk() - this.p2.getDef();
				this.p2.setHP(this.p2.getHP() - roundResult);
				if (this.p2.getHP() < 1) {
					winner = true;
					System.out.printf("%s loss %d HP points, bacause his defense is lower\n\n", this.p2.getName(), this.p2.getHP());
					System.out.printf("%s is the winner of the battle\n", this.p1.getName());
					return;
				}
				System.out.printf("%s loss %d HP points, bacause his defense is lower\n\n", this.p2.getName(), this.p2.getHP());
				
			} 
			else if (this.p1.getAtk() < this.p2.getDef()) {
				roundResult = this.p2.getDef() - this.p1.getAtk();
				this.p1.setHP(this.p1.getHP() - roundResult);
				if (this.p1.getHP() < 1) {
					winner = true;
					System.out.printf("%s loss %d HP points, bacause his defense is lower\n\n", this.p2.getName(), this.p2.getHP());
					System.out.printf("%s is the winner of the battle\n", this.p2.getName());
					return;
				}
				System.out.printf("%s loss %d HP points, bacause his atack is lower\n\n", this.p1.getName(), this.p1.getHP());
				
			} else {
				System.out.println("DRAWN ROUND!!!\n");
				System.out.println("All pokemons has been defeted, no winner");
				winner=false;
				return;
			}
			
			this.p1 = p2;
			this.p2 = p1;
			roundCount++;
		}
	}
}
