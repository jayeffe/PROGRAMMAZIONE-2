package it.guidofonzo.hotmail.it.classi;
import java.util.ArrayList;
import java.util.Scanner;

public class Magazzino{

	public Magazzino(String codice, String indirizzo, String città, String nazione, String telefono, String fax) {
		this.codice = codice;
		this.indirizzo = indirizzo;
		this.città = città;
		this.nazione = nazione;
		this.telefono = telefono;
		this.fax = fax;
		this.giacenze=new ArrayList<Giacenza>();
	}
	
	

	public void aggiungiGiacenza(Giacenza g) {
		this.giacenze.add(g);
	}
	
	
	public static Magazzino read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String codice=s.nextLine();
		if(!s.hasNextLine()) return null;
		String indirizzo=s.nextLine();
		if(!s.hasNextLine()) return null;
		String città=s.nextLine();
		if(!s.hasNextLine()) return null;
		String nazione=s.nextLine();
		if(!s.hasNextLine()) return null;
		String telefono=s.nextLine();
		if(!s.hasNextLine()) return null;
		String fax=s.nextLine();
		return new Magazzino(codice,indirizzo, città, nazione, telefono, fax);
	}
	
	public void print() {
		System.out.println("Codice: "+codice);
		System.out.println("Indirizzo: "+indirizzo);
		System.out.println("Città: "+città);
		System.out.println("Nazione: "+nazione);
		System.out.println("Telefono: "+telefono);
		System.out.println("Fax: "+fax);
	}
	
	public ArrayList<Giacenza> getGiacenze() {
		return giacenze;
	}
	
	public String getCodice() {
		return codice;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getCittà() {
		return città;
	}
	public String getNazione() {
		return nazione;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getFax() {
		return fax;
	}	
		

		private ArrayList<Giacenza> giacenze;
		private String codice;
		private String indirizzo;
		private String città;
		private String nazione;
		private String telefono;
		private String fax;

	

	}