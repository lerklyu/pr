package org.example;

import org.example.userinterface.ConsoleUserInterface;
import org.example.userinterface.UserInterface;
import org.example.converter.Converter;
import org.example.converter.DefaultConverter;
import org.example.ratesgetter.JsonFIleRatesGetter;
import org.example.ratesgetter.RatesGetter;

import java.nio.file.Path;

import static java.lang.Double.*;

public class App {

    private UserInterface userInterface;
    private RatesGetter ratesGetter;
    private Converter converter;
    
    public App(UserInterface userInterface, RatesGetter ratesGetter, Converter converter) {
        this.userInterface = userInterface;
        this.ratesGetter = ratesGetter;
        this.converter = converter;
    }

    void mainLogic() {
        double amountToConvert;
        double exchangeRateByCurrency;
        while (true) {
            userInterface.showToUser("Сумма для конвертации: ");
            try {
                amountToConvert = parseDouble(userInterface.getFromUser());
            } catch (RuntimeException e) {
                System.out.println("Неправильный формат числа");
                continue;
            }
            userInterface.showToUser("Код валюты для конвертации: ");
            String codeCurrency = userInterface.getFromUser();
            try {
                exchangeRateByCurrency = ratesGetter.getExchangeRates(codeCurrency);
            } catch (RuntimeException e) {
                System.out.println("Неправильный формат кода валюты");
                continue;
            }
            double conversionResult = converter.convert(amountToConvert, exchangeRateByCurrency);
            userInterface.showToUser("Эквивалент: " + String.format("%.2f", conversionResult));
        }
    }

    public static void main(String[] args) {

        UserInterface userInterface = new ConsoleUserInterface();
        RatesGetter ratesGetter = new JsonFIleRatesGetter(Path.of("src/main/resources/exchangeRate.json"));
        Converter converter = new DefaultConverter();

        App app = new App(
                userInterface,
                ratesGetter,
                converter);

        app.mainLogic();
    }
}
