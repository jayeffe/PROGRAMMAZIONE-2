package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import it.guidofonzo.hotmail.util.Costanti;

public class Utente implements Comparable<Utente>{

public Utente(String identificatore, String nome, String cognome, Date dataNascita) {
	
	this.identificatore = identificatore;
	this.nome = nome;
	this.cognome = cognome;
	this.dataNascita = dataNascita;
	this.prestiti=new ArrayList<Prestito>();
	this.pubblicazioni=new ArrayList<Pubblicazione>();
}




public void AddPrestiti(Prestito p) {
	this.prestiti.add(p);
}

public void addPubblicazione(Pubblicazione p) {
	this.pubblicazioni.add(p);
}


public static Utente read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String identificatore=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nome = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String cognome= s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String dataNascita=s.nextLine();
	
     Date data;
	
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	
	try {
		data =sdf.parse(dataNascita);
	}
	catch (ParseException e) {
		System.err.println("errore nell' inserimento della data ");
		data=new Date();
	}
	
	return new Utente(identificatore, nome, cognome, data);
	
}




public ArrayList<Pubblicazione> getPubblicazioni() {
	return pubblicazioni;
}

public ArrayList<Prestito> getPrestiti() {
	return prestiti;
}
public String getIdentificatore() {
	return identificatore;
}
public String getNome() {
	return nome;
}
public String getCognome() {
	return cognome;
}
public Date getDataNascita() {
	return dataNascita;
}

public void print(PrintStream ps) {
	ps.println("identificatore " +identificatore);
	ps.println("nome "+nome);
	ps.println("cognome "+cognome);
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println("data "+sdf.format(dataNascita));
	
	
}


private String identificatore;
private String nome;
private String cognome;
private Date dataNascita;
private ArrayList<Prestito> prestiti;
private ArrayList<Pubblicazione> pubblicazioni;


public int compareTo(Utente o) {
	
	return this.nome.compareTo(o.getNome());
}
}
