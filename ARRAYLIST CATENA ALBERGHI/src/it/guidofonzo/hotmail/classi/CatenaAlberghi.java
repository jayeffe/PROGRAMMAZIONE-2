package it.guidofonzo.hotmail.classi;

import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.AlbergoNotFoundException;

public class CatenaAlberghi {
private CatenaAlberghi(ArrayList<Albergo> alberghi, ArrayList<Stanza> stanze) {
		
		this.alberghi = alberghi;
		this.stanze = stanze;
	}

public CatenaAlberghi(Scanner sAlberghi, Scanner ssTanze) {
	alberghi=new ArrayList<Albergo>();
	stanze=new ArrayList<Stanza>();
	
	
	Stanza st = Stanza.read(ssTanze);
	while(st!=null) {
		stanze.add(st);
		st=Stanza.read(ssTanze);
	}
	
Albergo al = Albergo.read(sAlberghi);
while(al!=null) {
	try {
		alberghi.add(al);
		st=cercaAlbergoBycodice(al.getCodiceAlbergo());
		st.addAlbergo(al);
		al.addTipoStanze(st);
	    
	
		
	}
	catch(AlbergoNotFoundException alb) {
		System.err.println("GENERATA ECCEZIONE "+alb.getMessage());
	}
	
	al=Albergo.read(sAlberghi);
}
	
	
	
	
}



private Stanza cercaAlbergoBycodice(String codiceAlbergo) {
	int  i =0;
	boolean trovato = false;
	while(i<stanze.size()&&!trovato) {
		if(stanze.get(i).getCodiceAlbergo().equalsIgnoreCase(codiceAlbergo)) {
			trovato=true;
		}
		else {
			i++;
		}
	}
	if(trovato) return stanze.get(i);
	throw new AlbergoNotFoundException("non ho trovato l'albergo con codice "+codiceAlbergo);
}


public void print() {
	for(Albergo a : alberghi) {
		a.print(System.out);
	}
	for(Stanza tipo :stanze) {
		tipo.print(System.out);
	}
}




private ArrayList<Albergo> alberghi;
private ArrayList<Stanza> stanze;
}
