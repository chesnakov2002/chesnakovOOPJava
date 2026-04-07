package ru.academits.chesnakov.temperature.model;

public class TemperatureConverter implements Converter {
    private double celsiusTemperature;
    private double fahrenheitTemperature;

    @Override
    public void convertToFahrenheit() {
        this.fahrenheitTemperature = celsiusTemperature * 9 / 5 + 32;
    }
}
