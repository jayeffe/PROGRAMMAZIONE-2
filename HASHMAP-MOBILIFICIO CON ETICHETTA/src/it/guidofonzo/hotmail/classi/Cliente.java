package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	public Cliente(String codiceFiscale, String nome, String cognome, String indirizzo) {
	
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		preventivi=new ArrayList<Preventivo>();
	}
	
	public void addPeventivo(Preventivo p) {
		this.preventivi.add(p);
	}
	
	
	public void addPreventivo(Preventivo p) {
		this.preventivi.add(p);
	}



	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	
	

	public ArrayList<Preventivo> getPreventivi() {
		return preventivi;
	}

	public static Cliente read(Scanner sc) {
		if(!sc.hasNextLine()) return null;
		String codiceFiscale = sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String nome =sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String cognome =sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String indirizzo =sc.nextLine();
		
		return new Cliente(codiceFiscale, nome, cognome, indirizzo);
	}


public void print(PrintStream ps) {
	ps.println("codice fiscale "+codiceFiscale);
	ps.println("nome "+nome);
	ps.println("cognome "+cognome);
	ps.println("indirizzo "+indirizzo);
}




	private String codiceFiscale;
	private String  nome;
	private String  cognome;
	private String indirizzo;
	private ArrayList<Preventivo> preventivi;
	
}
