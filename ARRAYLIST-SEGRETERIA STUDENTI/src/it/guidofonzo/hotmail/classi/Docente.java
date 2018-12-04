package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Docente {
	
	public Docente(String codiceFiscale,String nome,String cognome,Date dataNascita, String luogoNascita) {
		this.codiceFiscale=codiceFiscale;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.luogoNascita=luogoNascita;
		this.corsi=new ArrayList<Corso>();
		
	}
	
	public void addCorso(Corso c) {
		corsi.add(c);
	}
	
	//METODI GETTERS 
	
	
	
	public String getCf() {
		return this.codiceFiscale;
	}
	public ArrayList<Corso> getCorsi() {
		return corsi;
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
	
	
	public static Docente read(Scanner sc) {
		if(!sc.hasNextLine()) return null;
		String codiceFiscale=sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String nome=sc.nextLine();
		
		if(!sc.hasNextLine()) return null; 
		String cognome=sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String data = sc.nextLine();
		
		Date dataNascita;
		
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		try {
			dataNascita=sdf.parse(data);
		}
		catch(ParseException e) {
			System.err.println("data non corretta "+data);
			System.err.println("verrà inserita la data di sistema");
			dataNascita=new Date();
		}
		
		if(!sc.hasNextLine()) return null;
		String luogoNascita = sc.nextLine();
	
		return new Docente(codiceFiscale, nome, cognome, dataNascita, luogoNascita);
		
 	}
	
	public void print(PrintStream ps) {
		ps.println("codice fiscale "+codiceFiscale);
		ps.println("nome "+nome);
		ps.println("cognome "+cognome);
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		ps.println("data " +sdf.format(dataNascita));
		ps.println("luogo "+luogoNascita);
		ps.println(" ");
		
	}
	
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String luogoNascita;
	private ArrayList<Corso> corsi;
	
	
	
	
}
