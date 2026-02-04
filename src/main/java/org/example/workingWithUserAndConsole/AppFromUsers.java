package org.example.workingWithUserAndConsole;

import org.example.workingWithFile.JSONFileReader;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AppFromUsers implements UserInterface {

    Scanner sc = new Scanner(System.in);

    public void requestData(JSONFileReader jsonFileReader) {

        try {

            System.out.print("Enter the amount to convert to RUBLES: ");
            double rubles = sc.nextDouble();
            System.out.print("Enter the code currency: ");
            String codeUser = sc.next();
            for (Map.Entry<String, Double> entry : jsonFileReader.map.entrySet()) {
                if (entry.getKey().equals(codeUser)) {
                    double result = rubles / (Double) entry.getValue();
                    System.out.printf("%.2f%n", result);
                } else {
                    System.out.println("Wrong code");
                    sc.close();
                    break;
                }
            }

        } catch (InputMismatchException e) {

            System.out.println("The data input entered " +
                    "by the user does not match the expected data type ");

        }
    }
}
