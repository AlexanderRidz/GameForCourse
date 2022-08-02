package Creatures.mobs;

import Creatures.logic.Creature;

public class Hobgoblin extends Creature {

    public Hobgoblin() {
        super.setLvl(getRandomIntegerBetweenRange(4, 7));
        super.setName("Creatures.mobs.Hobgoblin Lv." + getLvl());
        super.setPower((int)(9 + (getLvl()*2)));
        super.setDexterity((int) (7 + (getLvl()*1.5)));
        super.setHp((int) (65 + (getLvl()*1.5)));
        super.setGold((int) ((40 + getLvl())*2));
        super.setExp(18 + getLvl()*4);
    }

}
