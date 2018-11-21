package it.guidofonzo.hotmail.classi;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import it.guidofonzo.hotmail.util.teacherNotFoundException;

public class Segreteria {
	
	

private Segreteria(HashMap<String, Docente> docenti, HashMap<String, Corso> corsi) {
		this.docenti = docenti;
		this.corsi = corsi;
	}
public Segreteria(Scanner sDocenti,Scanner sCorsi) {
	
	docenti = new HashMap<String, Docente>();
	corsi = new HashMap<String, Corso>();
	
	Docente d = Docente.read(sDocenti);
	while(d!=null) {
		docenti.put(d.getCodiceFiscale(), d);
		d=Docente.read(sDocenti);
	}
	
	Corso c = Corso.read(sCorsi);
	while(c!=null) {
		try {
			corsi.put(c.getCodiceCorso(), c);
			d=cercaDocente(c.getCodiceFiscale());
			c.addDocente(d);
			d.addCorso(c);
			
		}
		catch(teacherNotFoundException e) {
			System.err.println("GENERATA ECCEZIONE TIPO TEACHER NOT FOUND");
			System.out.println(e.getMessage());
			
		}
		c=Corso.read(sCorsi);
	}
}

private Docente cercaDocente(String codiceFiscale)  {
	Docente d =docenti.get(codiceFiscale);
	if(d!=null) return d;
	throw new teacherNotFoundException("Docente non trovato ");
}


public void print() {
Set<String > keySet = docenti.keySet();
for(String key:keySet) {
	Docente d = docenti.get(key);
	d.print(System.out);
	System.out.println("CORSI EROGATI DAL DOCENTE");
	for(Corso c: d.getCorsi())
	{
		c.print(System.out);
	}
}
}

public Segreteria filterbyCodiceFiscale(String nome) {

HashMap<String, Docente> FilterDocenti= new HashMap<String, Docente>();
HashMap<String, Corso> FilterCcorsi= new HashMap<String ,Corso>();

Set<String> keySet = docenti.keySet();
for(String key:keySet) {
	Docente d = docenti.get(key);
	if(d.getNome().equalsIgnoreCase(nome)) {
		FilterDocenti.put(d.getCodiceFiscale(),d);
		for(Corso c : d.getCorsi())
			FilterCcorsi.put(c.getCodiceCorso(), c);
	}
}

	return new Segreteria(FilterDocenti, FilterCcorsi);
}

public Segreteria filterbyName(String name) {
	HashMap<String, Docente> filterDocenti= new HashMap<String, Docente>();
	HashMap<String, Corso> filterCorsi = new HashMap<String , Corso>();
	
	Set< String> keyset = docenti.keySet();
	
	for(String key :keyset) {
		Docente d = docenti.get(key);
		if(d.getNome().equalsIgnoreCase(name)) {
			filterDocenti.put(d.getCodiceFiscale(), d);
			
			for(Corso c :d.getCorsi()) {
			filterCorsi.put(c.getCodiceCorso(), c);
			}
		}
	}
		
	return new Segreteria(filterDocenti, filterCorsi);
}





public Segreteria filterBycognome(String cognome) {
	HashMap<String, Docente> filterDocenti= new HashMap<String, Docente>();
	HashMap<String, Corso> filterCorsi = new HashMap<String , Corso>();
	
	Set<String> keySet = docenti.keySet();
	for(String key : keySet) {
		Docente d = docenti.get(key);
		if(d.getCognome().equalsIgnoreCase(cognome)) {
			filterDocenti.put(d.getCodiceFiscale(), d);
		}
		for(Corso c:d.getCorsi()) {
			filterCorsi.put(c.getCodiceCorso(), c);
		}
	}
	return new Segreteria(filterDocenti, filterCorsi);
}

public Segreteria filterByData(Date data) {
	HashMap<String, Docente> filterDocenti= new HashMap<String, Docente>();
	HashMap<String, Corso> filterCorsi = new HashMap<String , Corso>();
	
	Set<String> keyset = docenti.keySet();
	for(String key : keyset) {
		Docente d = docenti.get(key);
		if(d.getDataNascita().equals(data)) {
			filterDocenti.put(d.getCodiceFiscale(), d);
			
		}
		for(Corso c: d.getCorsi()) {
			filterCorsi.put(c.getCodiceCorso(), c);
		}
		
	}
	return new Segreteria(filterDocenti, filterCorsi);
}




private HashMap<String, Docente> docenti;
private HashMap<String, Corso> corsi;
	
	
	
}
