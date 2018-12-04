package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Rivista extends Pubblicazione {

	
	public Rivista(String identificativo, String argomento, String titolo, int annoPubblicazione, 
			String editore,int volume,int numero) {
		super(identificativo, argomento, titolo, editore, annoPubblicazione);
		
		this.volume=volume;
		this.numero=numero;
	}
	public static Rivista read(Scanner s) {
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
		
		
		if(!s.hasNextInt()) return null;
		int volume =Integer.parseInt(s.nextLine());
		
		if(!s.hasNextInt()) return null;
	    int numero = Integer.parseInt(s.nextLine());
	    
	    return new Rivista(identificativo, argomento, titolo, annoPubblicazione, editore, volume, numero);
	    
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.println("volume "+volume);
		ps.println("numero "+numero);
	}
	
	
	
	private int volume;
	private int numero;
}
