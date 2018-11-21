package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Possessore {
private Possessore(String codiceFiscale, String cognome, String nome, Date dataN,String luogoNascita) {
		
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
		this.dataN = dataN;
		this.luogoNascita=luogoNascita;
		this.soluzioni=new ArrayList<SoluzioneAbitativa>();
	}

public void addSoluzione(SoluzioneAbitativa s) {
	this.soluzioni.add(s);
}
public static Possessore read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceFiscale=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String cognome=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nome=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String dataDiNascita=s.nextLine();
	
	Date dataN;
	SimpleDateFormat sdf= new SimpleDateFormat(Costanti.DATEFORMAT);
	try {
		dataN=sdf.parse(dataDiNascita);
	}
	catch (ParseException e) {
		System.err.println("FORMATO DATA NON LETTO, GENERO LA DATA DI SISTEMA"+dataDiNascita);
		dataN=new Date();
	}
	if(!s.hasNextLine()) return null;
	String luogoNascita=s.nextLine();
	
	return new Possessore(codiceFiscale, cognome, nome, dataN,luogoNascita);
}





public String getCodiceFiscale() {
	return codiceFiscale;
}
public String getCognome() {
	return cognome;
}
public String getNome() {
	return nome;
}
public Date getDataN() {
	return dataN;
}


public ArrayList<SoluzioneAbitativa> getSoluzioni() {
	return soluzioni;
}

public void print(PrintStream ps) {
	ps.println(codiceFiscale);
	ps.println(cognome);
	ps.println(nome);
	SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println(sdf.format(dataN));

}





private String codiceFiscale;
private String cognome;
private String nome;
private Date dataN;
private String luogoNascita;
private ArrayList<SoluzioneAbitativa> soluzioni;
}
