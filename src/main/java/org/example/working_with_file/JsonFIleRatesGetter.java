package org.example.working_with_file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.communication_with_users.ConsoleUserInterface;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonFIleRatesGetter implements RatesGetter {
    private ConsoleUserInterface consoleuserInterface;

    public JsonFIleRatesGetter(ConsoleUserInterface consoleuserInterface) {
        this.consoleuserInterface = consoleuserInterface;
    }

    @Override
    public double getExchangeRates() throws FileNotFoundException {
        Map<String, Double> mapRates;
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>() {
        }.getType();
        FileReader fileReader = new FileReader("src/main/resources/exchangeRate.json");
        mapRates = gson.fromJson(fileReader, type);
        String codeCurrency = consoleuserInterface.getFromUser();
        for (Map.Entry<String, Double> entry : mapRates.entrySet()) {
            if (codeCurrency.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return mapRates.get(codeCurrency);
    }
}

