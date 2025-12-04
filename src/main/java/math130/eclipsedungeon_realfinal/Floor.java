package math130.eclipsedungeon_realfinal;
import java.util.Scanner;
public class Floor
{	
	// loop
	private static Player hero; // player
	private static Enemy monster; // enemy
	private static int floorNum; // floor number

	private static String interact = "Placeholder!";


	public static boolean normFloor(Player p, Enemy e, int floor, Scanner s)
	{
		hero = p;
		monster = e;
		floorNum = floor;
		boolean battle = true;
		boolean victory = false;
		Scanner kbd = s;

		System.out.printf("Now descending to Floor %d...",
				floorNum);
		System.out.println();

		System.out.printf("A %s jumped out at you!",
				monster.getEneName());
		System.out.println();
		System.out.println("--------");

		while (battle)
		{
			// status update
			System.out.printf("%s has %d health remaining.", 
					hero.getPlayName(), hero.getPlayHealth());
			System.out.println();
			System.out.printf("%s has %d health remaining.",
					monster.getEneName(), monster.getEneHealth());
			System.out.println();
			System.out.println("--------");

			// -- player action --
			while (!(interact.equals("a") || 
					interact.equals("d"))) // data validation loop
			{
				System.out.printf("%s, attack or defend? ", 
						hero.getPlayName());
				interact = kbd.nextLine();
				System.out.println("--------");
			}
			if (interact.equals("a"))
			{
				// player attack
				System.out.printf("%s strikes the %s for %d damage!", // player attacks enemy
						hero.getPlayName(), monster.getEneName(), 
						hero.getPlayAttack());
				monster.setEneHealth(monster.getEneHealth()
						- hero.getPlayAttack());
				interact = "Placeholder!";
				System.out.println();

				// monster attack
				System.out.printf("%s for %d damage!", 
						monster.getFightMes(), monster.getEneAttack());
				hero.setPlayHealth(hero.playHealth - monster.getEneAttack());
				System.out.println();
				System.out.println("--------");
			}
			if (interact.equals("d"))
			{
				// block action
				System.out.printf("%s blocked the attack!", hero.getPlayName());
				System.out.println();
				System.out.printf("%s healed for 3.", hero.getPlayName());
				System.out.println();
				System.out.println("--------");

				// heal action
				hero.setPlayHealth(hero.getPlayHealth() + 3);
				if (hero.getPlayHealth() > 25)
				{
					hero.setPlayHealth(25);
				}

				interact = "Placeholder!";
			}
			if (hero.getPlayHealth() <= 0)
			{
				victory = false;
				battle = false;
			}
			if (monster.getEneHealth() <= 0)
			{
				victory = true;
				battle = false;
			}
		}
		if (victory); // exp gain and check
		{
			System.out.printf("%s You win!",
					monster.getDeathMes());
			System.out.println();
			System.out.printf("%s gained %d EXP.",
					hero.getPlayName(), monster.getExperience());
			hero.setPlayExp(hero.getPlayExp() + monster.getExperience());
			System.out.println();

			if (((hero.getPlayExp() % 3) == 0) && (hero.getPlayExp() != 0))
			{

				System.out.printf("%s has leveled up to Level %d!", 
						hero.getPlayName(), (hero.getPlayExp() / 3));	
				hero.setPlayAttack(hero.getPlayAttack()
						+ (hero.getPlayExp() / 3));
				System.out.println();
			}
		}
		return victory;

	}
}