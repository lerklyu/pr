package org.example.working_with_file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JsonFIleRatesGetter implements RatesGetter {

    @Override
    public double getExchangeRates(String acceptedCodeCurrency) throws IOException {
        Map<String, Double> mapRates;
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>() {
        }.getType();
        Path filePath = Paths.get("src/main/resources/exchangeRate.json");
        String jsonContent = Files.readString(filePath, StandardCharsets.UTF_8);
        mapRates = gson.fromJson(jsonContent, type);
        for (Map.Entry<String, Double> entry : mapRates.entrySet()) {
            if (acceptedCodeCurrency.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return mapRates.get(acceptedCodeCurrency);
    }
}

