package Creatures.mobs;

import Creatures.logic.Creature;

public class Skeleton extends Creature {

    public Skeleton() {
        super.setLvl(getRandomIntegerBetweenRange(2, 3));
        super.setName("Creatures.mobs.Skeleton Lv." + getLvl());
        super.setPower((7 + (getLvl()*2)));
        super.setDexterity((int) (6 + (getLvl()*1.5)));
        super.setHp((int) (45 + (getLvl()*1.5)));
        super.setGold((int) ((35 + getLvl())*1.2));
        super.setExp(13 + getLvl()*3);
    }

}
