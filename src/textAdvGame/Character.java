package textAdvGame;

public class Character {
    private String name;
    private int attackDamage;
    private int playerHealth;

    //default constructor
    public Character(){}

    //constructor
    public Character (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
}
