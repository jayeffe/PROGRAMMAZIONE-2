package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.AnnoErratoException;

public class Corso {

	public Corso(String codiceCorso, String nome, int annoErogazione,String semestre, int numeroCrediti) {
		this.CodiceCorso=codiceCorso;
		this.nome=nome;
		this.annoErogazione=annoErogazione;
		this.semestre=semestre;
		this.numeroCrediti=numeroCrediti;
		this.docenti= new ArrayList<Docente>();
	}
	
	public void addDocente(Docente d) {
		docenti.add(d);
	}
		
// METODI GET E SET
	
	
	
	
	
	public String getCodiceCorso() {
		return this.CodiceCorso;
	}
	
	public ArrayList<Docente> getDocenti() {
		return docenti;
	}

	public String getNome() {
		return this.nome;
	}
	public int getAnnoErog() {
		return this.annoErogazione;
	}
	public String getSemesre() {
		return this.semestre;
	}
	public int getCrediti() {
		return this.numeroCrediti;
	}
	
	// metodo Scanner 
	public static Corso read(Scanner sc) {
		if(!sc.hasNextLine()) return null;
		String codiceCorso= sc.nextLine();
		
		if(!sc.hasNextLine()) return null;
		String nome = sc.nextLine();
		
		if(!sc.hasNextInt()) return null;
		int annoErogazione;
		try {
			annoErogazione =Integer.parseInt(sc.nextLine());
			if(annoErogazione <1 || annoErogazione > 3) {
			throw new AnnoErratoException("l'anno è errato "+annoErogazione);
			}
		}	
		
			catch(AnnoErratoException e) {
				System.err.println("Catturata l'eccezione AnnoErrato ");
				annoErogazione=3;
				System.out.println(e.getMessage());
			}
				
		
		
		
		if(!sc.hasNextLine()) return null;
		String semestre=sc.nextLine();
		
		if(!sc.hasNextInt()) return null;
		int numCrediti =Integer.parseInt(sc.nextLine());
		
		
		
		return new Corso(codiceCorso, nome, annoErogazione, semestre,numCrediti);
	}
	
	
	public void print(PrintStream ps) {
		ps.println("codice corso " +CodiceCorso);
		ps.println("nome " +nome);
		ps.println("annoErogazione "+annoErogazione);
		ps.println("semestre "+semestre);
		ps.println("numeroCrediti "+numeroCrediti);	
		ps.println(" ");
		
		
	}
	
	
	
	
	private String CodiceCorso;
	private String nome;
	private int annoErogazione;
	private String semestre;
	private int numeroCrediti;
	private ArrayList<Docente> docenti;
	
	
	
}
