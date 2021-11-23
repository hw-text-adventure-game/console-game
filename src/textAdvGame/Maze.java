package textAdvGame;

import textAdvGame.*;
import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;
import textAdvGame.Enemies.MazeGuard;
import textAdvGame.Enemies.StoneGolem;;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {

//I got the maze methods to work, but I couldn't tell you how I got them to work......
//Just redefine character every time?

/* --------------------- ENTER MAZE --------------------- */

    public static void enterMaze(Character myCharacter, ArrayList<String> characterInventory) {
        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        System.out.println("However, the entrance to the castle is guarded by a huge maze. There isn't\n" +
                "any way around it, so your only choice is to go through it. You enter the maze with\n" +
                "your weapons ready and begin to trek the magical hedges.\n");

        MazePaths(userCharacter, inventory);


    }

    /* --------------------- FIRST MAZE PATHS --------------------- */

    public static void MazePaths(Character myCharacter, ArrayList<String> characterInventory) {
        boolean alive = true;

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        String firstChoice;

        while (alive) {

            System.out.println("----FIRST MAZE PATHS----\n");

            System.out.println("----------------------------------");
            System.out.println("Which way would you like to go?\n" +
                    "\n" +
                    "[1] North\n" +
                    "[2] South\n" +
                    "[3] East\n" +
                    "[4] West");
            System.out.println("----------------------------------");

            firstChoice = scanner.nextLine();

            if (firstChoice.equals("1")) {
                alive = false;
                secondMazePaths(myCharacter, inventory);

            } else if (firstChoice.equals("2")) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("\"You decide to head south, but come face to face with a monster!\"");
                System.out.println("------------------------------------------------------------------------------");

                Enemy firstEnemy;
                firstEnemy = new MazeGuard("MAZE GUARDIAN"); //Change to maze guardian or boulder monster

                System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
                System.out.println(firstEnemy.monsterInfo());

                userCharacter.attackMenu(firstEnemy, inventory);
                if (userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
                    alive = false;
                    gameOver();
                    break;
                }

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("After defeating the " + firstEnemy.getName() + ", you look around, but can't find anything\n" +
                        "else. You head back to the crossroads.");
                System.out.println("----------------------------------------------------------------------------------------");
                MazePaths(userCharacter, inventory);
            } else if (firstChoice.equals("3")) {
                if(!inventory.contains("BEWITCHED BELL")) {
                    inventory.add("BEWITCHED BELL");

                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("You decide to head east and find a BEWITCHED BELL! You put it into your inventory.\n" +
                            "After searching the area some more, you find that there isn't anything else that's useful. You\n" +
                            "return to your original spot.");
                    System.out.println("----------------------------------------------------------------------------------------");
                } else {
                    System.out.println("You already found the item in this area.");
                }

                MazePaths(userCharacter, inventory);
            } else if (firstChoice.equals("4")) {
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head west, but all you are met with is a large hedge blocking your path.\n" +
                        "This seems to be a dead end, so you go back and retrace your steps.");
                System.out.println("----------------------------------------------------------------------------------------");
                MazePaths(userCharacter, inventory);
            } else {
                System.err.println("Enter a valid number.");
                MazePaths(userCharacter, inventory);
            }


        }

    }

    /* --------------------- SECOND MAZE PATHS --------------------- */

    public static void secondMazePaths(Character myCharacter, ArrayList<String> characterInventory) {

        System.out.println("You decide to head north and come upon more paths to go down.\n"); //User chose north in firstMazePaths

        boolean alive = true;

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        String secondChoice;
        boolean running = true;

        while (alive) {

            System.out.println("----SECOND MAZE PATHS----\n");

        System.out.println("----------------------------------");
        System.out.println("Which way would you like to go now?\n" +
                "\n" +
                "[1] North\n" +
                "[2] South\n" +
                "[3] East\n" +
                "[4] West");
        System.out.println("----------------------------------");

            secondChoice = scanner.nextLine();

        if (secondChoice.equals("1")) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("\"You decide to head north, but come face to face with a monster!\"");
            System.out.println("------------------------------------------------------------------------------");

            Enemy firstEnemy;
            firstEnemy = new MazeGuard("MAZE GUARDIAN"); //Change to maze guardian or boulder monster

            System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
            System.out.println(firstEnemy.monsterInfo());

            userCharacter.attackMenu(firstEnemy, inventory);
            if (userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
                alive = false;
                gameOver();
                break;
            }

            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("After defeating the " + firstEnemy.getName() + ", you look around, but can't find anything\n" +
                    "else. You head back to the crossroads.");
            System.out.println("----------------------------------------------------------------------------------------");
            secondMazePaths(userCharacter, inventory);

        } else if (secondChoice.equals("2")) {

            if(!inventory.contains("HEALING POTION")) {
                inventory.add("HEALING POTION");

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head south and find a HEALING POTION! You put it into your inventory.\n" +
                        "After searching the area some more, you find that there isn't anything else that's useful. You\n" +
                        "return to your original spot.");
                System.out.println("----------------------------------------------------------------------------------------");
            } else {
                System.out.println("You already found the item in this area.");
            }

            secondMazePaths(userCharacter, inventory);

            } else if (secondChoice.equals("3")) {

            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("You decide to head east, but all you are met with is a large hedge blocking your path.\n" +
                    "This seems to be a dead end, so you go back and retrace your steps.");
            System.out.println("----------------------------------------------------------------------------------------");
            secondMazePaths(userCharacter, inventory);

            } else if (secondChoice.equals("4")) {

            alive = false;
            thirdMazePaths(myCharacter, inventory);

            } else {
                System.err.println("Enter a valid number.");
            secondMazePaths(userCharacter, inventory);
            }


        }
    }

    /* --------------------- THIRD MAZE PATHS --------------------- */

    public static void thirdMazePaths(Character myCharacter, ArrayList<String> characterInventory) {

        System.out.println("You decide to head west and come upon more paths. It seems\n" +
                "like people could get lost pretty easily in here with all these routes.\n"); //User chose north in firstMazePaths

        boolean alive = true;

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        String thirdChoice;
        boolean running = true;

        while (alive) {

            System.out.println("----THIRD MAZE PATHS----\n");

            System.out.println("----------------------------------");
            System.out.println("Which way would you like to go this time?\n" +
                    "\n" +
                    "[1] North\n" +
                    "[2] South\n" +
                    "[3] East\n" +
                    "[4] West");
            System.out.println("----------------------------------");

            thirdChoice = scanner.nextLine();

            if (thirdChoice.equals("1")) {
                if(!inventory.contains("RED MUSHROOM")){
                    inventory.add("RED MUSHROOM");

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head north and find a RED MUSHROOM! You put it into your inventory.\n" +
                        "After searching the area some more, you find that there isn't anything else that's useful. You\n" +
                        "return to your original spot.");
                System.out.println("----------------------------------------------------------------------------------------");

                } else {
                    System.out.println("You already found the item in this area.");
                }

                thirdMazePaths(userCharacter, inventory);

            } else if (thirdChoice.equals("2")) {

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head south, but all you are met with is a large hedge blocking your path.\n" +
                        "This seems to be a dead end, so you go back and retrace your steps.");
                System.out.println("----------------------------------------------------------------------------------------");
                thirdMazePaths(userCharacter, inventory);

            } else if (thirdChoice.equals("3")) {

                alive = false;
                fourthMazePaths(myCharacter);

            } else if (thirdChoice.equals("4")) {

                System.out.println("------------------------------------------------------------------------------");
                System.out.println("\"You decide to head west, but come face to face with a monster!\"");
                System.out.println("------------------------------------------------------------------------------");

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

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("After defeating the " + firstEnemy.getName() + ", you look around, but can't find anything\n" +
                        "else. You head back to the crossroads.");
                System.out.println("----------------------------------------------------------------------------------------");
                thirdMazePaths(userCharacter, inventory);

            } else {
                System.err.println("Enter a valid number.");
                thirdMazePaths(userCharacter, inventory);
            }


        }

    }

    /* --------------------- FOURTH MAZE PATHS --------------------- */

    public static void fourthMazePaths(Character myCharacter) {

    }


    public static void gameOver () {
        System.out.println("GAME OVER!");
        GameApplication.beginGame();
    }

    public static void youWin () {
        System.out.println("YOU WIN!");
    }


}





