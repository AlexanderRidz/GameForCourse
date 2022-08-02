package Creatures.mobs;

import Creatures.logic.Creature;

public class KingOfDeath extends Creature {
    public KingOfDeath() {
        super.setLvl(getRandomIntegerBetweenRange(7, 9));
        super.setName("King Of Death Lv." + getLvl());
        super.setPower((int) (15 + (getLvl()*2.5)));
        super.setDexterity((int) (10 + (getLvl()*2)));
        super.setHp(80 + (getLvl()*9));
        super.setGold((int) ((50 + getLvl())*1.4));
        super.setExp(30 + getLvl()*5);
    }
}
