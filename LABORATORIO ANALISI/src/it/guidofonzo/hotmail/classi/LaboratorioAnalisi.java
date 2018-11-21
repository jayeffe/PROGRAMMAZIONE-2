package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;
import it.guidofonzo.hotmail.util.EsameNotFoundException;

public class LaboratorioAnalisi {
	
private LaboratorioAnalisi(ArrayList<Esame> esami, ArrayList<Paziente> pazienti) {
		this.esami = esami;
		this.pazienti = pazienti;
	}
public LaboratorioAnalisi(Scanner sEsami, Scanner sPazienti) {
	
	esami  = new ArrayList<Esame>();
	pazienti= new ArrayList<Paziente>();
	
	Esame esame = Esame.read(sEsami);
	while(esame!=null) {
		esami.add(esame);
		esame=Esame.read(sEsami);
		
	}
	
   Paziente paziente = Paziente.read(sPazienti);
  
   while(paziente!=null) {
  pazienti.add(paziente);
	   try {
	esame=cercaEsamecodiceFiscale(paziente.getCodiceFiscale());
	paziente.addEsame(esame); 
	esame.addPazienti(paziente);
	   
	  
	   }
	   catch(EsameNotFoundException e) {
		   System.err.println("lanciata eccezione");
		  System.out.println(e.getMessage());
	   }
	  
	
	   paziente=Paziente.read(sPazienti);
   }
}


public Esame cercaEsamecodiceFiscale(String cf) {
	int i=0;
	boolean trovato=false;
	while(i<esami.size()&&!trovato) {
		if(esami.get(i).getCodiceFiscale().equalsIgnoreCase(cf)) {
			trovato=true;
			
		}
		else {
			i++;
		}
	}
	if(trovato)
		return esami.get(i);
	throw new EsameNotFoundException("non ho trovato il codicefiscale "+cf);
	
	
	
}



public LaboratorioAnalisi filterExambyData(Date data) {
	ArrayList<Esame> filesami = new ArrayList<Esame>();
	
	for(Esame e:esami) {
		
		if(e.getDataEsame().equals(data)) {
			filesami.add(e);		
		}
		
	}
	
	return new LaboratorioAnalisi(filesami, this.pazienti);
	
}
public LaboratorioAnalisi filterpazientebyNome(String nome) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Paziente p :pazienti) {
		if(p.getNome().equalsIgnoreCase(nome)) {
			filterpazienti.add(p);
			filterAnalisi.addAll(p.getEsami());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}

public LaboratorioAnalisi filterpazientebyCognome(String cognome) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Paziente p :pazienti) {
		if(p.getCognome().equalsIgnoreCase(cognome)) {
			filterpazienti.add(p);
			filterAnalisi.addAll(p.getEsami());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}

public LaboratorioAnalisi filterpazientebyLuogo(String luogoNascita) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Paziente p :pazienti) {
		if(p.getLuogo().equalsIgnoreCase(luogoNascita)) {
			filterpazienti.add(p);
			filterAnalisi.addAll(p.getEsami());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}

public void print(PrintStream ps) {
	for(Paziente p : pazienti) {
		p.print(ps);
	}
	for(Esame e : esami) {
		e.print(ps);
	}
}








public LaboratorioAnalisi filterAnalisiByNome(String nomeEsame) {
	ArrayList<Paziente> filtroPazienti = new ArrayList<Paziente>();
	ArrayList<Esame> filtroEsami = new ArrayList<Esame>();
	
	for(Esame e :esami) {
		if(e.getEsameEseguito().equalsIgnoreCase(nomeEsame)) {
			filtroEsami.add(e);
			filtroPazienti.addAll(e.getPazienti());
		}
	}
	return new LaboratorioAnalisi(filtroEsami, filtroPazienti);
	
	
}


public LaboratorioAnalisi filterbyAnalisi(String analisi) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Esame e :esami) {
		if(e.getEsameEseguito().equalsIgnoreCase(analisi)) {
			filterAnalisi.add(e);
			filterpazienti.addAll(e.getPazienti());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}

public LaboratorioAnalisi filterbyDataEsame(Date dataEsame) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Esame e :esami) {
		if(e.getDataEsame().equals(dataEsame)) {
			filterAnalisi.add(e);
			filterpazienti.addAll(e.getPazienti());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}


public LaboratorioAnalisi filterbyCodiceFiscale(String CodiceFiscale) {

	ArrayList<Esame> filterAnalisi =new ArrayList<Esame>();
	ArrayList<Paziente> filterpazienti = new ArrayList<Paziente>();
	for(Esame e :esami) {
		if(e.getCodiceFiscale().equalsIgnoreCase(CodiceFiscale)) {
			filterAnalisi.add(e);
			filterpazienti.addAll(e.getPazienti());
		}
		
		
	}
	 return new LaboratorioAnalisi(filterAnalisi, filterpazienti);

	 
}

public void printEsami() {
	for(Esame e:esami) {
		e.print(System.out);
	}
	System.out.println("*****************");
	
} 

public void printPazienti() {
	for(Paziente p :pazienti) {
		p.print(System.out);
	}
}

public void add(Scanner esami,Scanner pazienti) {
	LaboratorioAnalisi la = new LaboratorioAnalisi(esami, pazienti);
	for(Esame e :la.getEsami()) {
		this.esami.add(e);
	}
	for(Paziente p: la.getPazienti()) {
		this.pazienti.add(p);
	}
}

public void addFromTastiera() {
	System.out.println("Scegli dove inserire, Esame o Paziente ");
	Scanner  in = new Scanner(System.in);
	String etichetta=in.nextLine();
	Paziente p = null;
	Esame e = null;
	
	switch (etichetta) {
	case "Paziente":
		p=Paziente.read(in);
		
		break;

	case "Esame" :
		e=Esame.read(in);
		break;
	}
	if(e!=null) {
		esami.add(e);
	}
	else if(p!=null) {
		pazienti.add(p);
	}
}


public ArrayList<Esame> getEsami() {
	return esami;
}
public ArrayList<Paziente> getPazienti() {
	return pazienti;
}


private ArrayList<Esame> esami;
private ArrayList<Paziente> pazienti;



}
