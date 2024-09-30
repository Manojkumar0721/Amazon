package com.tuorsdude.amazon.constants;

public enum DbCredentials {
	
	HOST("jdbc:mysql://localhost:3306/training"), USER("root"), PASSWORD("abishek12"),
	DRIVER("com.mysql.cj.jdbc.Driver");

	String value;

	private DbCredentials(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
