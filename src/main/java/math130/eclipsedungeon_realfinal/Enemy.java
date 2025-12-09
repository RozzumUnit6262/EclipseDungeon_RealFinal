package math130.eclipsedungeon_realfinal;

import javafx.scene.image.Image;

public class Enemy
{
	// fields
	private String eneName;
	private int eneHealth;
	private int eneAttack;
	private int experience;
	private String fightMes;
	private String deathMes;
		
		// constructor
	public Enemy(String n, int h, int a, int exp, String fight, String death, Image enemy)
		{
			eneName = n;
			eneHealth = h;
			eneAttack = a;
			experience = exp;
			fightMes = fight;
			deathMes = death;
		}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	// getters n setters
	public String getEneName() {
		return eneName;
	}

	public void setEneName(String eneName) {
		this.eneName = eneName;
	}

	public int getEneHealth() {
		return eneHealth;
	}

	public void setEneHealth(int eneHealth) {
		this.eneHealth = eneHealth;
	}

	public int getEneAttack() {
		return eneAttack;
	}

	public void setEneAttack(int eneAttack) {
		this.eneAttack = eneAttack;
	}
	public String getFightMes() {
		return fightMes;
	}
	public void setFightMes(String fightMes) {
		this.fightMes = fightMes;
	}
	public String getDeathMes() {
		return deathMes;
	}
	public void setDeathMes(String deathMes) {
		this.deathMes = deathMes;
	}
}