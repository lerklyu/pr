package org.example.converter;

public class DefaultConverter implements Converter {
    @Override
    public double convert(double amountToConvert, double exchangeRateByCurrency) {
        return amountToConvert / exchangeRateByCurrency;
    }
}
