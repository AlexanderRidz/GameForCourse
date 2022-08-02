package StoreLogic;

public class BoxOfItems {
    private int price;
    private String itemName;
    private char itemChar;

    public BoxOfItems(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString(){
        return getItemName() + " , price: " + getPrice();
    }

    public int getPrice() {
        return price;
    }

}

