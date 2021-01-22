package com.company.players;

public class Golem extends Hero {


    public Golem(int health, int damage, String name, SuperAbility superAbility) {
        super(health, damage, name, superAbility.DOUBLE_ARROW);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boss.setHealth(((this.getHealth() - boss.getDamage())/2) + this.getDamage());
        System.out.println();
    }
}
