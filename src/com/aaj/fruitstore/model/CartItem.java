package com.aaj.fruitstore.model;

import com.aaj.fruitstore.exception.AmountDeductionException;

public class CartItem {

	private final String	name;
	private final String	sku;
	private String			description;
	private int				amount;
	private double			price;

	public CartItem(String name, String sku) {
		this.name = name;
		this.sku = sku;
		this.description = "";
		this.amount = 0;
		this.price = 0;
	}

	public CartItem(String name, String sku, String description, int amount, double price) {
		this(name, sku);
		this.description = description;
		this.amount = amount;
		this.price = price;
	}

	/**
	 * 
	 * @param amount
	 * @throws AmountDeductionException
	 */
	public void deductAmount(int amount) throws AmountDeductionException {
		if (this.amount < amount)
			throw new AmountDeductionException("Amount exceeds the amount in stock!");
		this.amount =- amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getSku() {
		return sku;
	}

}
