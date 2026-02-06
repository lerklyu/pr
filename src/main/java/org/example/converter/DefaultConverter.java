package org.example.converter;

import org.example.working_with_file.JsonFIleRatesGetter;
import org.example.communication_with_users.ConsoleUserInterface;
import java.io.FileNotFoundException;

public class DefaultConverter implements Converter {
ConsoleUserInterface consoleUserInterface;
JsonFIleRatesGetter jsonFIleRatesGetter;

    public DefaultConverter(ConsoleUserInterface consoleUserInterface, JsonFIleRatesGetter jsonFIleRatesGetter) {
        this.consoleUserInterface = consoleUserInterface;
        this.jsonFIleRatesGetter = jsonFIleRatesGetter;
    }

    @Override
    public void convert() throws FileNotFoundException {
        while (true) {
            try {
                double rubles = Double.parseDouble(consoleUserInterface.getFromUser());
                double result =rubles / jsonFIleRatesGetter.getExchangeRates();
                System.out.printf("По курсу на данный момент выходит: %.2f%n", result);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неправильный формат числа");
            }
        }
    }
}
