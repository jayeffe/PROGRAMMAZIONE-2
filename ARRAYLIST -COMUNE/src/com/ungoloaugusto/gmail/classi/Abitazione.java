package com.ungoloaugusto.gmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Abitazione {
	
	public Abitazione(String identificativo, String nomePalazzo, String via, int numeroCivico, int piano,
			int numeroStanze, int metriQuadrati, int prezzo,String comune) {
		this.identificativo = identificativo;
		this.nomePalazzo = nomePalazzo;
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.piano = piano;
		this.numeroStanze = numeroStanze;
		this.metriQuadrati = metriQuadrati;
		this.prezzo = prezzo;
		this.comune=comune;
		
	}
	
	
	public void addProprietario(Proprietario pro) {
		this.proprietario=pro;
		
	}
	
	
	

	
	
	public Proprietario getProprietario() {
		return proprietario;
	}


	public String getIdentificativo() {
		return identificativo;
	}
	public String getNomePalazzo() {
		return nomePalazzo;
	}
	public String getVia() {
		return via;
	}
	public int getNumeroCivico() {
		return numeroCivico;
	}
	public int getPiano() {
		return piano;
	}
	public int getNumeroStanze() {
		return numeroStanze;
	}
	public int getMetriQuadrati() {
		return metriQuadrati;
	}
	public int getPrezzo() {
		return prezzo;
	}
	
	public String getComune(){
		return comune;
	}
	
	
	
	public static Abitazione read(Scanner s) {
		if(!s.hasNext()) return null;
		String identificativo=s.nextLine();
		if(!s.hasNext()) return null;
		String nomePalazzo=s.nextLine();
		if(!s.hasNext()) return null;
		String via=s.nextLine();
		if(!s.hasNext()) return null;
		int numeroCivico=Integer.parseInt(s.nextLine());
		if(!s.hasNext()) return null;
		int piano=Integer.parseInt(s.nextLine());
		if(!s.hasNext()) return null;
		int numeroStanze=Integer.parseInt(s.nextLine());
		if(!s.hasNext()) return null;
		int metriQuadrati=Integer.parseInt(s.nextLine());
		if(!s.hasNext()) return null;
		int prezzo=Integer.parseInt(s.nextLine());
		if(!s.hasNext())return null;
		String comune=s.nextLine();
		
		return new Abitazione(identificativo, nomePalazzo, via, numeroCivico, piano, numeroStanze, metriQuadrati, prezzo,comune);
		
	}
	
	
	public void print(PrintStream ps) {
		ps.println(identificativo);
		ps.println(nomePalazzo);
		ps.println(via);
		ps.println(numeroCivico);
		ps.println(piano);
		ps.println(numeroStanze);
		ps.println(metriQuadrati);
		ps.println(prezzo);
		ps.println(comune);
	}












	private String identificativo;
	private String nomePalazzo;
	private String via;
	private int numeroCivico;
	private int piano;
	private int numeroStanze;
	private int metriQuadrati;
	private int prezzo;
	private String comune;
	private Proprietario proprietario;
	
}
