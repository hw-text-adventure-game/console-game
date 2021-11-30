package textAdvGame;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.StoneGolem;

import java.util.ArrayList;
import java.util.Scanner;

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

                if(userGuess.equalsIgnoreCase("willow") || userGuess.equalsIgnoreCase("raven")
                || userGuess.equalsIgnoreCase("alice") || userGuess.equalsIgnoreCase("hazel") ||
                userGuess.equalsIgnoreCase("salem") || userGuess.equalsIgnoreCase("gwen") ||
                userGuess.equalsIgnoreCase("belladona") || userGuess.equalsIgnoreCase("ambrosia") ||
                userGuess.equalsIgnoreCase("cassandra") || userGuess.equalsIgnoreCase("sylvia") ||
                userGuess.equalsIgnoreCase("rhea")) {
                    System.out.println("You got it right! The doors open.");
                }
                else if(userGuess.equals("exit")) {
                    System.out.println("You decide to give up for now and search for clues about the password.");
                }
                else {
                    System.out.println("The door doesn't budge.");
                }

            } else if (userChoice.equals("2")) {

            } else {
                System.err.println("Enter a valid number.");
            }

        //Put password area here later



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
