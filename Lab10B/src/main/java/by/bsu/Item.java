package by.bsu;

import java.util.Objects;
import java.util.StringJoiner;

public class Item {
    private String itemName;
    private int itemHash;

    public Item() {
        super();
    }

    public Item(String itemName) {
        this.itemName = itemName;
        this.itemHash = itemName.hashCode();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
        this.itemHash = itemName.hashCode();
    }

    public int getItemHash() {
        return itemHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemHash == item.itemHash &&
                itemName.equals(item.itemName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("itemName='" + itemName + "'")
                .add("itemHash=" + itemHash + 7)
                .toString();
    }
}
