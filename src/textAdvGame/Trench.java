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

        System.out.println("---------------------------------------------------------------------");
        System.out.println("You soon reach the bottom of the pit and find only three ways to go:\n");

        outsideOfCave(userCharacter, inventory);

    }

    public static void outsideOfCave(Character myCharacter, ArrayList<String> characterInventory) {

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        String goHere;
        boolean alive = true;

        while (alive) {

        System.out.println(
                "[1] Go into the Caves\n" +
                "[2] Visit the \"Hangman Shack\" \n" +
                "[3] Leave the Trench");

        System.out.println("---------------------------------------------------------------------");

        goHere = scanner.nextLine();

        if(goHere.equals("1")) {
            enterCaves(userCharacter, inventory);
        }
        else if(goHere.equals("2")) {

            String talkToHangman;

            System.out.println("You decide to head towards the Hangman Shack, unsure of what you'll find.\n" +
                    "An elder man appears out from the shack, wearing a torn up wizard hat and shaggy robes.\n" +
                    "His beard is so long that it touches the ground and his voice is gravelly as he speaks:\n" +
                    "\n" +
                    "Hangman Man: \"Oho, a " + userCharacter.getProfession() + "? How strange! I haven't seen anyone like\n" +
                    "you in years! Tell me, do they have those juicy chicken legs where you're from? I haven't had\n" +
                    "that in a long time! All I've been living off of is plants and mushrooms so I'm starvin', heh heh!\n\"");

            System.out.println("Would you like to talk to the Hangman Man? [Y/N]");

            talkToHangman = scanner.nextLine();

            if(talkToHangman.equalsIgnoreCase("y")) {
                System.out.println("You decided to talk to the Hangman Man!");
            } else {
                System.out.println("You leave the kooky old man to his madness.");
                outsideOfCave(userCharacter, inventory);
            }

        }

    }

    }



    public static void enterCaves(Character userCharacter, ArrayList<String> inventory) {
    }

}
