package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import it.guidofonzo.hotmail.util.Costanti;

public class Preconto {
	
	
	
	
private Preconto(String codiceTavolo, Date data, String ora, ArrayList<OrdineMenu> ordiniClienti) {
	    this.codiceTavolo=codiceTavolo;
		this.data = data;
		this.ora = ora;
		this.ordiniClienti =ordiniClienti;
	}

public void aggiugiTavolo(Tavolo t) {
	this.tavoli=t;
}



public static Preconto read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceTavolo=s.nextLine();
    
	if(!s.hasNextLine()) return null;
	String dataOrdine=s.nextLine();
	
	Date data;
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	try {
		data=sdf.parse(dataOrdine);
		
	}
	catch(ParseException pe) {
		System.err.println("DATA NON VALIDA ");
		data=new Date();
	}
	if(!s.hasNextLine()) return null;
	String ora =s.nextLine();
	
	
	OrdineMenu ordine =OrdineMenu.read(s);
	ArrayList<OrdineMenu> ordiniClienti = new ArrayList<OrdineMenu>();
	while(ordine!=null) {
		ordiniClienti.add(ordine);
		ordine=OrdineMenu.read(s);
	}
	
return new  Preconto(codiceTavolo, data, ora, ordiniClienti);

}

public String getCodiceTavolo() {
	return codiceTavolo;
}
public Date getData() {
	return data;
}
public String getOra() {
	return ora;
}
public ArrayList<OrdineMenu> getOrdiniClienti() {
	return ordiniClienti;
}

public Tavolo getTavoli() {
	return tavoli;
}

public void print(PrintStream ps) {
	ps.println("codice tavolo "+codiceTavolo);
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);

	ps.println("data ordine "+sdf.format(data));
	ps.println("ora "+ora);
	
	for(OrdineMenu or: ordiniClienti) {
		or.print(ps);
	}
	
	}
	
	


private String codiceTavolo;
private Date data;
private String ora;
private ArrayList< OrdineMenu> ordiniClienti;  // MI LEGGE LE INFO DI  ORDINE MENU OVVERO IL NOME P E PREZZO
private Tavolo tavoli;


}
