package org.example.working_with_file;

import java.io.IOException;

public interface RatesGetter {
    double getExchangeRates(String acceptedCodeCurrency) throws IOException;
}
