package com.company.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage, String name, SuperAbility superAbility) {
        super(health, damage, name, superAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            Random random = new Random();
            int increase = random.nextInt(10); {
                if (heroes[i].getHealth() > 0) {
                    int h = heroes[i].getDamage() * increase;
                    heroes[i].setDamage(heroes[i].getDamage() + h);
                    System.out.println(this.getName() + " увеличивает атаку героев на " + h);

                }
            }


        }

    }
}
