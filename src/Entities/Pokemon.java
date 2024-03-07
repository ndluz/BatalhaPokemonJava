package Entities;

import java.util.Random;

public class Pokemon {
	private String name;
	private Integer HP;
	private Integer Atk;
	private Integer Def;
	
	public Pokemon(String name) {
		super();
		this.name = name;
		HP = 30;
		Atk = this.randomNumber();
		Def = this.randomNumber();
	}
	
	private int randomNumber() {
		return new Random().nextInt(30);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHP() {
		return HP;
	}

	public void setHP(Integer hP) {
		HP = hP;
	}

	public Integer getAtk() {
		return Atk;
	}

	public void setAtk(Integer atk) {
		Atk = atk;
	}

	public Integer getDef() {
		return Def;
	}

	public void setDef(Integer def) {
		Def = def;
	}
	
	public boolean stillAlive() {
		return this.getHP() > 0;
	}
	
}
