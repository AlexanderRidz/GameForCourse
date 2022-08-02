package World;

import java.util.Scanner;

import BattleLogic.Battle;
import Creatures.NPC.Trader;
import Creatures.logic.Creature;
import Creatures.mobs.*;
import Creatures.player.Hero;
import StoreLogic.StoreItems;

public class World {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to the world, hero!");
        System.out.println("If you die - you will die on always!");
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Hero hero = new Hero(name);

        boolean check = true;
        while (check == true && hero.getHp() > 0) {
            System.out.println("What you want? " +
                    "\n 1.Go from Trader " +
                    "\n 2.Go from Forest of Fear " +
                    "\n 3.Check all info " +
                    "\n 4.Exit from game and suicide (T_T)");

            char command = scanner.nextLine().charAt(0);

            switch (command) {
                case '1' -> {
                    System.out.println("Going from Trader...");
                    Trader trader = new Trader();
                    StoreItems SI = new StoreItems();
                    System.out.println("Hello my dear client! My name is " + trader.getName() + ".\n" +
                            "What you want? \n" +
                            "today, i have this items:\n" +
                            "----------");
                    for (int i = 0; i < SI.storeItems.size(); i++) {
                        System.out.println((i + 1) + "." + SI.storeItems.get(i));
                    }
                    System.out.println("If you want to go, just turn \"3\"");
                    while (check == true) {
                        command = scanner.nextLine().charAt(0);
                        switch (command) {
                            case '1' -> {
                                if (hero.getGold() >= SI.storeItems.get(0).getPrice()) {
                                    hero.setGold((hero.getGold()) - SI.storeItems.get(0).getPrice());
                                    hero.setHp(hero.getHp() + (40 + (hero.getLvl() * 10)));
                                    System.out.println("Great! You buy heal potion! +" + (40 + hero.getLvl() * 10) + " heal points!");
                                    System.out.println("Hp is now: " + hero.getHp());
                                } else System.out.println("Have not money!");

                            }
                            case '2' -> {
                                switch (SI.storeItems.get(1).getItemName()) {
                                    case "CritStone" -> {
                                        if (hero.getGold() >= SI.storeItems.get(1).getPrice()) {
                                            hero.setCritChanse(hero.getCritChanse() + 5);
                                            System.out.println("CritChance now: +" + hero.getCritChanse() + "%");
                                            hero.setGold((hero.getGold()) - SI.storeItems.get(1).getPrice());
                                        } else System.out.println("Have not money!");
                                    }
                                    case "DexStone" -> {
                                        if (hero.getGold() >= SI.storeItems.get(1).getPrice()) {
                                            hero.setDexterity(hero.getDexterity() + 1);
                                            System.out.println("Dexterity now: " + hero.getDexterity());
                                            hero.setGold((hero.getGold()) - SI.storeItems.get(1).getPrice());
                                        } else System.out.println("Have not money!");
                                    }
                                    case "PowerStone" -> {
                                        if (hero.getGold() >= SI.storeItems.get(1).getPrice()) {
                                            hero.setPower(hero.getPower() + 1);
                                            System.out.println("Power now: " + hero.getPower());
                                            hero.setGold(hero.getGold() - SI.storeItems.get(1).getPrice());
                                        } else System.out.println("Have not money!");
                                    }
                                }
                            }
                            case '3' -> check = false;
                        }
                    }
                    check = true;
                }
                case '2' -> {
                    if (hero.getLvl() < 10) {
                        System.out.println("Going from Forest of Fear...");
                        Creature enemy = whatMob(hero);
                        Thread battle = new Battle(hero, enemy);
                        battle.start();
                        battle.join();
                    } else {
                        System.out.println("Teleporting from End Of The World.World...");
                        Creature enemy = whatMob(hero);
                        Thread battle = new Battle(hero, enemy);
                        battle.start();
                        battle.join();
                        if (hero.getHp() <= 0) {
                            System.out.println("The world has been destroyed...");
                        } else {
                            System.out.println("Congratulations!!! You saved the world!");
                            check = false;
                        }
                    }
                }
                case '3' -> hero.getInfo();
                case '4' -> {
                    System.out.println("Are you shure? \n 1.yes \n 2.no");
                    command = scanner.nextLine().charAt(0);
                    switch (command) {
                        case '1' -> check = false;
                        case '2' -> System.out.println("Nice =)");
                    }
                }
            }
        }
        System.out.println("Game was end (T_T) ");
    }

    public static Creature whatMob(Hero hero) {
        int what = (int) getRandom(1, 2);
        if (hero.getLvl() < 3)
            if (what == 1) {
                return new Goblin();
            } else if (what == 2) {
                return new Skeleton();
            }
        if (hero.getLvl() < 7) {
            if (what == 1) {
                return new SkeletonKnight();
            } else
                return new Hobgoblin();
        }
        if (hero.getLvl() < 10) {
            if (what == 1) {
                return new KingOfDeath();
            } else
                return new TheDementora();
        } else return new Angel_0();
    }

    public static double getRandom(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
}
