package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Pubblicazione {

public Pubblicazione(String identificativoLibro, String argomento, String titolo, String editore, int annoPubblicazione) {
	
	this.identificativoLibro = identificativoLibro;
	this.argomento = argomento;
	this.titolo = titolo;
	this.editore = editore;
	this.annoPubblicazione = annoPubblicazione;
	this.prestiti=new ArrayList<Prestito>();
}

public void addPrestito(Prestito pr) {
	this.prestiti.add(pr);
}
public void addUtente(Utente u) {
	this.utente=u;
}

public static Pubblicazione read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String identificativoLibro= s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String argomento=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String titolo = s.nextLine();
	 
	if(!s.hasNextLine()) return null;
	String editore=s.nextLine();
	
	if(!s.hasNextInt()) return null;
	int annoPubblicazione = Integer.parseInt(s.nextLine());
	
	return new Pubblicazione(identificativoLibro, argomento, titolo, editore, annoPubblicazione);
		
}


public String getIdentificativoLibro() {
	return identificativoLibro;
}
public String getArgomento() {
	return argomento;
}
public String getTitolo() {
	return titolo;
}
public String getEditore() {
	return editore;
}
public int getAnnoPubblicazione() {
	return annoPubblicazione;
}

public void print(PrintStream ps) {
	ps.println("identificativo "+identificativoLibro);
	ps.println("argomento "+argomento);
	ps.println("titolo "+titolo);
	ps.println("editore "+editore);
	ps.println("anno pubblicazione "+annoPubblicazione);
	
}



private String identificativoLibro;
private String argomento;
private String titolo;
private String editore;
private int annoPubblicazione;
private ArrayList<Prestito> prestiti;
private Utente utente;

}
