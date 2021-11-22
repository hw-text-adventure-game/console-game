package textAdvGame;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;
import textAdvGame.Maze;

import java.util.ArrayList;
import java.util.Scanner;

import static textAdvGame.Maze.enterMaze;


public class GameApplication {


    public static void beginGame(){
        boolean alive = true;
        while(alive) { //While character is alive, continue story
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("\"You wake up in the Enchanted Forest, unsure of how you got there. The forest you are in has been\n" +
                "known for it's strange properties; all adventurers who enter the forest never return as the same\n" +
                "person...or even return at all. As you rub the sleep out of your eyes, you begin to remember who you" +
                " are.");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        Character userCharacter = Character.chooseCharacter();

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("\"After you remember your name and your past, you get up and begin to search The Enchanted Forest,\n" +
                "but suddenly you hear a noise from behind you!\"");
        System.out.println("------------------------------------------------------------------------------------------------------------");

            ArrayList<String> inventory = new ArrayList<>();

        Enemy firstEnemy;
        firstEnemy = new Goblin("GOBLIN");

        System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
            System.out.println(firstEnemy.monsterInfo());

        userCharacter.attackMenu(firstEnemy, inventory);




            //check if character is dead after every fight

        if(userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
            alive = false;
            gameOver();
            break;
        }
            System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("You continue your journey into The Enchanted Forest, on edge after the goblin attack.\n" +
                "It's safe to assume the forest is full of these kinds of creatures, so you stay on your guard.\n" +
                "As you continue further, you see a castle in the distance, towering above all the trees.\n" +
                userCharacter.personalMessage1());
            System.out.println("------------------------------------------------------------------------------------------------------------");
        //Add personalized line here before the user enters the maze.

            enterMaze(userCharacter, inventory); //Passing in userCharacter to maze

        }


    }


    public static void gameOver() {
        System.out.println("GAME OVER!");
}

    public static void youWin() {
        System.out.println("YOU WIN!");
    }


    public static void main(String[] args) {
        beginGame();

    }
}
