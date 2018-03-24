package com.aaj.fruitstore.model;

/**
 * 
 **/
public final class Fruit extends CartItem {
	private final int		calories;
	private final String	countryOfOrigin;

	public Fruit(String name, String sku, String description, int amount, double price, int calories, String country) {
		super(name, sku, description, amount, price);
		this.calories = calories;
		this.countryOfOrigin = country;
	}

	public int getCalories() {
		return calories;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

}
