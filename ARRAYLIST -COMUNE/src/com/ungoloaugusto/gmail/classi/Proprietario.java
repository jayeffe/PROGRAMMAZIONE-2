package com.ungoloaugusto.gmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ungoloaugusto.gmail.util.Costanti;

public class Proprietario {
	
	    public Proprietario(String codiceFiscale, String cognome, String nome, Date datadiNascita, String luogoNascita) {
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
		this.datadiNascita = datadiNascita;
		this.luogoNascita = luogoNascita;
		this.abitazioni=new ArrayList<Abitazione>();
	}
	    
	    public void addAbitazione(Abitazione ab) {
			this.abitazioni.add(ab);
			
		}
	    
	    
	    
	    
	    
	    public ArrayList<Abitazione> getAbitazioni() {
			return abitazioni;
		}

		public String getCodiceFiscale() {
			return codiceFiscale;
		}
		public String getCognome() {
			return cognome;
		}
		public String getNome() {
			return nome;
		}
		public Date getDatadiNascita() {
			return datadiNascita;
		}
		public String getLuogoNascita() {
			return luogoNascita;
		}
		
		
		
		public static Proprietario read(Scanner sc) {
			if(!sc.hasNext()) return null;
			String codiceFiscale=sc.nextLine();
			if(!sc.hasNext()) return null;
			String cognome=sc.nextLine();
			if(!sc.hasNext()) return null;
			String nome=sc.nextLine();
			if(!sc.hasNext()) return null;
			String data=sc.nextLine();
			
			Date datadiNascita;
			SimpleDateFormat sdf =new SimpleDateFormat(Costanti.DATEFORMAT);
			try {
				datadiNascita= sdf.parse(data);
			}catch(ParseException e ) {
				System.err.println("la data non e' convertita nel modo giusto");
				System.out.println("verra' inserita la date del sistema ");
				datadiNascita=new Date();
				
			}
			
			
			if(!sc.hasNext()) return null;
			String luogoNascita=sc.nextLine();
			
			return new Proprietario(codiceFiscale, cognome, nome, datadiNascita, luogoNascita);
			
			}
		
		
		public void print(PrintStream ps) {
			ps.println(codiceFiscale);
			ps.println(cognome);
			ps.println(nome);
			SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);
			ps.println("datadiNascita : "+sdf.format(datadiNascita));
			ps.println(luogoNascita);
			
		}



	private String codiceFiscale;
	private String cognome;
	private String nome;
	private Date datadiNascita;
	private String luogoNascita;
	private ArrayList<Abitazione> abitazioni;

}
