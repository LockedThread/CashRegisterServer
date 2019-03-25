package dev.warrensnipes.cashregisterserver.objs;

public class CashRegister {

    private double money;

    public CashRegister(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
