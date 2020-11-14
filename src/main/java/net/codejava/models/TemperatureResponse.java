package net.codejava.models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (namespace="urn:TemperatureConversion", name="TemperatureConversion")
public class TemperatureResponse {

    private String celsius;

    private String fahrenheit;

    @XmlElement
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    @XmlElement
    public String getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }


}
