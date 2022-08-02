package Creatures.logic;

public abstract class Creature implements Fighter<Creature> {
    private String name;
    private int hp;
    private int power;
    private int gold;
    private int dexterity;
    private int exp;
    private int lvl;
    private int critChanse = 0;


    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    @Override
    public void damage(Creature creature) {
        int totalDamage = this.getPower();
        if((getDexterity() * 3) > getRandomIntegerBetweenRange(0,100)) {
            if ((creature.getHp() - totalDamage) > 0) {
                creature.setHp(creature.getHp() - totalDamage);
                System.out.println(this.getName() + " caused "
                        + totalDamage
                        + " damage for "
                        + creature.getName());
            } else {
                creature.setHp(0);
                System.out.println(creature.getName() + " was dead! \n" +
                        getName() + " win!!!");
            }
        } else System.out.println(getName() + " missed =(");
    }

    @Override
    public void getDamage(Creature creature) {
        this.setHp(this.getHp() - creature.getPower());
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if((this.gold + gold) >= 0) {
            this.gold = gold;
        } else this.gold = 0;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        if(dexterity <= 33 && dexterity > 0) {
            this.dexterity = dexterity;
        } else if (dexterity > 33){
            this.dexterity = 33;
            System.out.println("Max dexterity!");
        }
    }


    public int getCritChanse() {
        return critChanse;
    }

    public void setCritChanse(int critChanse) {
        if ((critChanse > 50)) {
            this.critChanse = 50;
            System.out.println("Max critChanse! " + this.critChanse);
        } else if ((critChanse >= 0) && (critChanse <= 50)) {
            this.critChanse = critChanse;
        }
    }

}
