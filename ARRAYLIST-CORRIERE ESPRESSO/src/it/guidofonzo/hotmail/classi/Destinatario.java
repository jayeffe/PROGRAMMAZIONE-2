package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Destinatario {
	
	
	public Destinatario(String codiceFiscale, String nome, String cognome, String città, String indirizzo,
			String provincia, int cap) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.città = città;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.cap = cap;
		pacchi = new ArrayList<Pacco>();
	}
	
	public void addPacco(Pacco p) {
		this.pacchi.add(p);
	}
	
	
	
	public ArrayList<Pacco> getPacchi() {
		return pacchi;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCittà() {
		return città;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getProvincia() {
		return provincia;
	}
	public int getCap() {
		return cap;
	}
	
	public static Destinatario read(Scanner s) {
		if(!s.hasNextLine()) return null;
		String codiceFiscale = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String nome = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String cognome = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String città = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String indirizzo = s.nextLine();
		
		if(!s.hasNextLine()) return null;
		String provincia = s.nextLine();
		
		if(!s.hasNextInt()) return null;
		int cap = Integer.parseInt(s.nextLine());
		
		return new Destinatario(codiceFiscale, nome, cognome, città, indirizzo, provincia, cap);
	}
	
	
	
	

public void print(PrintStream ps) {
	ps.println("codice fiscale "+codiceFiscale);
	ps.println("nome "+nome);
	ps.println("cognome "+cognome);
	ps.println("citta "+città);
	ps.println("indirizzo "+indirizzo);
	ps.println("provincia "+provincia);
	ps.println("cap "+cap);
}

public int CompareTo(Destinatario dest) {
	if(this.cognome.compareTo(dest.getCognome())==0)
		return this.nome.compareTo(dest.getNome());
	return this.nome.compareTo(dest.getNome());
}



	
public String toString() {
	return "Destinatario [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", città="
			+ città + ", indirizzo=" + indirizzo + ", provincia=" + provincia + ", cap=" + cap + "]";
}



	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String città;
	private String indirizzo;
	private String provincia;
	private int cap;
	private ArrayList<Pacco> pacchi;
	
	

}
