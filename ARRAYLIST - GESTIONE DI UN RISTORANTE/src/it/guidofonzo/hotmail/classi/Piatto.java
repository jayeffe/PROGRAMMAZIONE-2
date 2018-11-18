package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Piatto extends OrdineMenu{

	private Piatto(String nomePietanza,String tipoPortata,double prezzo ) {
		super(nomePietanza, prezzo);
		this.tipoPortata=tipoPortata;
	}	
public static Piatto read(Scanner s) {
	
	if(!s.hasNextLine()) return null;
	String nomePietanza=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String tipoPortata=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	double prezzo;
	
	try {
		prezzo=Double.parseDouble(s.nextLine());
	}
	catch(NumberFormatException e) {
		System.err.println("formato non corretto");
		prezzo = 0.00;
	}
	
	
	return new Piatto(nomePietanza, tipoPortata, prezzo);
	
}
	public void print(PrintStream ps) {
        super.print(ps);
		ps.println("tipo portata "+tipoPortata);
	}
	
	
	
	
	
	public String getTipoPortata() {
		return tipoPortata;
	}







	private String tipoPortata;
	
	
}
