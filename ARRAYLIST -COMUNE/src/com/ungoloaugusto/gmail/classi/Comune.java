package com.ungoloaugusto.gmail.classi;

import java.util.ArrayList;
import java.util.Scanner;

import com.ungoloaugusto.gmail.util.AbitazioneNotFoundException;
import com.ungoloaugusto.gmail.util.ProprietarioNotFoundException;





public class Comune {
	
	private Comune(ArrayList<Proprietario> proprietari, ArrayList<Abitazione> abitazioni) {
		this.proprietari = proprietari;
		this.abitazioni = abitazioni;
	}
	
	


	
	public Comune(Scanner sAbitazione,Scanner sProprietario,Scanner sProprieta) {
		
		
		proprietari=new ArrayList<Proprietario>();
		abitazioni=new ArrayList<Abitazione>();
		
	// read process loop pattern 
	
	Abitazione abitazione=Abitazione.read(sAbitazione);
	while(abitazione!=null) {
		abitazioni.add(abitazione);
		abitazione=Abitazione.read(sAbitazione);
	}
	
	Proprietario proprietario=Proprietario.read(sProprietario);
	while(proprietario!=null) {
		proprietari.add(proprietario);
		proprietario=Proprietario.read(sProprietario);
	
		
	}
	
	Proprieta pr=Proprieta.read(sProprieta);
	while(pr!=null) {
		
		try {
			
			Abitazione ab=cercaAbitazionebyIdentificativoAbitazione(pr.getIdentificavoAbitazione());
			Proprietario pro=cercaProprietariobyCodiceFiscale(pr.getCfPossesore());
			ab.addProprietario(pro);
			pro.addAbitazione(ab);
		}
		
		catch(AbitazioneNotFoundException e) {
			System.err.println("l'anciata eccezione Abitazionenotfoundexception");
			System.err.println(e.getMessage());
		}
		
	catch(ProprietarioNotFoundException e ) {
		System.err.println("l'anciata eccezione Abitazionenotfoundexception");
		System.err.println(e.getMessage());
		
	}
		pr=Proprieta.read(sProprieta);
	}
	}















	public Proprietario cercaProprietariobyCodiceFiscale(String cfPossesore) {
		boolean trovato=false;
		int i=0;
		
		while(i<proprietari.size()&&!trovato) {
			if(proprietari.get(i).getCodiceFiscale().equalsIgnoreCase(cfPossesore)) {
				trovato=true;
				
			}
			else i++;
		}
		if(trovato)
			return proprietari.get(i);
	
	throw new ProprietarioNotFoundException("Eccezione lanciata perch� non � stato trovato il proprietario " + cfPossesore );
	}

	public Abitazione cercaAbitazionebyIdentificativoAbitazione(String identificavoAbitazione) {
		
		boolean trovato=false;
		int i=0;
		
		while(i<abitazioni.size()&&!trovato) {
			if(abitazioni.get(i).getIdentificativo().equalsIgnoreCase(identificavoAbitazione)) {
				trovato=true;
				
			}
			else i++;
		}
		if(trovato)
			return abitazioni.get(i);
	
	throw new AbitazioneNotFoundException("Eccezione lanciata perch� non � stato trovato il proprietario " + identificavoAbitazione);
	

		
	}

	
	public void print() {
		for (Proprietario p : proprietari) {
			p.print(System.out);
			System.out.println("..................");
			
		}
		for (Abitazione a : abitazioni) {
			a.print(System.out);
			System.out.println("...............");
			
			
		}
	}
	
	
public void printProprietario() {
		
		System.out.println(" PROPRIETARI : ");
		for ( Proprietario p : proprietari) {
			p.print(System.out);
			
			
		}
	}
	
	public void printAbitazione() {
		System.out.println(" ABITAZIONI : ");
		
		for (Abitazione a : abitazioni) {
			a.print(System.out);
			
			
		}
	}
	
	public Comune filterBynome(String nome) {
		ArrayList<Proprietario>filterproprietari=new ArrayList<Proprietario>();
		ArrayList<Abitazione>filterabitazoni=new ArrayList<Abitazione>();
		for(Proprietario c : proprietari) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				filterproprietari.add(c);
				for(Abitazione a:c.getAbitazioni()){
					filterabitazoni.add(a);
				}
			}
		}
		
		return new Comune(filterproprietari,filterabitazoni);
		
	}
	
	
	

	
	












	public ArrayList<Proprietario> getProprietari() {
		return proprietari;
	}





	public ArrayList<Abitazione> getAbitazioni() {
		return abitazioni;
	}















	private ArrayList<Proprietario> proprietari;
	private ArrayList<Abitazione> abitazioni;
		
}
