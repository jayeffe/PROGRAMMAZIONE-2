package com.ungoloaugusto.gmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ungoloaugusto.gmail.util.Costanti;

public class Testo {
	
	
	public Testo(String percorsoFile, int dimensioneBytes, Date dataCreazione, Date dataModifica, String descrizione,
			String formatoFile) {
		this.percorsoFile = percorsoFile;
		this.dimensioneBytes = dimensioneBytes;
		this.dataCreazione = dataCreazione;
		this.dataModifica = dataModifica;
		this.descrizione = descrizione;
		this.formatoFile = formatoFile;
	}
	
	
	public String getPercorsoFile() {
		return percorsoFile;
	}
	public void setPercorsoFile(String percorsoFile) {
		this.percorsoFile = percorsoFile;
	}
	public int getDimensioneBytes() {
		return dimensioneBytes;
	}
	public void setDimensioneBytes(int dimensioneBytes) {
		this.dimensioneBytes = dimensioneBytes;
	}
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public Date getDataModifica() {
		return dataModifica;
	}
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFormatoFile() {
		return formatoFile;
	}
	public void setFormatoFile(String formatoFile) {
		this.formatoFile = formatoFile;
	}

	
	
	public static Testo read(Scanner s) {
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
		
		
		
		return new Testo(percorsoFile,dimensioneBytes,dataCreazione,dataModifica,descrizione,formatoFile);
	}
	
	
	public void print(PrintStream ps) {
		
		ps.println(percorsoFile);
		ps.println(dimensioneBytes);
		SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
		ps.println(sdf.format(dataCreazione));
		SimpleDateFormat sdfm = new SimpleDateFormat(Costanti.DATEFORMAT);
		ps.println(sdfm.format(dataModifica));
		ps.println(descrizione);
		ps.println(formatoFile);
		
		
	}

















	private String percorsoFile;
	private int dimensioneBytes;
	private Date dataCreazione;
	private Date dataModifica;
	private String descrizione;
	private String formatoFile;
	
	
					
}
