package com.company.players;

import java.util.Random;

public class Berserk extends Hero{
    public Berserk(int health, int damage, String name, SuperAbility superAbility) {
        super(health, damage, name, superAbility.SAVE_DAMAGE_AND_REVERT);
    }



    @Override
    public void applySuperAbility (Boss boss, Hero[] heroes) {
        Random random = new Random();
        int block = 5 + random.nextInt(15);
        boss.setHealth(boss.getHealth() - block);
        this.setHealth(this.getHealth() + block);
        System.out.println(this.getName() + " Заблокировал " + block + " и вернул " + (block + this.getDamage() + " урона"));

    }
}


