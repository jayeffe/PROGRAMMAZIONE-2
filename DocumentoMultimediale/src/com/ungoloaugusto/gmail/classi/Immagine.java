package com.ungoloaugusto.gmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ungoloaugusto.gmail.util.Costanti;

public class Immagine extends Testo {
	
	public Immagine(String percorsoFile, int dimensioneBytes, Date dataCreazione, Date dataModifica,
			String descrizione, String formatoFile,int larghezzaImmagine,int altezzaImmagine) {
		super(percorsoFile, dimensioneBytes, dataCreazione, dataModifica, descrizione, formatoFile);
		
		this.altezzaImmagine=altezzaImmagine;
		this.larghezzaImmagine=larghezzaImmagine;
		
	}
	
	public int getLarghezzaImmagine() {
		return larghezzaImmagine;
	}
	public void setLarghezzaImmagine(int largezzaImmagine) {
		this.larghezzaImmagine = larghezzaImmagine;
	}
	public int getAltezzaImmagine() {
		return altezzaImmagine;
	}
	public void setAltezzaImmagine(int altezzaImmagine) {
		this.altezzaImmagine = altezzaImmagine;
	}

	
	public static Immagine read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String percorsoFile=s.nextLine();
		
		if(!s.hasNextInt()) return null;
		int dimensioneBytes=Integer.parseInt(s.nextLine());
		
		if(!s.hasNextLine()) return null;
		String datac=s.nextLine();
		
		Date dataCreazione;
		
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		try {
			
			dataCreazione=sdf.parse(datac);
			
		}
		catch(ParseException e ) {
			System.err.println("GENERATA ECCEZZIONE DI TIPO DATA "+datac );
			System.err.println(" verrà generata la data del sistema ");
			dataCreazione=new Date();
			
		}
		
		if(!s.hasNextLine()) return null;
		String datam=s.nextLine();
		
		Date dataModifica;
		
		SimpleDateFormat sdfm= new SimpleDateFormat(Costanti.DATEFORMAT);
		try {
			
			dataModifica=sdfm.parse(datam);
			
		}
		catch(ParseException e ) {
			
			System.err.println("GENERATA ECCEZZIONE DI TIPO DATA "+datam );
			System.err.println(" verrà generata la data del sistema ");
			dataModifica=new Date();
			
		}
		
		if(!s.hasNextLine()) return null;
		String descrizione=s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String formatoFile=s.nextLine();
		
		if(!s.hasNextInt()) return null;
		int larghezzaImmagine=Integer.parseInt(s.nextLine());
		
		if(!s.hasNextInt()) return null;
		int altezzaImmagine=Integer.parseInt(s.nextLine());
		
		
		
		return new Immagine(percorsoFile,dimensioneBytes,dataCreazione,dataModifica,descrizione,formatoFile,larghezzaImmagine,altezzaImmagine);
	}
	
	public void print(PrintStream ps ) {
		super.print(ps);
		ps.println(larghezzaImmagine);
		ps.println(altezzaImmagine);
	}
	



	private int larghezzaImmagine;
	private int altezzaImmagine;

}
