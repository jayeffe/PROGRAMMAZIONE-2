package it.guidofonzo.hotmail.util;

public class teacherNotFoundException extends RuntimeException {

	public teacherNotFoundException() {}
	
	public teacherNotFoundException(String message) {
		super(message);
	}
}
