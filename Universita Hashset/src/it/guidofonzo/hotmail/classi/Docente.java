package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Docente {
	
public Docente(String codiceFiscale, String nome, String cognome, Date dataNascita, String fascia,
			String raggruppamento) {
		
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.fascia = fascia;
		this.raggruppamento = raggruppamento;
		this.corsi = new HashSet<Corso>();
	}

public void addCorso(Corso c) {
	this.corsi.add(c);
}


public int hashCode() {
	return codiceFiscale.hashCode();
}
public boolean equals(Docente d) {
	if(codiceFiscale.equalsIgnoreCase(d.getCodiceFiscale())) return true;
	return false;
}

public HashSet<Corso> getCorsi() {
	return corsi;
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
public Date getDataNascita() {
	return dataNascita;
}
public String getFascia() {
	return fascia;
}
public String getRaggruppamento() {
	return raggruppamento;
}

public static Docente read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceFiscale = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nome = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String cognome = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String data = s.nextLine();
	
	Date dataNascita;
	
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	try {
		dataNascita=sdf.parse(data);
	}
	catch(ParseException e) {
		System.err.println("FORMATO DELLA DATA NON AMMESSO ");
		System.err.println("VIENE INSERITA LA DATA DI SISTEMA ");
		dataNascita=new Date();
	}

	if(!s.hasNextLine()) return null;
	String fascia = s.nextLine();
	

	if(!s.hasNextLine()) return null;
	String raggruppamento = s.nextLine();
	
	return new Docente(codiceFiscale, nome, cognome, dataNascita, fascia, raggruppamento);
	
}

public void print(PrintStream ps) {
	ps.println("CODICE FISCALE "+codiceFiscale);
	ps.println("NOME "+nome);
    ps.println("COGNOME "+cognome);
    SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println("DATA "+sdf.format(dataNascita));
	ps.println("FASCIA "+fascia);
	ps.println("RAGGRUPPAMENTO "+raggruppamento);


}



private String codiceFiscale;
private String nome;
private String cognome;
Date dataNascita;
private String fascia;
private String raggruppamento;
private HashSet<Corso> corsi;
}
