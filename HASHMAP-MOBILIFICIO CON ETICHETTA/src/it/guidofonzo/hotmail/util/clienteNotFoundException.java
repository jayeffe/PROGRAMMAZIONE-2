package it.guidofonzo.hotmail.util;

public class clienteNotFoundException extends RuntimeException {

	
	public clienteNotFoundException(){}
	
	public clienteNotFoundException(String message) {
		super(message);
	}
}
