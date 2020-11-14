package net.codejava.models;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.annotation.XmlElement;

@ResponseBody
public class Temperature {

	private String property;
	private String val;

	public String getValue() {
		return val;
	}

	public void setValue(String val) {
		this.val = val;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

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


	@Override
	public String toString() {
		return "Temperature [val=" + val + ", property=" + property + "]";
	}

}
