package textAdvGame;

import textAdvGame.Characters.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Trench {

    public static void enterTrench(Character myCharacter, ArrayList<String> characterInventory) {
        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("After escaping the maze, you breathe a sigh of relief, happy to be out of there at last.\n" +
                "A stone outside of the maze begins to glow a bright blue color and has these words etched into it:\n" +

                "\n" +

                "\"If you're lost, unsure, or can't find your way, perhaps what you're seeking is still in the maze.\n" +
                "When you wish to return but the way back is unknown, put your hand on this rock and call for the Wayward Stone.\"\n" +

                "\n" +

                "After reading the message on the stone you approach the castle, ready to face the witch, but stop dead in your tracks;\n" +
                "a deep trench is in your way! However, there's a ladder that leads down into the seemingly bottomless pit. Once again,\n" +
                "it seems like your only path forward is to go in and through the trench. You climb down the flimsy ladder, into the\n" +
                "abyss.");
        System.out.println("------------------------------------------------------------------------------------------------------------\n");


        outsideOfCave(userCharacter, inventory);

    }

    public static void outsideOfCave(Character myCharacter, ArrayList<String> characterInventory) {

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        String goHere;

        System.out.println("---------------------------------------------------------------------");
        System.out.println("You soon reach the bottom of the pit and find only two ways to go:\n" +
                "\n" +
                "[1] Go into the Caves\n" +
                "[2] Visit the \"Hangman Shack\" \n" +
                "[3] Leave the Trench");
        System.out.println("---------------------------------------------------------------------");

        goHere = scanner.nextLine();
    }

}
