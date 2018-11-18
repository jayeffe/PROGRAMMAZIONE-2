package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Albergo {

	public Albergo(String codiceAlbergo, String nomeAlbergo, String indirizzo, String citt�, String nazione,
			String telefono, String fax) {
		this.codiceAlbergo = codiceAlbergo;
		this.nomeAlbergo = nomeAlbergo;
		this.indirizzo = indirizzo;
		this.citt� = citt�;
		this.nazione = nazione;
		this.telefono = telefono;
		this.fax = fax;
		this.stanze=new ArrayList<Stanza>();
		
			
	}
	public void addTipoStanze(Stanza ts) {
		this.stanze.add(ts);
	}
	
	
public static Albergo read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceAlbergo=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nomeAlbergo = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String indirizzo =s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String citt� =s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String nazione =s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String telefono = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String fax= s.nextLine();
	
	return new Albergo(codiceAlbergo, nomeAlbergo, indirizzo, citt�, nazione, telefono, fax);
}

public String getNomeAlbergo() {
	return nomeAlbergo;
}
public void setNomeAlbergo(String nomeAlbergo) {
	this.nomeAlbergo = nomeAlbergo;
}
public String getCodiceAlbergo() {
	return codiceAlbergo;
}
public String getIndirizzo() {
	return indirizzo;
}
public String getCitt�() {
	return citt�;
}
public String getNazione() {
	return nazione;
}
public String getTelefono() {
	return telefono;
}
public String getFax() {
	return fax;
}
public void print(PrintStream ps) {
	ps.println("codice albergo "+codiceAlbergo);
	ps.println("nome albergo "+nomeAlbergo);
	ps.println("indirizzo "+indirizzo);
	ps.println("citta "+citt�);
	ps.println("nazione "+nazione);
	ps.println("telefono "+telefono);
	ps.println("fax "+fax);
}



	private String codiceAlbergo;
	private String nomeAlbergo;
	private String indirizzo;
	private String citt�;
	private String nazione;
	private String telefono;
	private String fax;
	private ArrayList<Stanza> stanze;
	
	
}
