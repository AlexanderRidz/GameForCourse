package Creatures.player;

import Creatures.logic.Creature;

public class Hero extends Creature {
    private int expForNextLvl = 100;
    private int MAX_HP = 100;

    public Hero(String name) {
        super.setLvl(1);
        super.setName(name);
        super.setPower(10);
        super.setHp(MAX_HP);
        super.setDexterity(16);
        super.setGold(0);
        System.out.println("Creatures.player.Hero " + name + " has been created!");
    }

    public void lvlUp() {
        setLvl(getLvl() + 1);
        MAX_HP = MAX_HP + 20;
        setHp(MAX_HP);
        setDexterity(getDexterity() + 1);
        setGold((int) (getGold() + 100 * getLvl()/1.5));
        setPower(getPower() + 1);
        System.out.println("Congratulations! You have level up!!!\n" +
                "Now your Lvl: " + getLvl() + "\n " +
                "Now your max hp: " + getHp() + "\n" +
                "Now your dex: " + getDexterity() + "\n" +
                "Now your gold: " + getGold() + "\n" +
                "Now your power: " + getPower() + "\n" +
                "Now your need " + expForNextLvl + " to next lvl!");
    }

    @Override
    public void setHp(int hp) {
        if (hp <= MAX_HP) {
            super.setHp(hp);
        } else super.setHp(MAX_HP);
    }

    @Override
    public void setExp(int exp) {
        if (exp >= expForNextLvl) {
            super.setExp(0);
            expForNextLvl = (int) (expForNextLvl + (100 * (getLvl() * 0.1)));
            lvlUp();
        } else if (exp > 0) {
            super.setExp(exp);
        }
    }

    @Override
    public void setLvl(int lvl) {
        if (lvl > getLvl()) {
            super.setLvl(lvl);
        }
    }

    @Override
    public void damage(Creature creature) {
        int totalDamage = getPower();
        if ((getDexterity() * 3) > getRandomIntegerBetweenRange(0, 100)) {
            if ((creature.getHp() - totalDamage) > 0) {
                if (getRandomIntegerBetweenRange(1, 100) <= getCritChanse()) {
                    if ((creature.getHp() - totalDamage * 2) > 0) {
                        creature.setHp(creature.getHp() - totalDamage * 2);
                        System.out.println(getName() + " Lv." + getLvl() + " CAUSED " + (totalDamage * 2) + " CRITICAL DAMAGE " +
                                creature.getName());
                    } else {
                        System.out.println(getName() + " Lv." + getLvl() + " CAUSED " + (totalDamage * 2) + " CRITICAL DAMAGE " +
                                creature.getName());
                        creature.setHp(0);
                        System.out.println(creature.getName() + " was dead! \n" +
                                getName() + " win!!!");
                        setGold(getGold() + creature.getGold());
                        System.out.println("You find " + creature.getGold() + " gold \n" +
                                "Now you have: " + getGold());
                        System.out.println("You got " + creature.getExp() + " Exp.\n" +
                                "Now you have: " + (this.getExp() + creature.getExp()));
                        setExp(this.getExp() + creature.getExp());
                    }
                } else {
                    creature.setHp(creature.getHp() - totalDamage);
                    System.out.println(getName() + " Lv." + getLvl() + " caused "
                            + totalDamage
                            + " damage for "
                            + creature.getName());
                }
            } else {
                creature.setHp(0);
                System.out.println(creature.getName() + " was dead! \n" +
                        getName() + " win!!!");
                setGold(getGold() + creature.getGold());
                System.out.println("You find " + creature.getGold() + " gold \n" +
                        "Now you have: " + getGold());
                System.out.println("You got " + creature.getExp() + " Exp.\n" +
                        "Now you have: " + (this.getExp() + creature.getExp()));
                setExp(this.getExp() + creature.getExp());
            }
        } else System.out.println(getName() + " missed =(");
    }

    public void getInfo() {
        System.out.println("Name: " + getName() +
                "\nLvl: " + getLvl() +
                "\nExp: " + getExp() +
                "\nFor next lvl need exp: " + expForNextLvl +
                "\nGold: " + getGold() +
                "\nDex: " + getDexterity() +
                "\nPower: " + getPower() +
                "\nHp: " + getHp() +
                "\n-----------");
    }
}
