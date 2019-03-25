package dev.warrensnipes.cashregisterserver.objs;

import dev.warrensnipes.cashregisterserver.enums.ItemType;

public class Item {

    private final ItemType itemType;
    private final String name;
    private final double price;

    public Item(ItemType itemType, String name, double price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
