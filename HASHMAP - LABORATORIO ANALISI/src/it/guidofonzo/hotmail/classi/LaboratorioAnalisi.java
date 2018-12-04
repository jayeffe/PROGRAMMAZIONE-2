package it.guidofonzo.hotmail.classi;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import it.guidofonzo.hotmail.util.EsameNotFoundException;

public class LaboratorioAnalisi {
	
private LaboratorioAnalisi(HashMap<String, Esame> esami, HashMap<String, Paziente> pazienti) {
		
		this.esami = esami;
		this.pazienti = pazienti;
	}


public LaboratorioAnalisi(Scanner sEsami, Scanner sPazienti) {
	
	esami  = new HashMap<String, Esame>() ;
	pazienti= new HashMap<String, Paziente>();
	
	Esame e = Esame.read(sEsami);
	while(e!=null) {
		esami.put(e.getEsameEseguito(), e);
		
	}
	
   Paziente p = Paziente.read(sPazienti); 
  
   while(p!=null) {
	   
	   try {
   pazienti.put(p.getCodiceFiscale(), p);
	e=cercaEsamecodiceFiscale(p.getCodiceFiscale());
	p.addEsame(e);
	e.addPazienti(p);
	   
	  
	   }
	   catch(EsameNotFoundException es) {
		   System.err.println("lanciata eccezione");
		  System.out.println(es.getMessage());
	   }
	  
	
	   p=Paziente.read(sPazienti);
   }
}

 
public Esame cercaEsamecodiceFiscale(String cf) {
	Esame e = esami.get(cf);
	if(e!=null) return e;
	throw new EsameNotFoundException("Esame non trovato"+cf);
	
	
}


public void print() {
	Set<String > keySet =esami.keySet();
	for(String key :keySet) {
    Esame e = esami.get(key);
    e.print(System.out);
    for(Paziente p :e.getPazienti())
    {
    	p.print(System.out);
    }
	}
}




private HashMap<String , Esame> esami;
private HashMap<String , Paziente> pazienti;
 



}
