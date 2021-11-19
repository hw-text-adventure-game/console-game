package textAdvGame;

import textAdvGame.*;
import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;;
import java.util.Scanner;

public class Maze {

//I got the maze methods to work, but I couldn't tell you how I got them to work......
//Just redefine character every time?


    public static void enterMaze(Character myCharacter) {
        Character userCharacter = myCharacter;

        System.out.println("However, the entrance to the mansion is guarded by a huge maze. There isn't\n" +
                "any way around it, so your only choice is to go through it. You enter the maze with\n" +
                "your weapons ready and begin to trek the magical hedges.");

        MazePaths(userCharacter);


    }

    public static void MazePaths(Character myCharacter) {

        Character userCharacter = myCharacter;

        Scanner scanner = new Scanner(System.in);
        String firstChoice;
        boolean running = true;

        while(running) {
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
                running = false;
                secondMazePaths();
            } else if (firstChoice.equals("2")) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("\"You decide to head south, but come face to face with a monster made out of\n" +
                        "the same hedges that make up the maze!\"");
                System.out.println("------------------------------------------------------------------------------");

                Enemy firstEnemy;
                firstEnemy = new Goblin("GOBLIN"); //Change to maze guardian or boulder monster

                System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
                System.out.println(firstEnemy.monsterInfo());

                userCharacter.attackMenu(firstEnemy);

                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("After defeating the maze guardian, you look around, but can't find anything useful.\n" +
                "You head back to the crossroads.");
                System.out.println("----------------------------------------------------------------------------------------");
                MazePaths(userCharacter);
            } else if (firstChoice.equals("3")) {
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head east and find a BEWITCHED BELL! You put it into your inventory.\n" +
                        "After searching the area some more, you find that there isn't anything else that's useful. You\n" +
                        "head back to your original spot.");
                System.out.println("----------------------------------------------------------------------------------------");
                MazePaths(userCharacter);
            } else if(firstChoice.equals("4")) {
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("You decide to head west, but all you are met with is a large hedge blocking your path.\n" +
                        "This seems to be a dead end, so you go back and retrace your steps.");
                System.out.println("----------------------------------------------------------------------------------------");
                MazePaths(userCharacter);
            } else {
                System.err.println("Enter a valid number.");
                MazePaths(userCharacter);
            }


        }


    }



    public static void secondMazePaths() {
        System.out.println("You decide to head north and come upon more paths to go down.");
        System.out.println("Which way would you like to go now?\n" +
                "\n" +
                "[1] North\n" +
                "[2] South\n" +
                "[3] East\n" +
                "[4] West");
    }

}



