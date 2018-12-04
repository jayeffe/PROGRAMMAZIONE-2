package it.guidofonzo.hotmail.it.classi;
import java.util.Scanner;

public class Giacenza {

	public Giacenza(String codiceMagazzino, String codiceProdotto, int quantità) {
		this.codiceProdotto = codiceProdotto;
		this.codiceMagazzino = codiceMagazzino;
		this.quantità = quantità;
		this.magazzino=null;
		this.prodotto=null;
		
	}
	

	public void setMagazzino(Magazzino magazzino) {
		this.magazzino = magazzino;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
	
	
	public static Giacenza read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String codiceMagazzino=s.nextLine();
		if(!s.hasNextLine()) return null;
		String codiceProdotto=s.nextLine();
		if(!s.hasNextLine()) return null;
		int quantità=Integer.parseInt(s.nextLine());
		return new Giacenza(codiceMagazzino, codiceProdotto, quantità);
	}
	
	


	public String getCodiceProdotto() {
		return codiceProdotto;
	}
	public String getCodiceMagazzino() {
		return codiceMagazzino;
	}
	public int getQuantità() {
		return quantità;
	}
	public Magazzino getMagazzino() {
		return magazzino;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	
	private String codiceProdotto;
	private String codiceMagazzino;
	private int quantità;
	private Magazzino magazzino;
	private Prodotto prodotto;

}
