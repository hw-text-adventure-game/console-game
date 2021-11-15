package textAdvGame;

import java.util.Scanner;

public class GameApplication {

    public static void beginGame(){
        System.out.println("\"You wake up in the Enchanted Forest, unsure of how you got there. The forest you are in has been\n" +
                "known for it's strange properties; all adventurers who enter the forest never return as the same\n" +
                "person...or even return at all. As you rub the sleep out of your eyes, you begin to remember who you" +
                " are.\n");
        chooseCharacter();

        System.out.println("\"After you remember your name and your past, you get up and begin to search The Enchanted Forest,\n" +
                "but suddenly you hear a noise from behind you!\"");
    }

    private static String chooseCharacter(){
        Scanner scanner = new Scanner(System.in);
        String userChoice = "NumberChoice";
        String userCharacter = "defaultCharacter";
        boolean running = true;
        while(running) {
            System.out.println("You are...:\n" +
                    "[1] The Brave Warrior\n" +
                    "[2] The Persistent Mage\n" +
                    "[3] The Agile Thief\n" +
                    "[4] The Empathetic Cleric\n" +
                    "[5] The Lone Witch Hunter");
            userChoice = scanner.nextLine();
            if (userChoice.equals("1")) {
                userCharacter = "Warrior";
                System.out.println("\"You are the warrior, a person full of bravery and driven by your passion to protect others. You came\n" +
                        "to the forest to ease the worries of the citizens of your kingdom, who are terrified of the Enchanted Forest.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("2")) {
                userCharacter = "Mage";
                System.out.println("You are the mage, a talented user of magic with an insatiable thirst for knowledge. Everyone called\n" +
                        "you crazy for coming here, but you are determined to find the Revival Stone, an ancient artifact that\n" +
                        "can revive anyone from the dead. To obtain it is the ultimate quest for any mage.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("3")) {
                userCharacter = "Thief";
                System.out.println("You are the thief, a mischievous person who came to the forest in hopes of finding treasure that\n" +
                        "adventurers have left behind over the years to sell at the market. You aren't scared of the forest,\n" +
                        "as you can rely on your agility to get you out of any situation.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("4")) {
                userCharacter = "Cleric";
                System.out.println("You are the cleric, a kindhearted individual who came to the forest in search for a rare magical\n" +
                        "herb that can be ground up into medicine. You came here to heal a sick loved one that you care dearly\n" +
                        "about.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("5")) {
                userCharacter = "Witch Hunter";
                System.out.println("You are the witch hunter and you know exactly why you're here. You came to hunt down the witch of\n" +
                        "The Enchanted Forest, the person who has been terrorizing your kingdom for years. You're a lone wolf,\n" +
                        "as many of the citizens don't like your personality and aren't a fan of your aggressive tactics.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else {
                System.out.println("Please enter a valid number");
            }

        }
        System.out.println("line 83: " + userCharacter);

        String userReply;
        String userInput = "defaultName";
//        String userCharacter = "defaultCharacter";
        do {
            System.out.println("You also begin to remember your name...");
            System.out.println("Enter a name: ");
            userInput = scanner.nextLine();
            System.out.println("You entered " + userInput + ". Are you sure you want that to be your name? [Y/N]");
            userReply = scanner.nextLine();
        }while(userReply.equalsIgnoreCase("N"));
        System.out.println("You are " + userInput + " the " + userCharacter);

        Character userChar;

        //Instantiating class based on input given before
        //Passing in userInput as name and userCharacter as profession for each

        if (userCharacter.equals("Warrior")) {
            userChar = new Warrior(userInput, userCharacter);
        }
        else if(userCharacter.equals("Mage")) {
            userChar = new Mage(userInput, userCharacter);
        }
        else if(userCharacter.equals("Thief")) {
            userChar = new Thief(userInput, userCharacter);
        }
        else if(userCharacter.equals("Cleric")) {
            userChar = new Cleric(userInput, userCharacter);
        }
        else {
            userChar = new WitchHunter(userInput, userCharacter);
        }

        return "You are " + userChar.getName() + " the " + userChar.getProfession() + "!";  //need to get the character...

    }



    //how would we play the game? after the user selects their character, enters their name etc

    //Rhi Response: Java does everything in order, so if you look at line 15-16 that I added, that part will ONLY activate
    // after the character selection and that's how the rest of the game goes on.
    //Right under those new lines you can create a fightGoblin method that will let the user fight an enemy and so on.


    //then we would have to instantiate whatever character they pick. Each character needs their own method like the console game, since they
    //will have different options...

    //Rhi Response: Merged chooseCharacter and enterName together. Properly returns usercharacter and userinput now.
    //All info is in one easy to grab spot! Also made instantiation methods on lines 104-120. Changes on all
    //class files made as well to accommodate.


    public static void main(String[] args) {
        beginGame();

    }
}
