package com.company.players;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, String name, SuperAbility superAbility, int healPoints) {
        super(health, damage, name, superAbility);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0){
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
                System.out.println(this.getName() + " вылечил на " + healPoints);
            }

        }

    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
