package it.guidofonzo.hotmail.classi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.CorsoNotFoundException;
import it.guidofonzo.hotmail.util.docenteNotFoundException;


public class Segreteria {
	
	private Segreteria(ArrayList<Corso> corsi, ArrayList<Docente> docenti) {
		this.corsi = corsi;
		this.docenti = docenti;
	}
	
	public Segreteria(Scanner cor,Scanner doc,Scanner dcnz) {
		docenti = new ArrayList<Docente>();
		 corsi = new ArrayList<Corso>();
		
		Corso corso = Corso.read(cor);
		while(corso!=null) {
			corsi.add(corso);
			
			corso= Corso.read(cor);
		}
		
		Docente docente = Docente.read(doc);
		while(docente!=null) {
			docenti.add(docente);
			docente= Docente.read(doc);
		}
		
		Docenze docenze = Docenze.read(dcnz);
		while(docenze!=null) {
			try {
				Corso cors = CercaDocCC(docenze.getCodiceCorso());
			    Docente docent = CercaCocCF(docenze.getCodiceFiscaleDoc());
			    cors.addDocente(docent);
			    docent.addCorso(cors);
				
			}
			catch(docenteNotFoundException e) {
				System.err.println("eccezione lanciata DOCENTENOTFOUNDEXCEPTION ");
				System.err.println(e.getMessage());
				
				
			}
			catch(CorsoNotFoundException e) {
				System.err.println("eccezione lanciata CORSONOTFOUNDEXCEPTION");
				System.err.println(e.getMessage());
			}
			docenze=Docenze.read(dcnz);  
			
		} 
		
		
	}
	
	public void print() {
		for(Docente d: docenti) 
			d.print(System.out);
		System.out.println("CORSI EROGATI DAL DOCENTE");
		for(Corso c: corsi) 
			c.print(System.out);
		
	}
	
	public Corso CercaDocCC(String cc) {
		int i=0;
		boolean trovato = false;
		while(i<corsi.size() && !trovato) {
			if(corsi.get(i).getCodiceCorso().equalsIgnoreCase(cc)) {
				trovato=true;
				
			}
			else {
				i++;
			}
		}
		if(trovato) 
			return corsi.get(i); 
		throw new CorsoNotFoundException("NON HO TROVATO "+cc);
		
	}
	
	public Docente CercaCocCF(String cf) {
		int i=0;
		boolean trovato = false;
		while(i<corsi.size() && !trovato) {
			if(docenti.get(i).getCf().equalsIgnoreCase(cf)) {
				trovato=true;
				
			}
			else {
				i++;
			}
		}
		if(trovato) 
			return docenti.get(i);
		    throw new docenteNotFoundException("NON HO TROVATO "+cf);
		
	}
	
	public Segreteria filtraPerNome(String nome) {
		ArrayList<Docente> filterDocente = new ArrayList<Docente>();
		ArrayList<Corso> filterCorsi = new ArrayList<Corso>();
		
		for(Docente d : docenti) {
			if(d.getNome().equalsIgnoreCase(nome)) {
				filterDocente.add(d);
				for(Corso c: d.getCorsi()) {
					filterCorsi.add(c);
			}
				
			}
		}
		return new Segreteria(filterCorsi, filterDocente);
	}
	
	
	
	
	
	
	public Segreteria filterbyCredit(int crediti) {
		ArrayList<Corso> filterCorsi = new ArrayList<Corso>();
		ArrayList<Docente> filterDocenti = new ArrayList<Docente>();
		for(Corso co:corsi) {
			if(co.getCrediti()==crediti) {
				filterCorsi.add(co);
				for(Docente d : co.getDocenti()) {
					filterDocenti.add(d);
				}
			}
		}
		return new Segreteria(filterCorsi, filterDocenti);
	}
	
	
	public Segreteria filterbyData(int anno) {
		ArrayList<Corso> filterCorsi = new  ArrayList<Corso>();
		ArrayList<Docente> filterDocenti = new ArrayList<Docente>();

		for(Corso c :corsi) {
			if(c.getAnnoErog()==anno) {
				filterCorsi.add(c);
				for(Docente d : c.getDocenti()) {
					filterDocenti.add(d);
				}
			}
		}
		return new Segreteria(filterCorsi, filterDocenti);
	}
	
	public Segreteria filterbyData(String semestre) {
		ArrayList<Corso> filterCorsi = new  ArrayList<Corso>();
		ArrayList<Docente> filterDocenti = new ArrayList<Docente>();

		for(Corso c :corsi) {
			if(c.getSemesre().equalsIgnoreCase(semestre)) {
				filterCorsi.add(c);
				for(Docente d : docenti) {
					filterDocenti.add(d);
				}
			}
		}
		return new Segreteria(filterCorsi, filterDocenti);
	}
	
	
	
	public void printCorsi() {
		for(Corso c:corsi) {
			c.print(System.out);
		}
	}
	

	
	private ArrayList<Corso> corsi;
	private ArrayList<Docente> docenti;	
}
