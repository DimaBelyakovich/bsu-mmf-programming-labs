package by.bsu.model.entity;

public class Item extends Entity{
    private final int itemId;
    private final String itemName;
    private final int itemWeight;

    public Item(int itemId, String itemName, int itemWeight) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    @Override
    public int hashCode() {
        return 179 * itemId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Item i = (Item) obj;
            return i.itemId == itemId;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", weight=" + itemWeight +
                '}';
    }
}
