package it.guidofonzo.hotmail.classi;

import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.MistakenLabelException;
import it.guidofonzo.hotmail.util.PubblicazioneNotFoundExcepiton;
import it.guidofonzo.hotmail.util.UtenteNotFoundExcepiton;

public class Biblioteca {





private Biblioteca(ArrayList<Pubblicazione> pubblicazioni, ArrayList<Utente> utenti,ArrayList<Prestito> prestiti) {
		
		this.pubblicazioni = pubblicazioni;
		this.utenti = utenti;
		this.prestiti=prestiti;
	}


public Biblioteca(Scanner sPubblicazioni, Scanner sUtenti ,Scanner sPrestiti) {
	String etichetta;
	pubblicazioni=new ArrayList<Pubblicazione>();
	utenti = new ArrayList<Utente>();  
	prestiti=new ArrayList<Prestito>();
	do {
		etichetta=sPubblicazioni.nextLine();
		Pubblicazione pu;
		try {
			if(etichetta.equalsIgnoreCase("Libro")) 
				pu=Libro.read(sPubblicazioni);
			else if(etichetta.equalsIgnoreCase("Rivista"))
				pu=Rivista.read(sPubblicazioni);
			
			else throw new MistakenLabelException("ERRORE NELLA LETTURA DELL'ETICHETTA "+etichetta);
			pubblicazioni.add(pu);
		}
		catch(MistakenLabelException e) {
			
		}
		
	}while(sPubblicazioni.hasNext());
	
Utente u = Utente.read(sUtenti);
while(u!=null) {
	utenti.add(u);
 u=Utente.read(sUtenti);
}
	Prestito pr = Prestito.read(sPrestiti);
	
	while(pr!=null) {
		prestiti.add(pr);
		try {
            u=cercaUtenteByIdentificatore(pr.getIdentificatoreUtente());
            Pubblicazione pu =cercalibroByIdentificatore(pr.getPubblicazione());
            u.AddPrestiti(pr);
             pr.AddUtente(u);
             pu.addPrestito(pr);
             pu.addUtente(u);
    
		}
		catch(PubblicazioneNotFoundExcepiton ut) { 
			System.err.println("GENERATA ECCEZIONE DI TIPO UTENTE NOT FOUND "+ut.getMessage());
		}
		catch(UtenteNotFoundExcepiton f) {
			System.err.println("ECCEZIONE DI TIPO UTENTE NOT FOUND"+f.getMessage());
		}
		
		pr=Prestito.read(sPrestiti);
	}
	
	
	
	
	
}
	

private Utente cercaUtenteByIdentificatore(String identificativoUtente) {
	int i=0;
	boolean trovato =false;
	while(i<utenti.size()&& !trovato) {
		if(utenti.get(i).getIdentificatore().equalsIgnoreCase(identificativoUtente)) {
			trovato=true;
		}
		else {
			i++;
		}
	}
	if(trovato) return utenti.get(i);
	throw new UtenteNotFoundExcepiton("Non ho trovato l'utente con l'identificativo "+identificativoUtente);
}



private Pubblicazione cercalibroByIdentificatore(String identificatoreLibro) {
	int i=0;
	boolean trovato =false;
	while(i<pubblicazioni.size()&& !trovato) {
		if(pubblicazioni.get(i).getIdentificativoLibro().equalsIgnoreCase(identificatoreLibro)) {
			trovato=true;
		}
		else {
			i++;
		}
	}
	if(trovato) return pubblicazioni.get(i);
	throw new PubblicazioneNotFoundExcepiton("non ho trovato la pubblicazione con identificativo "+identificatoreLibro);
}

public void print() {
	for(Pubblicazione p :pubblicazioni) {
		if(p instanceof Libro) {
			((Libro)p).print(System.out);
			System.out.println(" ");
		}
		else if(p instanceof Rivista) {
			((Rivista)p).print(System.out);
			System.out.println(" ");
		}
	}
	System.out.println("Utenti ");
		for(Utente u:utenti) {
			u.print(System.out);
			System.out.println(" ");
	
	}
		System.out.println("PRESTITI");
		for(Prestito pr:prestiti) {
			pr.print(System.out);
			System.out.println(" ");
		}
		
	
}

public void printUtenti() {
	for(Utente u:utenti) {
		u.print(System.out);
		System.out.println(" ");
	}
}

public void printPubblicazioni(){
	for(Pubblicazione p :pubblicazioni) {
		if(p instanceof Libro) {
			((Libro)p).print(System.out);
			System.out.println(" ");
		}
		else if(p instanceof Rivista) {
			((Rivista)p).print(System.out);
			System.out.println(" ");
		}
	}
}
public void printPrestiti() {
	for(Prestito pr:prestiti) {
		pr.print(System.out);
		System.out.println(" ");
	}
}




public Biblioteca filtraByUtente(String nomeUtente) {
	ArrayList<Pubblicazione> filterPubblicazioni = new ArrayList<Pubblicazione>();
	ArrayList<Utente> filterUtenti = new ArrayList<Utente>();
	ArrayList<Prestito> filterPrestiti= new ArrayList<Prestito>();
	
	for(Utente u :utenti) {
		if(u.getNome().equalsIgnoreCase(nomeUtente)){
		 filterUtenti.add(u);
		
		 for(Pubblicazione p:u.getPubblicazioni()) {
			 filterPubblicazioni.add(p);
		 }
		 for(Prestito pr :u.getPrestiti()) {
			 filterPrestiti.add(pr);
		 }
		}
	}
		return new Biblioteca(filterPubblicazioni, filterUtenti,filterPrestiti);
	}
	



private ArrayList<Pubblicazione> pubblicazioni;
private ArrayList<Utente> utenti;
private ArrayList<Prestito> prestiti;
}
