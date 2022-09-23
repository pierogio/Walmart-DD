import Classes.Character;
import Interfaces.Attacker;

public class Warriors extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warriors(String name, int hp, boolean isAlive, int stamina, int strength) {
        super(name, hp, isAlive);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int damage(int damage) {
        return 0;
    }
}
