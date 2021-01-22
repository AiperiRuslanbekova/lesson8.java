package com.company.game;

import com.company.players.*;

import javax.swing.table.TableRowSorter;

public class RPG_Game {
    public static void start(){
        Boss boss = new Boss (700, 50, "Босс");
        Warrior warrior = new Warrior(250, 15, "Воин", SuperAbility.CRITICAL_DAMAGE);
        Medic medic = new Medic( 230, 10, "Медик", SuperAbility.HEAL, 15);
        Magic magic = new Magic(270, 20, "Маг", SuperAbility.BOOST);
        Golem golem = new Golem(190,12,"Голем", SuperAbility.DOUBLE_ARROW);
        Berserk berserk = new Berserk(260,20,"Берсерк", SuperAbility.SAVE_DAMAGE_AND_REVERT);
        Tank tank = new Tank(220, 6,"Танк", SuperAbility.BLOCK);
        Thor thor = new Thor(280,40,"Тор", SuperAbility.STUN);
        Witcher witcher = new Witcher(250, 25,"Ведьмак", SuperAbility.RESURRECTION);
        Hero[] heroes = {warrior, medic, magic, golem, berserk, tank,thor,witcher};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss,heroes)) {
            round(boss,heroes);
        }
    }

    private static void printStatistics (Boss boss, Hero[] heroes) {
        System.out.println("---------");
        System.out.println("Boss health: " +  boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + "health: " + heroes[i].getHealth());
        }
        System.out.println("----------");
    }

    private static void round (Boss boss, Hero [] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHits (boss, heroes);
        applySuperAbility (boss, heroes);
        printStatistics (boss, heroes);
    }

    private static boolean isGameFinished (Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
           if (heroes[i].getHealth() > 0){
               allHeroesDead = false;
               break;
           }

        }

        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits (Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
               heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }

    }

    private static void heroesHits (Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());}

        }

    }

    private static void applySuperAbility (Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                heroes[i].applySuperAbility(boss, heroes);
            }

        }

    }

}
