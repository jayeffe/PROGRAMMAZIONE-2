package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Prestito {
	
public Prestito(String identificatoreUtente, String pubblicazione, Date dataPrestito, Date dataConsegna) {
		
		this.identificatoreUtente=identificatoreUtente;
		this.pubblicazione = pubblicazione;
		this.dataPrestito = dataPrestito;
		this.dataConsegna = dataConsegna;
		this.pubblicazioni=pubblicazioni;
	}
public void AddUtente(Utente u) {
	this.utente=u;
}
public void addPubblicazione(Pubblicazione p) {
	this.pubblicazioni.add(p);
}


public static Prestito read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String identificatoreUtente = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String pubblicazione = s.nextLine();
	
    if(!s.hasNextLine()) return null;
    String dataP=s.nextLine();
    
    Date dataPrestito;
    SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
    try {
    	dataPrestito = sdf.parse(dataP);
    	
    }
    catch(ParseException e) {
    	System.err.println("GENERATA ECCEZIONE NELLA GESTIONE DELLA DATA ");
    	dataPrestito=new Date();
    	
    }
    if(!s.hasNextLine()) return null;
    String dataC=s.nextLine();
    
    Date dataConsegna;
    if(dataC.equals("-")) dataConsegna = null;
    else {
    	try {
    		dataConsegna=sdf.parse(dataC);
    	}
    	catch(ParseException e) {
    		System.err.println("GENERATA ECCEZIONE NELLA DATA DI CONSEGNA");
    		dataConsegna=new Date();
    	}
    }
    
  return new Prestito(identificatoreUtente, pubblicazione, dataPrestito, dataConsegna);
}

public String getIdentificatoreUtente() {
	return identificatoreUtente;
}
public String getPubblicazione() {
	return pubblicazione;
}
public Date getDataPrestito() {
	return dataPrestito;
}
public Date getDataConsegna() {
	return dataConsegna;
}
public Utente getUtente() {
	return utente;
}


public void print(PrintStream ps) {
	
	
	ps.println("identificatore utente "+identificatoreUtente);
	ps.println("pubblicazione "+pubblicazione);
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println("Data prestito "+sdf.format(dataPrestito));
	if(dataConsegna!=null) {
ps.println("data consegna "+sdf.format(dataConsegna));
	}
	else {
		ps.println("In attesa di consegna ");
	}
}


private String identificatoreUtente;
private String pubblicazione;
private Date dataPrestito; 
private Date dataConsegna;
private Utente utente;
private ArrayList<Pubblicazione> pubblicazioni;
}
