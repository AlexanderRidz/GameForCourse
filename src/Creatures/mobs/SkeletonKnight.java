package Creatures.mobs;

import Creatures.logic.Creature;

public class SkeletonKnight extends Creature {

    public SkeletonKnight() {
        super.setLvl(getRandomIntegerBetweenRange(3, 6));
        super.setName("Creatures.mobs.SkeletonKnight Lv." + getLvl());
        super.setPower((9 + (getLvl()*2)));
        super.setDexterity((int) (6 + (getLvl()*1.5)));
        super.setHp((int) (60 + (getLvl()*1.5)));
        super.setGold((int) ((35 + getLvl())*1.4));
        super.setExp(13 + getLvl()*4);
    }

}
