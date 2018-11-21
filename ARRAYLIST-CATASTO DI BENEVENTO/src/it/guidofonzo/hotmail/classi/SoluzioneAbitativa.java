package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class SoluzioneAbitativa {
	
	
private SoluzioneAbitativa(String identificativo, String nomePalazzo, String via, int numeroCivico, String comune,
			int piano, int numeroStanze, int metriQuadri, int prezzo) {
		this.identificativo = identificativo;
		this.nomePalazzo = nomePalazzo;
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.piano = piano;
		this.numeroStanze = numeroStanze;
		this.metriQuadri = metriQuadri;
		this.prezzo = prezzo;
	}

public void addPossessore(Possessore p) {
	this.possessore=p;
}

public static SoluzioneAbitativa read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String identificativo=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nomePalazzo=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String via = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	int numeroCivico;
	try {
		numeroCivico=Integer.parseInt(s.nextLine());
	}
	catch (NumberFormatException e) {
		System.out.println("formato del numerocivico non corretto, ");
		numeroCivico=00;
	}
	if(!s.hasNextLine()) return null;
	String comune=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	int piano;
	try {
		piano=Integer.parseInt(s.nextLine());
	
	}
	catch(NumberFormatException e) {
		System.err.println("generata eccezione variabile piano ");
		piano=00000;
	}
	if(!s.hasNextLine()) return null;
	int numeroStanze;
	try {
		numeroStanze=Integer.parseInt(s.nextLine());
		
	}
	catch (NumberFormatException e) {
System.err.println("numero stanze non corretto, setto un numero di defalt ");	
numeroStanze=0;
}
	
	if(!s.hasNextLine()) return null;
	int metriQuadri;
	try {
		metriQuadri=Integer.parseInt(s.nextLine());
	}
	catch (NumberFormatException e) {
		System.err.println("metri quadrati errati ");
		metriQuadri=00;
	}
	if(!s.hasNextLine()) return null;
	int prezzo;
	try {
		prezzo=Integer.parseInt(s.nextLine());
	}
	catch (NumberFormatException e) {
		System.out.println("prezzo non corretto");
		prezzo=0000;
	}
	return new SoluzioneAbitativa(identificativo, nomePalazzo, via, numeroCivico, comune, piano, numeroStanze, metriQuadri, prezzo);
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
public String getComune() {
	return comune;
}
public int getPiano() {
	return piano;
}
public int getNumeroStanze() {
	return numeroStanze;
}
public int getMetriQuadri() {
	return metriQuadri;
}
public int getPrezzo() {
	return prezzo;
}

public void print(PrintStream ps) {
	ps.println(identificativo);
	ps.println(nomePalazzo);
	ps.println(via);
	ps.println(numeroCivico);
	ps.println(comune);
	ps.println(piano);
	ps.println(numeroStanze);
	ps.println(metriQuadri);
	ps.println(prezzo);
	
}



public Possessore getPossessore() {
	return possessore;
}



private String  identificativo;
private String nomePalazzo;
private String via;
private int numeroCivico;
private String comune;
private int piano;
private int numeroStanze;
private int metriQuadri;
private int prezzo;
private Possessore possessore;

}
