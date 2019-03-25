package dev.warrensnipes.cashregisterserver.interfaces;

import dev.warrensnipes.cashregisterserver.enums.TransactionResponse;

public interface ITransaction {

    TransactionResponse doTransaction();

}
