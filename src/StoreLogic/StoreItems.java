package StoreLogic;

import java.util.ArrayList;
import java.util.List;

public class StoreItems{
    public List<BoxOfItems> storeItems = new ArrayList<>();

    BoxOfItems potion = new BoxOfItems( "Potion", 40);
    BoxOfItems critStone = new BoxOfItems( "CritStone", 120);
    BoxOfItems dexStone = new BoxOfItems( "DexStone", 100 );
    BoxOfItems powerStone = new BoxOfItems( "PowerStone", 150);

    public StoreItems(){
        storeItems.add(potion);
        howItem();
    }

    private void howItem(){
        switch (getRandom(2,4)) {
            case 2 -> storeItems.add(critStone);
            case 3 -> storeItems.add(dexStone);
            case 4 -> storeItems.add(powerStone);
        }
    }

    public static int getRandom(int min, int max) {
        int x =(int)(Math.random() * ((max - min) + 1)) + min;
        return x;
    }
}