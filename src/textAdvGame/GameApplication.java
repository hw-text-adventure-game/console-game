package textAdvGame;

import java.util.Scanner;

public class GameApplication {

    public static void beginGame(){
        System.out.println("\"You wake up in the Enchanted Forest, unsure of how you got there. The forest you are in has been\n" +
                "known for it's strange properties; all adventurers who enter the forest never return as the same\n" +
                "person...or even return at all. As you rub the sleep out of your eyes, you begin to remember who you" +
                " are.\n" +
                "You are...:\n" +
                "[1] The Brave Warrior\n" +
                "[2] The Persistent Mage\n" +
                "[3] The Agile Thief\n" +
                "[4] The Empathetic Cleric\n" +
                "[5] The Lone Witch Hunter");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        beginGame();

        boolean running = true;
        while(running) {
            System.out.println("Select a number 1 to 5 to choose your character.");
            String userChoice = scanner.nextLine();
            if (userChoice.equals("1")) {
                System.out.println("\"You are the warrior, a person full of bravery and driven by your passion to protect others. You came\n" +
                        "to the forest to ease the worries of the citizens of your kingdom, who are terrified of the Enchanted Forest.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("2")) {
                System.out.println("You are the mage, a talented user of magic with an insatiable thirst for knowledge. Everyone called\n" +
                        "you crazy for coming here, but you are determined to find the Revival Stone, an ancient artifact that\n" +
                        "can revive anyone from the dead. To obtain it is the ultimate quest for any mage.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("3")) {
                System.out.println("You are the thief, a mischievous person who came to the forest in hopes of finding treasure that\n" +
                        "adventurers have left behind over the years to sell at the market. You aren't scared of the forest,\n" +
                        "as you can rely on your agility to get you out of any situation.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("4")) {
                System.out.println("You are the cleric, a kindhearted individual who came to the forest in search for a rare magical\n" +
                        "herb that can be ground up into medicine. You came here to heal a sick loved one that you care dearly\n" +
                        "about.\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("5")) {
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
        String userReply;
        do {
            System.out.println("You also begin to remember your name...");
            System.out.println("Enter a name: ");
            String userInput = scanner.nextLine();
            System.out.println("You entered " + userInput + ". Are you sure you want that to be your name? [Y/N]");
            userReply = scanner.nextLine();
        }while(userReply.equalsIgnoreCase("N"));
        System.out.println("You are " + "userInput" + " the " + "userChoice!");  //need to get the userInput and userChoice, but it is scoped...

    }
}
