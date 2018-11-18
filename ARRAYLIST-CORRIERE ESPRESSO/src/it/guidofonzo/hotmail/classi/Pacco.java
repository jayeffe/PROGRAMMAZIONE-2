package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Pacco {
	
	public Pacco(String cfDestinatario, String codicePacco, int peso, Date data) {
		this.cfDestinatario= cfDestinatario;
		this.codicePacco=codicePacco;
		this.peso=peso;
		this.data=data;
	}
	
	public static Pacco read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String cfDestinatario = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String codicePacco= s.nextLine();
		
		if(!s.hasNextInt()) return null;
		int peso = Integer.parseInt(s.nextLine());
		
	   Date data;
	   
	   if(!s.hasNextLine()) return null;
	   String dataSpedizione = s.nextLine();
	   
	   SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	   try {
		   data=sdf.parse(dataSpedizione);
	   }
	   catch(ParseException e) {
		   System.err.println("FORMATO DATA NON AMMESSO ");
		   data=new Date();
	   }
	   return new Pacco(cfDestinatario, codicePacco, peso, data);
	}
	
	
	public void AddDestinazioni(Destinatario destinazioni) {
		this.destinazioni = destinazioni; 
	}
	
	
	public Destinatario getDestinazioni() {
		return destinazioni;
	}
	
	public String getCfDestinatario() {
		return cfDestinatario;
	}
	public String getCodicePacco() {
		return codicePacco;
	}
	public int getPeso() {
		return peso;
	}
	public Date getData() {
		return data;
	}

public void print(PrintStream ps) {
	ps.println("codice fiscale "+cfDestinatario);
	ps.println("codice pacco "+codicePacco);
	ps.println("peso "+peso +"kg");
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println("data "+sdf.format(data));
}


public String toString() {
	return "Pacco [cfDestinatario=" + cfDestinatario + ", codicePacco=" + codicePacco + ", peso=" + peso + ", data="
			+ data + "]";
}




	private String cfDestinatario;
	private String codicePacco;
	private int peso;
	private Date data; 
	private Destinatario destinazioni;
	
	
}
