package textAdvGame;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.StoneGolem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static textAdvGame.Trench.teleportTrench;

public class Castle {

    public static void enterCastleGarden(Character myCharacter, ArrayList<String> characterInventory) {

        boolean alive = true;
//        String correctWord = Hangman.hangmanGame(); //this doesn't work as intended, it gives you a different name + forces you to play again

        while (alive) {

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;


        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("After escaping the caves, you find a long, stone staircase leading out of the trench and straight.\n" +
                "to the witch's castle. You climb up the long staircase, arriving at the castle gardens, which are lavish and " +
                "bright. You spot a stone with glowing blue words, similar to the one you found when you exited the maze:\n" +

                "\n" +

                "\"If you can't face the witch yet it's what you crave, perhaps your answer is back in the dark caves.\n" +
                "If your searches are fruitless, remember you're not alone, call for help by calling for the Wayward Stone.\"\n" +

                "\n" +

                "After reading the message on the stone you approach the castle gardens, however a STONE GOLEM is guarding the entrance!\n" +
                "To get to the door of the castle, you decide to fight the monster!");
        System.out.println("------------------------------------------------------------------------------------------------------------\n");

        Enemy firstEnemy;
        firstEnemy = new StoneGolem("STONE GOLEM"); //Change to maze guardian or boulder monster

        System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
        System.out.println(firstEnemy.monsterInfo());
        System.out.println(firstEnemy.traitMessage());

        userCharacter.attackMenu(firstEnemy, inventory);
        if (userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
            alive = false;
            gameOver();
            break;
        }

            Scanner scanner = new Scanner(System.in);
            String userChoice;

            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("After defeating the " + firstEnemy.getName() + ", you approach the castle door, but as you\n" +
                    "try to open the doors, you realize that they're locked by a spell. A hint to breaking the spell is\n" +
                    "etched into the stone:\n" +

                    "\n" +

                    "\"Say The Witch's real name and the doors will open.\"\n" +


                    "\n" +

                    "The Witch is just a door away, what will you do?\n" +

                    "\n" +
                            "[1] Guess the password\n" +
                            "[2] Leave the castle grounds\n");

            System.out.println("----------------------------------------------------------------------------------------\n");

            userChoice = scanner.nextLine();

            if (userChoice.equals("1")) {

                String userGuess;

                System.out.println("You go up to the door and say the password...\n" +
                        "(Type in your guess or type \"exit\" to leave.");

                userGuess = scanner.nextLine();
                if (userGuess.equals(Hangman.getTheWord()))
                {
                    System.out.println("You got it right!");
                    enterCastle(userCharacter, inventory);

                }
                else if(userGuess.equals("exit")) {
                    System.out.println("You decide to give up for now and search for clues about the password.");

                    String teleportToTrench;

                    System.out.println("You exit the garden, only to be met with the glowing rock with the riddle engraved into it.\n" +
                            "(If you wish to return to the beginning of the trench, type in \"Wayward Stone\". Otherwise, type exit).");

                    teleportToTrench = scanner.nextLine();

                    if(teleportToTrench.equalsIgnoreCase("wayward stone")) {
                        teleportTrench(userCharacter, inventory);
                        System.out.println("Go back to the beginning of the maze.");
                    } else {
                        System.out.println("With nowhere else to go here, you decide to head into the castle garden.");
                        enterCastleGarden(userCharacter, inventory);
                    }
                }
                else {
                    System.out.println("The door doesn't budge.");
                }

            } else if (userChoice.equals("2")) {

            } else {
                System.err.println("Enter a valid number.");
            }


    }

 }

    public static void enterCastle(Character myCharacter, ArrayList<String> characterInventory) {

        boolean alive = true;

        while (alive) {

            Character userCharacter = myCharacter;
            ArrayList<String> inventory = characterInventory;

            Scanner scanner = new Scanner(System.in);

            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("The doors to the castle open, revealing the dark and dingy walls behind them. Green flames suddenly\n" +
                    "light up the room, revealing The Witch, " + Hangman.getTheWord() + " who is here to greet you.\n" +
                    "bright. You spot a stone with glowing blue words, similar to the one you found when you exited the maze:\n" +

                    "\n" +

                    "The Witch: \"You must be " + userCharacter.getName() + " the " + userCharacter.getProfession() + "...I felt your presence in my domain.\n" +
                    "You want out of this forest, do you not? But perhaps...you desire this more?\"\n" +

                    "\n" +

                    userCharacter.personalDesire() +

                    "\n" +

                    "I'll also tell you the secret to lifting the forest's curse so you can go home. What do you say? Sound like a fair deal?\n");

           String takeDeal;

            System.out.println("Take The Witch's deal? [Y/N]");

            takeDeal = scanner.nextLine();

            if(takeDeal.equalsIgnoreCase("y")) {
                System.out.println("You take the deal and shake her hand, but as soon as you grasp her hand, she sets you on fire!.\n" +

                "\n" +

                "The Witch: \"Didn't anyone tell you to never trust a witch, " + userCharacter.getName() + "?" +

                "\n");

                gameOver();

            } else {
                System.out.println("You refuse the deal, causing The Witch to become angry.\n" +

                "\n" +

               "The Witch: \"Very well then, we shall do this the hard way! Say your prayers, " + userCharacter.getName() + "!" +

                "\n"
                );

                Enemy firstEnemy;
                firstEnemy = new StoneGolem("WITCH " + Hangman.getTheWord().toUpperCase(Locale.ROOT));

                System.out.println("*****" + firstEnemy.getName() + " appears! *****");
                System.out.println(firstEnemy.monsterInfo());

                userCharacter.attackMenu(firstEnemy, inventory);
                if (userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
                    alive = false;
                    gameOver();
                    break;
                }

                    youWin();
            }


        }

        }




    public static void gameOver () {
        System.out.println("GAME OVER!");
        GameApplication.beginGame();
    }

    public static void youWin () {
        System.out.println("YOU WIN!");
        GameApplication.beginGame();
    }


}
