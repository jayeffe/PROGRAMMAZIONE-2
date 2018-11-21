package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Corso {
	
	public Corso(String codiceFiscale,String codiceCorso, String nomeCorso,
			String corsoLaurea,String descrizione) {
		
		this.codiceFiscale=codiceFiscale;
		this.codiceCorso=codiceCorso;
		this.nomeCorso=nomeCorso;
		this.corsoLaurea=corsoLaurea;
		this.descrizione=descrizione;		
	}
	
	public int hashCode() {
		return codiceCorso.hashCode();
	}
	
	public boolean equals(Corso c) {
		if(codiceCorso.equalsIgnoreCase(c.getCodiceCorso()))return true;
		return false;
	}
	
	public void addDocente(Docente d) {
		this.docenti=d;
	}
	// Metodo Get
	
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}
	
	public String getCodiceCorso() {
		return this.codiceCorso;
	}
	
	public String getNomeCorso() {
		return this.nomeCorso;
	}
	
	public String getCorsoLaurea() {
		return this.corsoLaurea;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public Docente getDocenti() {
		return docenti;
	
	//Metodo Read(Scanner)
	
	
	}

	public static Corso read(Scanner s) {
		if(!s.hasNextLine())return null;
		String codiceFiscale = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String codiceCorso = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String nomeCorso = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String corsoLaurea = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String descrizione =s.nextLine();
		
		return new Corso(codiceFiscale, codiceCorso, nomeCorso, corsoLaurea, descrizione);
	}
	
	public void print(PrintStream ps) {
		ps.println("Codice fiscale " +codiceFiscale);
		ps.println("CodiceCorso " +codiceCorso);
		ps.println("Nome Corso " +nomeCorso);
		ps.println("Corso Laurea " +corsoLaurea);
		ps.println("Descrizione " +descrizione);

	}
	
	
	
	
	
	
	private String codiceFiscale,codiceCorso, nomeCorso,corsoLaurea,descrizione;
	private Docente docenti;
	
	
	
	
	

}
