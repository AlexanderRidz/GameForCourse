package Creatures.NPC;

import Creatures.logic.Creature;

public class Trader extends Creature {

    public Trader() {
        super.setName("Jordan Golds");
        super.setPower(40);
        super.setHp(1000);
        super.setDexterity(33);
        super.setGold(getRandomIntegerBetweenRange(1600, 4000));
    }

}
