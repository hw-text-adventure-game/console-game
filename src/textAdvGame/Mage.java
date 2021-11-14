package textAdvGame;

import java.util.Random;

public class Mage extends Character{
    private int playerHealth = 100;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage = random.nextInt(6) + 15;

    public Mage(String name){
        super(name);
    }

    //mage also has a trait for perseverance, 25% chance to do a second attack
    //(give the player an extra turn)

    //if(random.nextInt(100) < secondAttackChance{ do the attackmethod again}
    private int secondAttackChance = 25;
}
