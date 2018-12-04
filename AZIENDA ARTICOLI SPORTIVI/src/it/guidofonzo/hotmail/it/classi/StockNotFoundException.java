package it.guidofonzo.hotmail.it.classi;

public class StockNotFoundException extends RuntimeException {

	public StockNotFoundException() {}
	
	public StockNotFoundException(String message) {
		super(message);
	}
}
