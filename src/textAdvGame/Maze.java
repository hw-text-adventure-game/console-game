package textAdvGame;

import textAdvGame.*;
import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;
import java.util.Scanner;

public class Maze {


    public void enterMaze() {

        System.out.println("However, the entrance to the mansion is guarded by a huge maze. There isn't\n" +
                "any way around it, so your only choice is to go through it. You enter the maze with\n" +
                "your weapons ready and begin to trek the magical hedges.");

        MazePaths();


    }

    public static void MazePaths() {

        Scanner scanner = new Scanner(System.in);
        String firstChoice;
        boolean running = true;

        while(running) {

            System.out.println("Which way would you like to go?\n" +
                    "\n" +
                    "[1] North\n" +
                    "[2] South\n" +
                    "[3] East\n" +
                    "[4] West");


            firstChoice = scanner.nextLine();

            if (firstChoice.equals("1")) {
                running = false;
                secondMazePaths();
            } else if (firstChoice.equals("2")) {
                System.out.println("\"You decide to head south, but come face to face with a monster made out of\n" +
                        "the same hedges that make up the maze!");

                Enemy firstEnemy;
                firstEnemy = new Goblin("GOBLIN");

                System.out.println("***** A " + firstEnemy.getName() + " appears! *****");

//                userCharacter.attackMenu(firstEnemy);

                //Fight enemy here
                MazePaths();
            } else if (firstChoice.equals("3")) {
                System.out.println("You decide to head east and find a BEWITCHED BELL! You put it into your inventory.\n" +
                        "After searching the area some more, you find that there isn't anything else that's useful. You head\n" +
                        "back to your original spot.");
                MazePaths();
            } else if(firstChoice.equals("4")) {
                System.out.println("You decide to head west, but all you are met with is a large hedge blocking your path.\n" +
                        "This seems to be a dead end, so you return to your original location.");
                MazePaths();
            } else {
                System.err.println("Enter a valid number.");
                MazePaths();
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





