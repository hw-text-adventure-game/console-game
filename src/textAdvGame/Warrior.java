package textAdvGame;

import java.util.Random;

public class Warrior extends Character {
    private int playerHealth = 120;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage = random.nextInt(6) + 20; //random.nextInt(MAX-MIN) + MIN; //or from 0 to 5 shifted + 20

    public Warrior(String name){
        super(name);
    }


    //warrior also has a trait for bravery, 50% chance to do double damage
    //if(random.nextInt(100) < bravery { subtract the amount of damage dealt to the enemy again }
    private int bravery = 50; //50 percent chance to do double damage

}
