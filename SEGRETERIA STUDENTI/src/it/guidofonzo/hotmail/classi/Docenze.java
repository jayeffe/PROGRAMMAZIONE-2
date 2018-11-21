package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Docenze {
	
	
	public Docenze(String codiceFiscaledoc,String codiceCorso) {
		this.codiceFiscaledoc=codiceFiscaledoc;
		this.codiceCorso=codiceCorso;
	}
	
	
	public String getCodiceFiscaleDoc() {
		return this.codiceFiscaledoc;
	}
	
	public String getCodiceCorso() {
		return this.codiceCorso;
	}
	
	
	public static Docenze read(Scanner sc) {
		if(!sc.hasNextLine()) return null;
		String codiceFiscaleDoc=sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String codiceCorso=sc.nextLine();
		
		
		return new Docenze(codiceFiscaleDoc, codiceCorso);
	}
	
	
	public void print(PrintStream ps) {
		ps.println(codiceFiscaledoc);
		ps.println(codiceCorso);
	}
	
	
	

	private String codiceFiscaledoc;
	private String codiceCorso;
	
	
	
	
	
	
}
