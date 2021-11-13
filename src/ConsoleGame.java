import java.util.Random;
import java.util.Scanner;

public class ConsoleGame {

    public static void main(String[] args) {

        //pull in scanner and random
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Enemy variables
        int enemyAttackDamage = 25;

        //Player variables
        int playerAttackDamage = 45;

        boolean running = true;  //set this to true for your while loop

        System.out.println("\t*** Welcome to the Witch's Lair ***");
        System.out.println("\t*** The evil witch has enslaved you as her apprentice and you must escape from her! ***");

        OUTER:           //this is to label the while loop
        while(running){
            int enemyHealth = 75;
            int playerHealth = 100;
            int magicBall = 1;

            System.out.println("\t*********************************************");
            System.out.println("\t*** While the witch was out gathering wild roots for her potions, you have gathered weapons and her magic ball which can be used once to heal yourself. You hear her coming, ***");

            while(enemyHealth > 0) {
                System.out.println("\t*** What would you like to do: ");
                System.out.println("1. Attack");
                System.out.println("2. Use the magic ball");
                System.out.println("3. hide");

                String userInput1 = input.nextLine();
                if (userInput1.equals("1")) {
                    int damageDealt = rand.nextInt(playerAttackDamage);  //this will generate a random number bw 0 and 45
                    int damageTaken = rand.nextInt(enemyAttackDamage);   //this will be a random number bw 0 and 25

                    enemyHealth -= damageDealt;  //5 health, attack 10 -- -5 //if the damageDealt > enemyHealth then break "congrats
                    playerHealth -= damageTaken;

                    System.out.println("\t*** You strike the witch for " + damageDealt + " damage. Her remaining health is " + enemyHealth);
                    System.out.println("\t*** You receive " + damageTaken + " damage. Your remaining health is " + playerHealth);

                    if(playerHealth < 1){
                        System.out.println("\t*** You have taken too much damage and are too weak to go on. The witch has turned you into a toad.");
                        break;
                    }
                } else if (userInput1.equals("2")){
                    if(magicBall > 0){
                        playerHealth += 50;
                        magicBall--;
                        System.out.println("\t*** You use the magic ball and increase your health by 50. You now have " + playerHealth + " health, and you have " + magicBall + " magic balls left.\n");
                    } else {
                        System.out.println("\t*** You don't have any magic balls left!");
                    }
                } else if (userInput1.equals("3")){
                    System.out.println("\t*** Not everyone is brave; you cowardly hide behind the curtains.");
                    System.out.println("\t********************* Better luck next time **********************");

                    continue OUTER;    //this loops back to the first while loop that we labeled outer
                } else {
                    System.out.println("*** invalid command");
                }
            }
            if(playerHealth < 1){
                System.out.println("*** You did not defeat the witch, enjoy life as a toad.");
                break;
            }
            System.out.println("*******************************");
            System.out.println("*** The witch was defeated! ***");
            System.out.println("*******************************");

            System.out.println("What would you like to do now?");
            System.out.println("1. Play again");
            System.out.println("2. Quit");

            String userInput = input.nextLine();

            while(!userInput.equals("1") && !userInput.equals("2")){   //this is to validate that they entered a 1 or 2
                System.out.println("Invalid Command!");
                userInput = input.nextLine();
            }
            if(userInput.equals("1")){
                System.out.println("## Good luck!");
            } else if (userInput.equals("2")){
                System.out.println("## Thanks for playing!");
                break;
            }
        }
        System.out.println("******************************");
        System.out.println("******Thanks for Playing******");
        System.out.println("******************************");
    }
}

//adapted from an online tutorial from codecourse, https://www.youtube.com/watch?v=EpB9u4ItOYU
//October-November 2021