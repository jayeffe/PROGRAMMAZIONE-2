package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Docente {
	
	public Docente(String codiceFiscale,String nome,String cognome,Date dataNascita,
			String fascia,String raggruppamento) {
		this.codiceFiscale=codiceFiscale;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.fascia=fascia;
		this.raggruppamento=raggruppamento;
		corsi=new HashSet<Corso>();
		
	}
	public void addCorso(Corso c) {
		this.corsi.add(c);
	}
	
	public int hashCode() {
		return codiceFiscale.hashCode();
	}
	
	
	// METODI GET 

	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public HashSet<Corso> getCorsi() {
		return corsi;
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

	// METODO READ
	public static  Docente read(Scanner s) {
	
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
			dataNascita =sdf.parse(data);
		}
		catch (ParseException e) {
		System.err.println("FORMATO DELLA DATA INSERITO NON VALIDO");
		dataNascita=new Date();
		}
		
		if(!s.hasNextLine()) return null;
		String fascia = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String raggruppamento = s.nextLine();
		
		return new Docente(codiceFiscale, nome, cognome, dataNascita, fascia, raggruppamento);
		
	}

	public void print(PrintStream ps) {
		ps.println("Codice fiscale "+codiceFiscale);
		ps.println("Nome "+nome);
		ps.println("Cognome "+cognome);
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		ps.println("Data nascita "+sdf.format(dataNascita));
		ps.println("Fascia "+fascia);
		ps.println("Raggruppamento "+raggruppamento);
	}





	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String fascia;
	private String raggruppamento;
	private HashSet<Corso> corsi;
	
	
	

}
