package dev.warrensnipes.cashregisterserver.enums;

public enum TransactionResponse {

    CASHIER_NO_MONEY("Sorry, we have ran out of money. Please go to another cash register."),
    CLIENT_NO_MONEY("Sorry, you don't have enough money to purchase this."),
    SUCCESS("You have successfully purchased {cart}");

    private String message;

    TransactionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
