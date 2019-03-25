package dev.warrensnipes.cashregisterserver.objs;

import dev.warrensnipes.cashregisterserver.enums.TransactionResponse;
import dev.warrensnipes.cashregisterserver.interfaces.ITransaction;

public class Transaction implements ITransaction {

    private Client client;
    private CashRegister cashRegister;

    public Transaction(Client client, CashRegister cashRegister) {
        this.client = client;
        this.cashRegister = cashRegister;
    }

    @Override
    public TransactionResponse doTransaction() {
        double cost = client.getCart().entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
        if (cost > client.getMoney()) {
            return TransactionResponse.CLIENT_NO_MONEY;
        }
        if (cost > cashRegister.getMoney()) {
            return TransactionResponse.CASHIER_NO_MONEY;
        }
        client.setMoney(client.getMoney() - cost);
        cashRegister.setMoney(cashRegister.getMoney() + cost);
        client.getCart().clear();
        return TransactionResponse.SUCCESS;
    }
}
