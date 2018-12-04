package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Paziente {
	
public Paziente(String codiceFiscale,String nome, String cognome, Date dataNascita,
		String luogoNascita) {
	this.codiceFiscale=codiceFiscale;
	this.nome=nome;
	this.cognome=cognome;
	this.dataNascita=dataNascita;
	this.luogoNascita=luogoNascita;
     esami=new HashSet<Esame>();
	
	
}
public int hashCode() {
	return codiceFiscale.hashCode();
}



public void addEsame(Esame e) {
	esami.add(e);
}

public static Paziente read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceFiscale=s.nextLine();
	
	if(!s.hasNextLine()) return null; 
	String nome=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String cognome=s.nextLine();
	
	Date dataNascita;
	
	if(!s.hasNextLine()) return null;
	String data=s.nextLine();
	
     SimpleDateFormat sdf =new SimpleDateFormat(Costanti.DATEFORMAT);
     
     try {
    	 dataNascita=sdf.parse(data);
     }
     catch(ParseException e) {
    	 System.err.println("formato errato "+data);
    	 dataNascita=new Date();
     }
     
     if(!s.hasNextLine()) return null;
     String luogoNascita =s.nextLine();
     
     return new Paziente(codiceFiscale, nome, cognome, dataNascita, luogoNascita);
     
}
public String getCodiceFiscale() {
	return this.codiceFiscale;
}



public HashSet<Esame> getEsami() {
	return esami;
}

public String getNome() {
	return this.nome;
}

public String getCognome() {
	return this.cognome;
}

public Date getData() {
	return this.dataNascita;
}

public String getLuogo() {
	return this.luogoNascita;
}


public void print(PrintStream ps) {
	ps.println("nome " +this.nome);
	ps.println("cognome "+this.cognome);
	
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println("Data "+sdf.format(dataNascita));
	
	ps.println("Luogo nascita "+luogoNascita);
}

	
	
private String codiceFiscale;
private String nome;
private String cognome;
private Date dataNascita;
private String luogoNascita;
private HashSet<Esame> esami;
}


