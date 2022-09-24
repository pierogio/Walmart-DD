package classes;

import classes.Character;
import interfaces.Attacker;

public class Warriors extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warriors(String name, int hp, int stamina, int strength) {
        super(name, hp);
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
    public int Attack() {
        return 0;
    }

    @Override
    public int Damage(int damage) {
        return 0;
    }
}
