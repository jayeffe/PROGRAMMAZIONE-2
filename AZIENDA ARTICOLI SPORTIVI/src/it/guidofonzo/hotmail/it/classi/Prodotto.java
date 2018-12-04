package it.guidofonzo.hotmail.it.classi;

import java.util.ArrayList;
import java.util.Scanner;

public class Prodotto {
	
	public Prodotto(String codice, String descrizione, double prezzo) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.giacenze=new ArrayList<Giacenza>();
	}
	
	public static Prodotto read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String codice=s.nextLine();
		if(!s.hasNextLine()) return null;
		String descrizione=s.nextLine();
		if(!s.hasNextLine()) return null;
		double prezzo=Double.parseDouble(s.nextLine());
		return new Prodotto(codice,descrizione,prezzo);
	}
	
	public void print() {
		System.out.println("Descrizione: "+descrizione);
		System.out.println("Prezzo: "+prezzo+"€");
	}

	public void addGiacenza(Giacenza g) {
		this.giacenze.add(g);
	}
	
	
	
	public ArrayList<Giacenza> getGiacenze() {
		return giacenze;
	}

	public String getCodice() {
		return codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	
	private String codice;
	private String descrizione;
	private double prezzo;
	private ArrayList<Giacenza> giacenze;

}
