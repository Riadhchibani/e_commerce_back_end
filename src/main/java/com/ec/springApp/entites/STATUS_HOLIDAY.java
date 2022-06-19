package com.ec.springApp.entites;

public enum STATUS_HOLIDAY {

	EN_COURS("EN COURS"), CONFIRM("Confirmée"), REFUSEE("Refusée");

	private final String value;

	private STATUS_HOLIDAY(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}

}
