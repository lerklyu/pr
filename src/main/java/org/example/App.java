package org.example;

import org.example.communication_with_users.ConsoleUserInterface;
import org.example.communication_with_users.UserInterface;
import org.example.converter.Converter;
import org.example.converter.DefaultConverter;
import org.example.working_with_file.JsonFIleRatesGetter;
import org.example.working_with_file.RatesGetter;

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
        while (true) {
            try {
                userInterface.showToUser("Сумма для конвертации: ");
                double amountToConvert = Double.parseDouble(userInterface.getFromUser());
                userInterface.showToUser("Код валюты для конвертации: ");
                String codeCurrency = userInterface.getFromUser();
                double exchangeRateByCurrency = ratesGetter.getExchangeRates(codeCurrency);
                double conversionResult = converter.convert(amountToConvert, exchangeRateByCurrency);
                userInterface.showToUser("Эквивалент: " + String.format("%.2f", conversionResult));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        UserInterface userInterface = new ConsoleUserInterface();
        RatesGetter ratesGetter = new JsonFIleRatesGetter();
        Converter converter = new DefaultConverter();

        App app = new App(
                userInterface,
                ratesGetter,
                converter);

        app.mainLogic();
    }

}
