package Application;

import Entities.Arena;
import Entities.Pokemon;

public class Program {

	public static void main(String[] args) {
		Arena a = new Arena();
		Pokemon p1 = new Pokemon("Picachu");
		Pokemon p2 = new Pokemon("Charmander");
		
		try {
			a.startFight(p1, p2);
		} catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("There was an error while a thread was sleeping");
		}
	}
}
