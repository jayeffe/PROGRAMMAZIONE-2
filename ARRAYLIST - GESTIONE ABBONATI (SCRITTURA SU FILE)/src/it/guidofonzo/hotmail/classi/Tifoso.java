package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;
import it.guidofonzo.hotmail.util.SessoNotFoundExcepiton;

public class Tifoso {

	public Tifoso(int numeroAbbonamento, String nome, String cognome, String sesso, Date data,
			String luogoResidenza, int numeroPartite) {
		super();
		this.numeroAbbonamento = numeroAbbonamento;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.data = data; 
		this.luogoResidenza = luogoResidenza; 
		this.numeroPartite = numeroPartite;
	}
public static Tifoso read(Scanner s) {
	if(!s.hasNextLine()) return null;
	int numeroAbbonameto;
	try {
		numeroAbbonameto=Integer.parseInt(s.nextLine());
	}
	catch(NumberFormatException e) {
		System.err.println("generata eccezione di tipo numberFormat ");
		System.err.println("inserisco un numero abbonamento di defalut");
		numeroAbbonameto=0;
	}
	if(!s.hasNextLine()) return null;
	String nome = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String cognome=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String sesso;
	
	try {
   sesso=s.nextLine();
if(!(sesso.equals("M")||sesso.equals("F")))
	throw new SessoNotFoundExcepiton("Sesso errato ");
	
	}
		catch(SessoNotFoundExcepiton se) {
			System.err.println("sesso non trovato");
			
			sesso="M";
		}
	if(!s.hasNextLine()) return null;
	String dataNascita=s.nextLine();
	
	Date data;
	
	
	SimpleDateFormat sdf = new SimpleDateFormat(Costanti.DATEFORMAT);
	try {
		data=sdf.parse(dataNascita);
	}
	catch(ParseException e ) {
		System.err.println("Generata eccezione ,Gestione data ");
		data=new Date();
	}
	
	if(!s.hasNextLine()) return null;
	String luogoResidenza = s.nextLine();
	
	if(!s.hasNextLine()) return null;
	int numeroPartite;
	
	try {
		numeroPartite=Integer.parseInt(s.nextLine());
	}
	catch (NumberFormatException e) {
		System.err.println("generata eccezione sul numero partite ");
		numeroPartite=0;
		
	}
return new Tifoso(numeroAbbonameto, nome, cognome, sesso, data, luogoResidenza, numeroPartite);
		}

public void print(PrintStream ps) {
	ps.println(numeroAbbonamento);
	ps.println(nome);
	ps.println(cognome); 
	ps.println(sesso);
	SimpleDateFormat sdf  = new SimpleDateFormat(Costanti.DATEFORMAT);
	ps.println(sdf.format(data));
	ps.println(luogoResidenza);
	ps.println(numeroPartite);
	
}
	
	public int getNumeroAbbonamento() {
		return numeroAbbonamento;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getSesso() {
		return sesso;
	}
	public Date getData() {
		return data;
	}
	public String getLuogoResidenza() {
		return luogoResidenza;
	}
	public int getNumeroPartite() {
		return numeroPartite;
	}
	
	



	public String toString() {
		return "Tifoso [numeroAbbonamento=" + numeroAbbonamento + ", nome=" + nome + ", cognome=" + cognome + ", sesso="
				+ sesso + ", data=" + data + ", luogoResidenza=" + luogoResidenza + ", numeroPartite=" + numeroPartite
				+ "]";
	}




	private int numeroAbbonamento;
	private String nome;
	private String cognome;
	private String sesso;
	private Date data;
	private String luogoResidenza;
	private int numeroPartite;
	
	
}
