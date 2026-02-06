package org.example.working_with_file;

import java.io.FileNotFoundException;

public interface RatesGetter {
    double getExchangeRates() throws FileNotFoundException;

}
