package com.company.players;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name, SuperAbility superAbility) {
        super(health, damage, name, superAbility.CRITICAL_DAMAGE );
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int random = 2 + r.nextInt(2);
        if (this.getHealth() > 0){
            int temp = this.getDamage() * random;
            boss.setHealth((boss.getHealth() + this.getDamage()) - temp);
            System.out.println(this.getName() + " критует на " + temp + " урона");
        }
    }

}


