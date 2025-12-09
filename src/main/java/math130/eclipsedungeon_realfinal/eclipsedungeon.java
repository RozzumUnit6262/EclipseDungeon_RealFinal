import math130.eclipsedungeon_realfinal.*;
void main()
{
    //  variables
    boolean runtime = true; // checks if game is running
    Scanner interaction = new Scanner(System.in); // for interactions
    int progress = 1; // floor number
    Enemy currentFoe; // current enemy
    boolean victory = false; // check for battle
    boolean completion = false; // game won?


    // text variables
    String div = "--------"; // divider
    String mode = "Placeholder"; // come back to this later
    String nameHolder = "Placeholder";
    String action = "Placeholder"; // attack or defend


    while (runtime == true) {
        // -- introduction --
        IO.println("ECLIPSE DUNGEON");
        IO.println("A game made by Ten Z.");
        IO.println(div);

        IO.println("Aye, traveler!");
        IO.println("The village of Southwesternia " +
                "has had a real monster problem as of late!");
        IO.println("What's yer name? I'll get'cha some gear"
                + " on the double!");
        IO.print("YOUR NAME IS: ");
        nameHolder = interaction.nextLine(); // get name
        IO.println(div);

        Player player = new Player(nameHolder, 25, 3, 0);
        boolean alive = true;

        // -- game --
        while (alive) {
            while (progress <= 9) // normal floors
            {
                currentFoe = encounter(1);
                victory = Floor.normFloor(player, currentFoe,
                        progress, interaction);

                if (victory == true) {
                    System.out.printf("%s has triumphed over Floor %d, and marches on!",
                            player.getPlayName(), progress);
                    IO.println();
                    IO.println("--------");
                    progress++;
                }
                if (victory == false) {
                    System.out.printf("%s has fallen in battle.",
                            player.getPlayName());
                    alive = false;
                }

            }
            if (progress == 10) {
                IO.println("The top of the tower looms");
                System.out.printf("before %s.", player.getPlayName());
                IO.println();
                victory = Floor.normFloor(player, encounter(2),
                        progress, interaction);

                if (victory) ;
                {
                    completion = true;
                    alive = false;
                }
                if (!victory) {
                    System.out.printf("%s has fallen in battle.",
                            player.getPlayName());
                    completion = false;
                    alive = false;
                }
            }
        }
        if (completion) {
            System.out.printf("%s stands atop the tower,",
                    player.getPlayName());
            IO.println();
            IO.println("journey complete at last.");
            IO.println(div);
            IO.println("YOU WIN!");
        }
        if (!completion) {
            System.out.printf("%s retreats from the tower,",
                    player.getPlayName());
            IO.println("tired and scarred from battle.");
            IO.println("But there is always tomorrow.");
            IO.println("Rest up and get back to it!");
            IO.println("GAME OVER");
        }
        IO.println(div);
        IO.println("FINAL STATISTICS");
        System.out.printf("Floors Completed: %d/10", progress);
        IO.println();
        System.out.printf("Total XP: %d", player.getPlayExp());
        IO.println();
        IO.println(div);

        while (!(action.equals("y"))
                || !(action.equals("n")))
        {
            IO.println("Play again?");
            action = interaction.nextLine();
        }
        if (action.equals("n")) {
            IO.println("Thank you for playing!");
            interaction.close();
            runtime = false;
        }

        progress = 0; // restart game
    }
}
public static Enemy encounter(int i) // generates an enemy for the current floor
{
    Enemy returnEne = null;

    // Enemy types
    Enemy bat = new Enemy("Byte Bat", 6, 2, 1,
            "The Byte Bat bytes you",
            "The Byte Bat was deallocated from memory.", enemyBat);

    Enemy slime = new Enemy("Scanner Slime", 8, 1, 2,
            "The Scanner Slime gathers your input",
            "The Scanner Slime was closed.", enemySlime);

    Enemy snake = new Enemy("Virus Viper", 8, 2, 2,
            "The Virus Viper infected you",
            "The Virus Viper was wiped from the drive.", enemyViper);
    // boss
    Enemy boss = new Enemy("Gigabyte Golem", 25, 5, 10,
            "The Gigabyte Golem giga-punched you",
            "The Gigabyte Golem was recycled.", enemyBoss);

    Random rng = new Random(); // determines which normal enemy to be fought
    int fight = rng.nextInt(1, 4);
    if (i == 1) {
        switch (fight) {
            case 1:
                returnEne = bat;
            case 2:
                returnEne = slime;
            case 3:
                returnEne = snake;
        }
    }
    if (i == 2) {
        returnEne = boss;
    }

    return returnEne;
}