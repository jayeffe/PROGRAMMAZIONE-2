package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Corso {
	public Corso(String codiceFiscale, String codiceCorso, String nomeCorso, String corsoLaurea, String descrizione) {

		CodiceFiscale = codiceFiscale;
		this.codiceCorso = codiceCorso;
		this.nomeCorso = nomeCorso;
		this.corsoLaurea = corsoLaurea;
		this.descrizione = descrizione;
		
	}
	
	public void addDocente(Docente d) {
		this.docente=d;
	}
	
	public int hashCode() {
		return codiceCorso.hashCode();
	}
	
	
	
	public static Corso read(Scanner s) {
		if(!s.hasNextLine())return null ;
		String codiceFiscale= s.nextLine();
		
		if(!s.hasNextLine())return null ;
		String codiceCorso= s.nextLine();
		
		if(!s.hasNextLine())return null ;
		String nomeCorso= s.nextLine();
		
		if(!s.hasNextLine())return null ;
		String corsoLaurea= s.nextLine();
		
		if(!s.hasNextLine())return null ;
		String descrizione= s.nextLine();
		
		return new Corso(codiceFiscale, codiceCorso, nomeCorso, corsoLaurea, descrizione);
		
	}
	
	

	public Docente getDocente() {
		return docente;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public String getCodiceCorso() {
		return codiceCorso;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public String getCorsoLaurea() {
		return corsoLaurea;
	}
	public String getDescrizione() {
		return descrizione;
	}

	public void print(PrintStream ps) {
		ps.println("Codice fiscale "+CodiceFiscale);
		ps.println("Codice corso "+codiceCorso);
		ps.println("NomeCorso "+nomeCorso);
		ps.println("Corso Laurea "+corsoLaurea);
		ps.println("Descrizione "+descrizione);
	}



	private String CodiceFiscale;
	private String codiceCorso;
	private String nomeCorso;
	private String corsoLaurea;
	private String descrizione;
	private Docente docente;
	
	
	
}
