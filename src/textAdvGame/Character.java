package textAdvGame;

public class Character {
    private String name;
    private String profession;
    private int attackDamage;
    private int playerHealth;

    //default constructor
    public Character(){}

    //Rhi Comment: Every character will have a profession, so I added the profession
    //string, getProfession and setProfession method.

    //constructor
    public Character (String name, String profession){
        this.name = name;
        this.profession = profession;

        this.playerHealth = playerHealth;
        this.attackDamage = attackDamage;
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

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
}
