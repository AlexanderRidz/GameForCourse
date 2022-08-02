package BattleLogic;

import Creatures.logic.Creature;
import Creatures.player.Hero;

public class Battle extends Thread {
    private Hero player;
    private Creature enemy;
    private boolean check = true;

    public Battle(Hero player, Creature enemy) {
        this.enemy = enemy;
        this.player = player;
    }

    private void endBattle(){
        this.check = false;
    }

    @Override
    public void run() {
        while (check == true) {
            while (player.getHp() > 0 && enemy.getHp() > 0) {
                try {
                    if (player.getHp() > 0) {
                        player.damage(enemy);
                        System.out.println(enemy.getName() + " hp: " + enemy.getHp() +
                                "\n ----------");
                        Thread.sleep(100);
                    }
                    if (enemy.getHp() > 0) {
                        enemy.damage(player);
                        System.out.println(player.getName() + " hp: " + player.getHp() +
                                "\n ----------");
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    System.out.println("BattleLogic.Battle has been stopped!");
                }
            }
            endBattle();
        }
    }
}

