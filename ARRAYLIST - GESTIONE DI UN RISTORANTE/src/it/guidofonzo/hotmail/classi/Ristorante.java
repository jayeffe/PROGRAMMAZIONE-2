package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.MistakenLabelException;
import it.guidofonzo.hotmail.util.TableNotFoundException;
import it.guidofonzo.hotmail.util.TavoloOccupato;

public class Ristorante {
private Ristorante(ArrayList<OrdineMenu> ordiniPietanze, ArrayList<Preconto> preconti, ArrayList<Tavolo>tavoli) {
		this.ordiniPietanze = ordiniPietanze;
		this.preconti = preconti;
		this.tavoli=tavoli;
	}
 
public Ristorante(Scanner sOrdini, Scanner sPreconti) {
	String etichetta;
	ordiniPietanze=new ArrayList<OrdineMenu>();
	tavoli=new ArrayList<Tavolo>(); 
	preconti = new ArrayList<Preconto>();
	do {
		etichetta=sOrdini.nextLine();
		OrdineMenu ord;
		try {
			if(etichetta.equalsIgnoreCase("PIATTO"))
				ord=Piatto.read(sOrdini);
			else if(etichetta.equalsIgnoreCase("VINO"))
			ord =Vino.read(sOrdini);
			 
			else throw new  MistakenLabelException("etichetta non letta correttamente"+etichetta);
			ordiniPietanze.add(ord);
		}
		catch(MistakenLabelException e) { 
			System.err.println("Etichetta non letta "+e.getMessage());
			while(sOrdini.hasNextLine() && !etichetta.equalsIgnoreCase("PIATTO") &&
					!etichetta.equalsIgnoreCase("VINO")){
				etichetta=sOrdini.nextLine();
			}
		}
		
	}while(sOrdini.hasNext());
		

	Preconto pre =Preconto.read(sPreconti);
	while(pre!=null) {
		preconti.add(pre);
		pre=Preconto.read(sPreconti);
}
	
}

private Tavolo cercaTavoloByCodice(String tavolo) {
	int i=0;
	boolean trovato=false;
	while(i<tavoli.size()&&!trovato) {
		if(tavoli.get(i).getCodiceTavolo().equalsIgnoreCase(tavolo)) {
			trovato=true;
			
		}
		else {
			i++;
		}
		
	}
	if(trovato) return tavoli.get(i);
	throw new TableNotFoundException("non ho trovato il tavolo ");
}

public void aggiungiTavolo(String codice,int commensali) {
	Tavolo t = new Tavolo(codice,commensali);
	try {
		if(tavoli.contains(t)) throw new TavoloOccupato("tavolo impegnato ");
		tavoli.add(t);
	}
	catch(TavoloOccupato Exception) {
		System.err.println("generata eccezione di tipo tavolo occupato");
	}

		}
		
	


public void print(PrintStream ps) {
	for(OrdineMenu ord: ordiniPietanze) {
		if(ord instanceof Piatto){
			((Piatto)ord).print(ps);
		} 
		else if(ord instanceof Vino) {
			((Vino)ord).print(ps);
		} 
	}	
}
	


private ArrayList<OrdineMenu> ordiniPietanze;
private ArrayList<Preconto> preconti; 
private ArrayList< Tavolo> tavoli;

}
