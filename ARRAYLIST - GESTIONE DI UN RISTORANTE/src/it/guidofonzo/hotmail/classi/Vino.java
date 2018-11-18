package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Vino extends OrdineMenu {
	private Vino(String nomePietanza,String tipoVino, double prezzo,int annata) {
		super(nomePietanza, prezzo);
		this.tipoVino=tipoVino;
		this.annata=annata;
	} 
	
	public static Vino read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String nomePietanza=s.nextLine();
		

        if(!s.hasNextLine()) return null;
        String tipoVino=s.nextLine();
        
		if(!s.hasNextLine()) return null;
        double prezzo;
		
		try {
			prezzo=Double.parseDouble(s.nextLine());
		}
		catch(NumberFormatException ne) {
			System.err.println("errore nell'inserimento del prezzo ");
			prezzo=0.00;
		}
		
        
        if(!s.hasNextInt()) return null;
        int annata = Integer.parseInt(s.nextLine());
        
        return new Vino(nomePietanza,tipoVino,prezzo, annata);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.println("tipo vino "+tipoVino);
		ps.println("annata vino "+annata);
		
	}
	
	

	public String getTipoVino() {
		return tipoVino;
	}
	public int getAnnata() {
		return annata;
	}









	private String tipoVino;
	private int annata;
	
}
