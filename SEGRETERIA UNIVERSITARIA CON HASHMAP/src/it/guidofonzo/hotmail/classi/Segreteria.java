package it.guidofonzo.hotmail.classi;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import it.guidofonzo.hotmail.util.docenteNotFoundException;


public class Segreteria {
	
	public Segreteria(Scanner sDoc, Scanner sCorsi) {
		docenti=new HashMap<String, Docente>();
		corsi=new HashMap<String,Corso>();
		Docente d=Docente.read(sDoc);
		while(d!=null) {
			docenti.put(d.getCodiceFiscale(), d);
			d=Docente.read(sDoc);
		}
		Corso c=Corso.read(sCorsi);
		while(c!=null) {
			try{
				corsi.put(c.getCodiceCorso(),c);
				d=cercaDocente(c.getCodiceFiscale());
				c.addDocente(d);
				d.addCorso(c);			
			}
			catch(docenteNotFoundException e) {
				System.err.println("Lanciata eccezione docente non found");
				System.out.println(e.getMessage());
			}
			c=Corso.read(sCorsi);
		}
	}
	
	
	private Segreteria(HashMap<String, Docente> docenti, HashMap<String, Corso> corsi) {
		this.docenti = docenti;
		this.corsi = corsi;
	}

	public void print() {
		Set<String> keySet=docenti.keySet();
		for(String key:keySet) {
			Docente d=docenti.get(key);
			d.print(System.out);
			System.out.println("\n*Corsi erogati dal docente*");
			for(Corso c :d.getCorsi())
			{
				c.print(System.out);
				System.out.println("");
			}
			System.out.println("------------------------------------------------");
		}
	}
	
	
	public Segreteria cercaPerNomeDocente(String nome) {
		HashMap<String, Docente> filtroDoc=new HashMap<String, Docente>();
		HashMap<String, Corso> filtroCorsi=new HashMap<String, Corso>();
		Set<String> keySet=docenti.keySet();
		for(String key:keySet) {
			Docente d=docenti.get(key);
			if(d.getNome().equalsIgnoreCase(nome)) {
				filtroDoc.put(d.getCodiceFiscale(), d);
				for(Corso c:d.getCorsi())
					filtroCorsi.put(c.getCodiceFiscale(),c);
			}
		}
		return new Segreteria(filtroDoc, filtroCorsi);
	}
	
	public Segreteria cercaPerCognomeDocente(String Cognome) {
		HashMap<String, Docente> filtroDoc=new HashMap<String, Docente>();
		HashMap<String, Corso> filtroCorsi=new HashMap<String, Corso>();
		Set<String> keySet=docenti.keySet();
		for(String key:keySet) {
			Docente d=docenti.get(key);
			if(d.getCognome().equalsIgnoreCase(Cognome)) {
				filtroDoc.put(d.getCodiceFiscale(), d);
				for(Corso c:d.getCorsi())
					filtroCorsi.put(c.getCodiceFiscale(),c);
			}
		}
		return new Segreteria(filtroDoc, filtroCorsi);
	}
	
	public Segreteria cercaPerDataNascitaDocente(Date nascita) {
		HashMap<String, Docente> filtroDoc=new HashMap<String, Docente>();
		HashMap<String, Corso> filtroCorsi=new HashMap<String, Corso>();
		Set<String> keySet=docenti.keySet();
		for(String key:keySet) {
			Docente d=docenti.get(key);
			if(d.getDataNascita().equals(nascita)) {
				filtroDoc.put(d.getCodiceFiscale(), d);
				for(Corso c:d.getCorsi())
					filtroCorsi.put(c.getCodiceCorso(),c);
			}
		}
		return new Segreteria(filtroDoc, filtroCorsi);
	}
	
	public Segreteria cercaPerNomeCorso(String nome) {
		HashMap<String, Docente> filtroDoc=new HashMap<String, Docente>();
		HashMap<String, Corso> filtroCorsi=new HashMap<String, Corso>();
		Set<String> keySet=corsi.keySet();
		for(String key:keySet) {
			Corso c=corsi.get(key);
			if(c.getNomeCorso().equals(nome)) {
				filtroCorsi.put(c.getCodiceCorso(),c);
				filtroDoc.put(c.getCodiceFiscale(),c.getDocente());
			}
		}
		return new Segreteria(filtroDoc, filtroCorsi);
	}
	
	public Segreteria cercaPerCorsoLaurea(String corsoLaurea) {
		HashMap<String, Docente> filtroDoc=new HashMap<String, Docente>();
		HashMap<String, Corso> filtroCorsi=new HashMap<String, Corso>();
		Set<String> keySet=corsi.keySet();
		for(String key:keySet) {
			Corso c=corsi.get(key);
			if(c.getCorsoLaurea().equalsIgnoreCase(corsoLaurea)) {
				filtroCorsi.put(c.getCodiceCorso(),c);
				filtroDoc.put(c.getCodiceFiscale(),c.getDocente());
			}
		}
		return new Segreteria(filtroDoc, filtroCorsi);
	}
	
	
	private Docente cercaDocente(String cf) {
		Docente d=docenti.get(cf);
		if(d!=null) return d;
		throw new docenteNotFoundException("Docente non trovato");
	}
	


	
	

	private HashMap<String, Docente> docenti;
	private HashMap<String, Corso> corsi;
}
