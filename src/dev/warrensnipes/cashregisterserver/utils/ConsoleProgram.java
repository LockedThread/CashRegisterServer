package dev.warrensnipes.cashregisterserver.utils;

import java.util.Scanner;

public class ConsoleProgram {

    private Scanner scanner;

    public ConsoleProgram() {
        scanner = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}