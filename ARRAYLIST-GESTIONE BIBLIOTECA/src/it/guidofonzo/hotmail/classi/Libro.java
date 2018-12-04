package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro extends Pubblicazione {

private Libro(String identificativo, String argomento, String titolo, String editore, int annoPubblicazione,
		ArrayList<String> autori) {
		super(identificativo, argomento, titolo, editore, annoPubblicazione);
		
		this.autori=autori;
	}


public static Libro read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String identificativo= s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String argomento=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String titolo = s.nextLine();
	 
	if(!s.hasNextLine()) return null;
	String editore=s.nextLine();
	
	if(!s.hasNextInt()) return null;
	int annoPubblicazione = Integer.parseInt(s.nextLine());
	
	ArrayList<String > autori =new ArrayList<String>();
	if(!s.hasNextLine()) return null;
	String del =s.nextLine();
	while(!del.equals("#") && s.hasNextLine()) {
		autori.add(del);
		del=s.nextLine();
	}
	
	return new Libro(identificativo, argomento, titolo, editore, annoPubblicazione, autori);
}
	
	
	
public void print(PrintStream ps) {
	super.print(ps);
	for(String a :autori) {
	System.out.println(a);
	}
}





	private ArrayList<String> autori;
} 
