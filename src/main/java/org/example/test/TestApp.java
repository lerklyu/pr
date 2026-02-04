package org.example.test;

import org.example.workingWithFile.JSONFileReader;
import org.example.workingWithUserAndConsole.AppFromUsers;

import java.io.FileNotFoundException;


    public class TestApp {
        public static void main(String[] args) throws FileNotFoundException {
            JSONFileReader jsonFileReader = new JSONFileReader();
            AppFromUsers appFromUsers = new AppFromUsers();
            jsonFileReader.parse("src/main/resources/exchangeRate.json");
            appFromUsers.requestData(jsonFileReader);
        }
    }

