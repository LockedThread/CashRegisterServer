package dev.warrensnipes.cashregisterserver.enums;

public enum DollarBill {

    _1, _5, _10, _25, _50, _100;

    public double getValue() {
        try {
            return Double.valueOf(name().substring(1));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unable to get value of " + this, e);
        }
    }
}
