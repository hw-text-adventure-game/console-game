package textAdvGame.Characters;
import textAdvGame.*;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;

import java.util.ArrayList;
import java.util.Scanner;

public class Character implements AttackOptions {
    private String name;
    private String profession;
    private int attackDamage;
    private int playerHealth;
    boolean alive = true;

    //default constructor
    public Character(){}

    //Rhi Comment: Every character will have a profession, so I added the profession
    //string, getProfession and setProfession method.

    //constructor
    public Character (String name, String profession){
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public void attackMenu() {
    }

    public void showInventory(ArrayList<String> characterInventory) {

        if(!characterInventory.isEmpty()) {
            for(String item : characterInventory) {
                System.out.println(item);
            }
        }  else {
            System.out.println("You have nothing in your inventory.");
        }
    }


    public boolean getStatus() {
        return alive;
    }


    public String personalMessage1() {
        return null;
    }

    public String oldManResponse1() {
            return null;
    }

    public static Character chooseCharacter(){
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
                        "to the forest to ease the worries of the citizens of your kingdom, who are terrified of the Enchanted Forest.\"\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("2")) {
                userCharacter = "Mage";
                System.out.println("\"You are the mage, a talented user of magic with an insatiable thirst for knowledge. Everyone called\n" +
                        "you crazy for coming here, but you are determined to find the Revival Stone, an ancient artifact that\n" +
                        "can revive anyone from the dead. To obtain it is the ultimate quest for any mage.\"\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("3")) {
                userCharacter = "Thief";
                System.out.println("\"You are the thief, a mischievous person who came to the forest in hopes of finding treasure that\n" +
                        "adventurers have left behind over the years to sell at the market. You aren't scared of the forest,\n" +
                        "as you can rely on your agility to get you out of any situation.\"\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("4")) {
                userCharacter = "Cleric";
                System.out.println("\"You are the cleric, a kindhearted individual who came to the forest in search for a rare magical\n" +
                        "herb that can be ground up into medicine. You came here to heal a sick loved one that you care dearly\n" +
                        "about.\"\n");
                System.out.println("\tAre you sure this is who you are? [Y/N]");
                String yesNo = scanner.nextLine();
                if(yesNo.equalsIgnoreCase("Y")){
                    break;
                }
            } else if (userChoice.equals("5")) {
                userCharacter = "Witch Hunter";
                System.out.println("\"You are the witch hunter and you know exactly why you're here. You came to hunt down the witch of\n" +
                        "The Enchanted Forest, the person who has been terrorizing your kingdom for years. You're a lone wolf,\n" +
                        "as many of the citizens don't like your personality and aren't a fan of your aggressive tactics.\"\n");
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
        String userInput = "defaultName";
//        String userCharacter = "defaultCharacter";
        do {
            System.out.println("You also begin to remember your name...");
            System.out.println("Enter a name: ");
            userInput = scanner.nextLine();
            System.out.println("You entered " + userInput + ". Are you sure you want that to be your name? [Y/N]");
            userReply = scanner.nextLine();
        }while(userReply.equalsIgnoreCase("N"));

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

        userChar.setName(userInput);
        userChar.setProfession(userCharacter);

        System.out.println("You are " + userChar.getName() + " the " + userChar.getProfession() + "!");
        return userChar;

    }



    //FIGHTS

    public void attackMenu(Enemy firstEnemy, ArrayList<String> inventory) {
    }

    public String personalDesire() {
        return null;
    }

}
