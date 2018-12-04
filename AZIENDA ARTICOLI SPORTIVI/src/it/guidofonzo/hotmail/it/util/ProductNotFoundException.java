package it.guidofonzo.hotmail.it.util;

public class ProductNotFoundException extends RuntimeException {

	
	public ProductNotFoundException() {}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
