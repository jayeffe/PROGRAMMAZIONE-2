package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdineMenu {
public OrdineMenu(String nome, double prezzo) {
	
		this.nome = nome;
		this.prezzo = prezzo;
		
	}
	



	public static OrdineMenu read(Scanner s) { 
		if(!s.hasNextLine()) return null;
		String nome=s.nextLine();
		
		if(!s.hasNextLine()) return null;
		double prezzo;
		
		try { 
			prezzo=Double.parseDouble(s.nextLine());
		}
		catch(NumberFormatException ne) {
			System.err.println("errore nell'inserimento del prezzo ");
			prezzo=0.00;
		}
		return new OrdineMenu(nome, prezzo);
	}
	
	public String getNomePietanza() {
		return nome;
	}
	public double getPrezzo() {
		return prezzo;
	}

public void print(PrintStream ps) {
	ps.println("nome"+nome);
	ps.println("prezzo "+prezzo);
}

	private String nome;
	private double prezzo;
	
}
