package com.company.players;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage, String name, SuperAbility superAbility) {
        super(health, damage, name, superAbility.STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int random = r.nextInt(3);
        if (random == 1 && this.getHealth() > 0 && boss.getHealth()>0) {
            boss.setDamage(0);
            System.out.println(this.getName() + " оглушил босса, в этом раунде босс не может бить ");
        }
        else {
            boss.setDamage(50);
        }
    }
}

