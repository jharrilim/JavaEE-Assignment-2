package com.aaj.fruitstore.exception;



public class AmountDeductionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888468633647946547L;

	
	public AmountDeductionException(String msg) {
		super(msg);
	}

	public AmountDeductionException(String msg, Throwable inner) {
		super(msg, inner);
	}
	
}
