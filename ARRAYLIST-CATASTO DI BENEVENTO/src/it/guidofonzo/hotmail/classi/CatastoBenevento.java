package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.CodiceFiscaleNotFoundexception;
import it.guidofonzo.hotmail.util.idNotFoundException;

public class CatastoBenevento {
	private CatastoBenevento(ArrayList<SoluzioneAbitativa> soluzioniAbitative, ArrayList<Possessore> possessori) {
		
		this.soluzioniAbitative = soluzioniAbitative;
		this.possessori = possessori;
	}
public CatastoBenevento(Scanner sSoluzioniAbitative,Scanner sPossessori,Scanner sProPoss) {
	soluzioniAbitative=new ArrayList<SoluzioneAbitativa>(); 
	possessori=new ArrayList<Possessore>();
	
	SoluzioneAbitativa so=SoluzioneAbitativa.read(sSoluzioniAbitative);
	while(so!=null) {
		soluzioniAbitative.add(so);
		so=SoluzioneAbitativa.read(sSoluzioniAbitative);
	}
	
	Possessore po = Possessore.read(sPossessori);
	while(po!=null) {
		possessori.add(po);
		po=Possessore.read(sPossessori);
		
	}
	
	Propriet‡Possessore pr =Propriet‡Possessore.read(sProPoss);
	while(pr!=null) {
		try {
		po=cercaPossessorePerCodiceFiscale(pr.getCodiceFiscale());
		so=cercaSoluzionebyId(pr.getIdentificativoAbitazione());
		po.addSoluzione(so);
		so.addPossessore(po);
		
	}
		catch(CodiceFiscaleNotFoundexception c) {
			System.err.println("GENERATA ECCEZIONE TIPO CODICE FISCALE NOT FOUND"+c.getMessage());
		}
		catch(idNotFoundException i) {
			System.err.println("GENERATA ECCEZIONE DI TIPO ID NOT FOUND"+i.getMessage());
		}
		pr=Propriet‡Possessore.read(sProPoss);

	}

}



	
	private SoluzioneAbitativa cercaSoluzionebyId(String identificativoAbitazione) {
		int i=0;
		boolean trovato=false;
		while(i<soluzioniAbitative.size()&&!trovato) {
			if(soluzioniAbitative.get(i).getIdentificativo().equalsIgnoreCase(identificativoAbitazione)) {
				trovato=true;
			}
			else {
				i++;
			}
		}
		if(trovato) return soluzioniAbitative.get(i);
		throw new idNotFoundException("non ho trovato la soluzione abitativa con id "+identificativoAbitazione);
	}
		
	

	private Possessore cercaPossessorePerCodiceFiscale(String codiceFiscale) {
	int i=0;
	boolean trovato=false;
	while(i<possessori.size()&&!trovato) {
		if(possessori.get(i).getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
			trovato=true;
		}
		else {
			i++;
		}
	}
	if(trovato) return possessori.get(i);
	throw new CodiceFiscaleNotFoundexception("non ho trovato il possessore con cf"+codiceFiscale);
}
	
	
	public ArrayList<SoluzioneAbitativa> getSoluzioniAbitative() {
		return soluzioniAbitative;
	}
	

	public ArrayList<Possessore> getPossessori() {
		return possessori;
	}
	
	public void print(PrintStream ps) {
		System.out.println("SOLUZIONI ABITATIVE");
		for(SoluzioneAbitativa s:soluzioniAbitative) {
			s.print(ps);
		}
		System.out.println("POSSESSORI");
		for(Possessore p:possessori) {
			p.print(ps);
		}
	}
	
	
	private ArrayList<SoluzioneAbitativa> soluzioniAbitative;
	private ArrayList<Possessore> possessori;
	
	
}
