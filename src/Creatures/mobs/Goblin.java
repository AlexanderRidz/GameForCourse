package Creatures.mobs;

import Creatures.logic.Creature;

public class Goblin extends Creature {
    public Goblin(){
        super.setLvl(Creature.getRandomIntegerBetweenRange(1,2));
        super.setName("Creatures.mobs.Goblin lv." + getLvl());
        super.setPower((int) (5 + getLvl()*1.6));
        super.setDexterity((int) (8 + getLvl()*1.5));
        super.setHp((int) (30 + getLvl()*1.4));
        super.setGold((int) (20 + getLvl()*1.6));
        super.setExp(10 + getLvl()*3);
    }
}
