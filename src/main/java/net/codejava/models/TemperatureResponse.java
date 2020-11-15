package net.codejava.models;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
@XmlRootElement(name = "user")
public class User {

    public User(){
    }
    private long id;
    private String name;
    private Date registrationDate;

    @XmlAttribute(name="name")
    public String getName() {
        return name;
    }

}

*/




@XmlRootElement ( namespace="urn:TemperatureConversion", name="TemperatureConversion")
public class TemperatureResponse {

    @XmlElement
    private String Celsius;

    @XmlElement
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
