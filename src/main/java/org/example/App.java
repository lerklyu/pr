package org.example;

import org.example.communication_with_users.ConsoleUserInterface;
import org.example.communication_with_users.UserInterface;
import org.example.converter.Converter;
import org.example.converter.DefaultConverter;
import org.example.working_with_file.JsonFIleRatesGetter;
import org.example.working_with_file.RatesGetter;

import java.io.FileNotFoundException;

public class App {

    private UserInterface userInterface;
    private RatesGetter ratesGetter;
    private Converter converter;

    public App(UserInterface userInterface, RatesGetter ratesGetter, Converter converter) {
        this.userInterface = userInterface;
        this.ratesGetter = ratesGetter;
        this.converter = converter;
    }

    void mainLogic() throws FileNotFoundException {
        while (true) {
            userInterface.showToUser("Добро пожаловать! " +
                    "Сначала введите СУММУ для конвертации (В РУБЛЯХ), " +
                    "затем КОД ВАЛЮТЫ: ");
            converter.convert();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        UserInterface userInterface = new ConsoleUserInterface();

        RatesGetter ratesGetter = new JsonFIleRatesGetter(
                (ConsoleUserInterface) userInterface);

        Converter converter = new DefaultConverter(
                (ConsoleUserInterface) userInterface,
                (JsonFIleRatesGetter) ratesGetter);

        App app = new App(
                userInterface,
                ratesGetter,
                converter);

        app.mainLogic();
    }

}
