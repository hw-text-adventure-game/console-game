package textAdvGame;

import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;

public interface AttackOptions {

    void attackMenu(); //Gives each character type a unique attack menu
    String personalMessage1(); //Gives each character type a unique message

    void attackMenu(Enemy firstEnemy, ArrayList<String> inventory); //Same as attack menu but pass in unique enemy and inventory
}
