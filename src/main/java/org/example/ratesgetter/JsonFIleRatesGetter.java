package org.example.ratesgetter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonFIleRatesGetter implements RatesGetter {

    private Path path;
    private String jsonContent;

    public JsonFIleRatesGetter(Path path) {
        this.path = path;
        try {
            this.jsonContent = Files.readString(path, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки пути" + path.toString());
        }
    }

    @Override
    public double getExchangeRates(String acceptedCodeCurrency) {
        Map<String, Double> mapRates;
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>() {
        }.getType();
        mapRates = gson.fromJson(jsonContent, type);
        if (!mapRates.containsKey(acceptedCodeCurrency)) {
            throw new RuntimeException("Код валюты не найден или не существует" + acceptedCodeCurrency);
        }
        return mapRates.get(acceptedCodeCurrency);
    }
}

