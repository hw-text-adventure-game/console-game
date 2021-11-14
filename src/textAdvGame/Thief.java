package textAdvGame;

import java.util.Random;

public class Thief extends Character{
    private int playerHealth = 120;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage = random.nextInt(6) + 20;

    public Thief(String name){
        super(name);
    }

    //also has a trait for agility, run away from battle, can be used 3 times to "cancel" a fight
    private int agility = 3;

}
