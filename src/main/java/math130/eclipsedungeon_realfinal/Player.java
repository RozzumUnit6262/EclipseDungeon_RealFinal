package math130.eclipsedungeon_realfinal;

public class Player
{	
	// fields
	private String playName;
	public int playHealth;
	private int playAttack;
	private int playExp;
	
	// constructor
	public Player(String n, int h, int a, int e)
	{
		playName = n;
		playHealth = h;
		playAttack = a;
		playExp = e;
	}
	// getters n' setters
	public String getPlayName() {
		return playName;
	}

	public void setPlayName(String playName) {
		this.playName = playName;
	}

	public int getPlayHealth() {
		return playHealth;
	}

	public void setPlayHealth(int playHealth) {
		this.playHealth = playHealth;
	}

	public int getPlayAttack() {
		return playAttack;
	}

	public void setPlayAttack(int playAttack) {
		this.playAttack = playAttack;
	}
	public int getPlayExp() {
		return playExp;
	}
	public void setPlayExp(int playExp) {
		this.playExp = playExp;
	}
}
