package org.example.workingWithFile;

import java.io.FileNotFoundException;

public interface ParserFromJsonToMap {
    void parse(String path) throws FileNotFoundException;
}