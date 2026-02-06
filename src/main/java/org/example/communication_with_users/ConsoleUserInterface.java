package org.example.communication_with_users;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void showToUser(String text) {
        System.out.println(text);
    }

    @Override
    public String getFromUser() {
        return scanner.nextLine();
    }
}
