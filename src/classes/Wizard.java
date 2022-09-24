package classes;

import interfaces.Attacker;

public class Wizard extends Character implements Attacker {

    int mana;
    int intelligence;

    private final int FIREBALL_ATTACK_COST = 5;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int Attack() {
        return mana > FIREBALL_ATTACK_COST ? FireballAttack() : StaffHitAttack();
    }

    private int FireballAttack() {
        this.mana -= FIREBALL_ATTACK_COST;
        return this.intelligence;
    }

    private int StaffHitAttack() {
        this.mana += 1;
        return 2;
    }

    public String toString() {
        return "Wizard{" +
                "name=" + super.getName() +
                "mana=" + mana +
                ", intelligence=" + intelligence +
                ", FIREBALL_ATTACK_COST=" + FIREBALL_ATTACK_COST +
                '}';
    }


    public int Damage(int damage) {
        if (super.getHp() > damage) super.setHp(getHp()-damage);
        else {
            super.setHp(0);
            super.setIsAlive(false);
        }
        return 0;
    }
}
