package it.guidofonzo.hotmail.util;

public class docenteNotFoundException extends RuntimeException {

	public docenteNotFoundException() {}
	
	public docenteNotFoundException(String message) {
		super(message);
	}
}
