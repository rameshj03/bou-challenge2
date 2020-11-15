package com.poc.temperature.conversion.models;

public class TemperatureResponse {

    private String Celsius;

    private String Fahrenheit;


    public String getCelsius() {
        return Celsius;
    }

    public void setCelsius(String celsius) {
        Celsius = celsius;
    }


    public String getFahrenheit() {
        return Fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        Fahrenheit = fahrenheit;
    }
}
