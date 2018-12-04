package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Esame {
	
	private Esame(String codiceFiscale,String esameEseguito, Date dataEsame) {
		this.CodiceFiscale =codiceFiscale;
		this.esameEseguito=esameEseguito;
		this.dataEsame=dataEsame;
		this.pazienti=new HashSet<Paziente>();
	}
	
	public void addPazienti(Paziente p) {
		pazienti.add(p);
	}
	
	public int hashCode() {
		return esameEseguito.hashCode();
	}
	
	

 public static Esame read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String codiceFiscale=s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String esameEseguito =s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String data =s.nextLine();
		
		Date dataEsame;
		
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		try {
			dataEsame=sdf.parse(data);
		}
		catch(ParseException e) {
			System.err.println("errore nell inserimento della data"+data);
			dataEsame=new Date();
		}
		
		
		return new Esame(codiceFiscale, esameEseguito, dataEsame);
	}
 
 
 
	
	public HashSet<Paziente> getPazienti() {
	return pazienti;
}

	public String getCodiceFiscale() {
		return this.CodiceFiscale;
	}
	
	public String getEsameEseguito() {
		return this.esameEseguito;
	}
	
	public Date getDataEsame() {
		return this.dataEsame;
	}
	
	
	public void print(PrintStream ps) {
		ps.println("codice fiscale "+this.CodiceFiscale);
		ps.println("esame eseguito"+this.esameEseguito);
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		ps.println("Data Esame "+sdf.format(dataEsame));
	
	}
	
	
	
	
	
	private String CodiceFiscale;
	private String esameEseguito;
	private Date dataEsame;
	private HashSet<Paziente> pazienti;
	
	
	
	

}
