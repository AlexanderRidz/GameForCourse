package Creatures.mobs;

import Creatures.logic.Creature;

public class Angel_0 extends Creature {

    public Angel_0() {
        super.setLvl(10);
        super.setName("BOSS The Creatures.mobs.Angel_0 Lv.INFINITY");
        super.setPower(20 + (getLvl() * 2));
        super.setDexterity(5 + (getLvl() * 2));
        super.setHp(300 + (getLvl() * 20));
        super.setGold((1000 + getLvl()) * 150);
        super.setExp(1900 + getLvl() * 50);
    }


}
