package textAdvGame;

import java.util.Random;

public class WitchHunter extends Character{
    private int playerHealth = 120;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage = random.nextInt(6) + 20;

    public WitchHunter(String name){
        super(name);
    }

    //witch hunter has a trait for adaptability, 25% chance to dodge an attack/cancel out the enemy attack
    //if(random.nextInt(100) < dodgeChance{ add back whatever health amount was deducted}
    private int dodgeChance = 25;


}

