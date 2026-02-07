package org.example.userinterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    private Scanner scanner;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showToUser(String text) {
        System.out.println(text);
    }

    @Override
    public String getFromUser() {
        return scanner.nextLine();
    }
}
