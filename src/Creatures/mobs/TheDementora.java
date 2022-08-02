package Creatures.mobs;

import Creatures.logic.Creature;

public class TheDementora extends Creature {
    public TheDementora() {
        super.setLvl(getRandomIntegerBetweenRange(8, 9));
        super.setName("The Dementora Lv." + getLvl());
        super.setPower((15 + (getLvl()*2)));
        super.setDexterity((int) (8 + (getLvl()*2)));
        super.setHp((int) (100 + (getLvl()*10)));
        super.setGold((int) ((50 + getLvl())*1.5));
        super.setExp(34 + getLvl()*5);
    }
}
