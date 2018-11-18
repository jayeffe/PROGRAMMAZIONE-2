package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;

public class Tavolo {	

public  Tavolo(String codiceTavolo, int numeroCommensali) {
		this.codiceTavolo=codiceTavolo;
		this.numeroCommensali = numeroCommensali;
		this.elencoPreconti=new ArrayList<Preconto>();
	}

public void aggiungiPreconto(Preconto pre) {
	this.elencoPreconti.add(pre);
}




public String getCodiceTavolo() {
	return codiceTavolo;
}
public int getNumeroCommensali() {
	return numeroCommensali;
} 


public void print(PrintStream ps) {
	ps.println("codice tavolo "+codiceTavolo);
	ps.println("numero commensali"+numeroCommensali);
	
}

private String codiceTavolo;
private int numeroCommensali;
private ArrayList<Preconto> elencoPreconti;
}

