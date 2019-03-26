package dev.warrensnipes.cashregisterserver;

import dev.warrensnipes.cashregisterserver.enums.ItemType;
import dev.warrensnipes.cashregisterserver.objs.CashRegister;
import dev.warrensnipes.cashregisterserver.objs.Client;
import dev.warrensnipes.cashregisterserver.objs.Item;
import dev.warrensnipes.cashregisterserver.objs.Transaction;
import dev.warrensnipes.cashregisterserver.utils.ConsoleProgram;
import dev.warrensnipes.cashregisterserver.utils.MapBuilder;
import dev.warrensnipes.cashregisterserver.utils.Questionnaire;
import dev.warrensnipes.cashregisterserver.utils.Utils;

import java.util.*;

public class CashRegisterServer {

    private List<CashRegister> cashRegisters;
    private Map<String, Item> itemMap;

    private CashRegisterServer() {
        setupItems();
        setupRegisters();
        ConsoleProgram consoleProgram = new ConsoleProgram();
        HashMap<Integer, String> questions = new MapBuilder<Integer, String>()
                .put(0, "What cash register would you like to go to? (1-4)")
                .put(1, "What's in your cart? Separate what's in your cart by a comma and space and the amount of that item by a colon.")
                .put(2, "How much money do you have?")
                .build();
        Questionnaire questionnaire = new Questionnaire(questions);
        Client client = null;
        CashRegister cashRegister;

        String registerString = consoleProgram.readLine("What cash register would you like to go to? (1-4)");
        if (Utils.isInt(registerString)) {
            cashRegister = cashRegisters.get(Integer.parseInt(registerString));
            questionnaire.increment();
        } else {
            System.out.println("Unable to parse " + registerString + " as a integer!");
            return;
        }

        String cartString = consoleProgram.readLine("What's in your cart? Separate what's in your cart by a comma and space and the amount of that item by a colon.");

        HashMap<Item, Integer> cart = new HashMap<>();
        String[] items = cartString.split(", ");
        for (String itemString : items) {
            String[] split = itemString.split(":");
            Item item = itemMap.get(split[0]);
            if (item == null) {
                System.out.println("Unable to find Item called \"" + itemString + "\".");
                return;
            }
            if (Utils.isInt(split[1])) {
                cart.computeIfPresent(item, (item1, integer) -> integer + Integer.parseInt(split[1]));
                cart.putIfAbsent(item, Integer.parseInt(split[1]));
            } else {
                System.out.println("Unable to parse " + split[1] + " as an integer.");
            }
        }
        client = new Client(cart, 0.0);
        System.out.println("Your cart:\n" + client.getCartAsString());

        String moneyString = consoleProgram.readLine("How much money do you have?");
        if (Utils.isDouble(moneyString)) {
            client.setMoney(Double.parseDouble(moneyString));
        } else {
            System.out.println("Unable to parse " + moneyString + " as a Double.");
            return;
        }

        Transaction transaction = new Transaction(client, cashRegister);
        System.out.println(transaction.doTransaction().getMessage());
    }

    public static void main(String[] args) {
        new CashRegisterServer();
    }

    private void setupItems() {
        itemMap = new MapBuilder<String, Item>()
                .put("apple", new Item(ItemType.FRUIT, "apple", 2.00))
                .put("cucumber", new Item(ItemType.VEGETABLE, "cucumber", 4.00))
                .put("chocolate cake", new Item(ItemType.BAKERY, "chocolate cake", 20.00))
                .put("snickers bar", new Item(ItemType.CANDY, "snickers bar", 1.50))
                .put("gouda cheese", new Item(ItemType.DELI, "gouda cheese", 3.00))
                .put("captain crunch", new Item(ItemType.CEREAL, "captain crunch", 4.00))
                .build();
    }

    private void setupRegisters() {
        this.cashRegisters = new ArrayList<>(Arrays.asList(new CashRegister(140.0), new CashRegister(200.0), new CashRegister(129.0), new CashRegister(736.0)));
    }
}
