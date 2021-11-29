package textAdvGame;

import textAdvGame.Characters.Character;

import java.util.ArrayList;
import java.util.Scanner;
import static textAdvGame.Maze.teleportMaze;

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
                    "that in a long time! All I've been living off of is plants and mushrooms so I'm starvin', heh heh!\"\n");

            System.out.println("Would you like to talk to the Hangman Man? [Y/N]");

            talkToHangman = scanner.nextLine();

            if(talkToHangman.equalsIgnoreCase("y")) {
                hangMan(userCharacter, inventory);
            } else {
                System.out.println("You leave the kooky old man to his madness.");
                outsideOfCave(userCharacter, inventory);
            }

        } else if(goHere.equals("3")) {
            String teleportToMaze;

            System.out.println("You exit the trenches, only to be met with the glowing rock with the riddle engraved into it.\n" +
                    "(If you wish to return to the beginning of the maze, type in \"Wayward Stone\". Otherwise, type exit).");

            teleportToMaze = scanner.nextLine();

            if(teleportToMaze.equalsIgnoreCase("wayward stone")) {
                teleportMaze(userCharacter, inventory);
                System.out.println("Go back to the beginning of the maze.");
            } else {
                System.out.println("With nowhere else to go up here, you decide to head back down into the trenches.");
                outsideOfCave(userCharacter, inventory);
            }

        }

    }

    }


    public static void hangMan(Character myCharacter, ArrayList<String> characterInventory) {

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        Scanner scanner = new Scanner(System.in);
        boolean talking = true;
        String talkToHangman;

        while (talking) {

            System.out.println("What would you like to talk about?\n");

            System.out.println(
                    "[1] You\n" +
                    "[2] The Hangman Man\n" +
                    "[3] The Enchanted Forest\n" +
                    "[4] The Castle\n" +
                    "[5] The Witch\n" +
                    "[6] [PLAY HANGMAN WITH HANGMAN MAN]\n" +
                    "[7] Leave\n");

            talkToHangman = scanner.nextLine();

            if(talkToHangman.equals("1")) {
                System.out.println(userCharacter.oldManResponse1());
            }
            else if(talkToHangman.equals("2")) {
                System.out.println(
                    "Hangman Man: \"Me? I'm the Hangman Man, the man who likes to play hangman, heh heh! It's the only\n" +
                    "game keeping me young these days...but a game of hangman isn't the same without a mushroom! Hmm? Why\n" +
                     "does a mushroom make a difference? Heh heh...when you get as old as me, you'll understand, " + userCharacter.getName() + ".\"\n");
            }
            else if(talkToHangman.equals("3")) {
                System.out.println(
                        "Hangman Man: \"This old forest? Heh, it's cursed, but I think you knew that already. Anyone who enters is bound\n" +
                        "by the curse of the forest; once you enter, you can never leave. Trust me, I tried! Heh heh! The only way you're\n" +
                        "gonna get out of here is if you get rid of The Witch. As long as she's around, the curse will stay and you'll be\n" +
                        "trapped. Oh yeah, and if that witch tries to offer you one of her deals, don't take it. She's a deceitful woman;\n" +
                        "she'll always find the loopholes, just like my wife! Heh heh heh!\"\n");
            }
            else if(talkToHangman.equals("4")) {
                System.out.println("Hangman Man: \"Interested in the castle, eh? Have ya been there yet? Well if you have, you probably noticed the magical\n" +
                        "lock on the door. You gotta say the password for the lock to come off, ya see? Good thing I know the password, heh!\n" +
                        "I'm not just gonna give it to you willy nilly though, we gotta play for it! And I don't play without mushrooms!\n" +
                        "...how about I make you a deal? You give me a mushroom, and we'll play a game of hangman so you can get the password.\n" +
                        "Any mushroom will do, but my favorites are the red ones, heh heh! they grow a lot in the maze, you should go look for\n" +
                        "em!\"\n");
            }
            else if(talkToHangman.equals("5")) {
                System.out.println("Hangman Man: \"The Witch? Heh, yeah I know her. When I knew her though, she went by her real name. We used to be good\n" +
                        "friends her and I, until her powers corrupted her. She wanted everyone to know and fear her power, so she created\n" +
                        "The Enchanted Forest and put a curse upon this land so she could do just that. I've tried talking sense into her,\n" +
                        "but she eventually got so tired of me that she put a lock on her castle door, heh heh!\"\n");
            }
            else if(talkToHangman.equals("6")) {
                String correctWord = Hangman.hangmanGame();

                if(!inventory.contains("RED MUSHROOM")) {
                    System.out.println("Hangman Man: \"Woah woah woah, hold your horses! I won't play hangman if you just ask me to! No, I gotta be in the\n" +
                    "hangman mood! Bring me a mushroom and I'll play a good ol fashion round of hangman with ya.\"\n");
                } else {
                    System.out.println("You have a mushroom!");
                }

            }
            else if(talkToHangman.equals("7")) {
                outsideOfCave(userCharacter, inventory);
            }




        }

    }


    public static void enterCaves(Character userCharacter, ArrayList<String> inventory) {
    }

}
