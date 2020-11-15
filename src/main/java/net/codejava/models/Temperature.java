package net.codejava.models;

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

}
