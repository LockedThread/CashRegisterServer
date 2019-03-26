package dev.warrensnipes.cashregisterserver.objs;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Client {

    private HashMap<Item, Integer> cart;
    private double money;

    public Client(HashMap<Item, Integer> cart, double money) {
        this.cart = cart;
        this.money = money;
    }

    public HashMap<Item, Integer> getCart() {
        return cart;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCartAsString() {
        return cart.entrySet().stream().map(entry -> entry.getKey().getName() + " - " + entry.getValue() + "\n").collect(Collectors.joining());
    }
}
