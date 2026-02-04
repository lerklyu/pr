package org.example.workingWithFile;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONFileReader implements ParserFromJsonToMap {
    public Map<String, Double> map;

    public void parse(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        FileReader fileReader = new FileReader(path);
        map = gson.fromJson(fileReader, type);
        System.out.print("Exchange rate: ");

        for(Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}