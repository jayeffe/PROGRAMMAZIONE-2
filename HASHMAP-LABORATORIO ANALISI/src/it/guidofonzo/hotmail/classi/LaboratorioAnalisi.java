package it.guidofonzo.hotmail.classi;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import it.guidofonzo.hotmail.util.pazienteNotFoundException;

public class LaboratorioAnalisi {
	
	private LaboratorioAnalisi(HashMap<String, Paziente> pazienti, HashMap<String, Esame> esami) {
		this.pazienti = pazienti;
		this.esami = esami;
	}
	
	public LaboratorioAnalisi(Scanner sPazienti,Scanner sEsami) {
		pazienti = new HashMap<String, Paziente>();
		esami= new  HashMap<String, Esame>();
		
		Paziente paziente = Paziente.read(sPazienti);
		while(paziente!=null) {
			pazienti.put(paziente.getCodiceFiscale(), paziente);
			paziente=Paziente.read(sPazienti);
		}
		Esame esame = Esame.read(sEsami);
		while(esame!=null) {
			try {
				esami.put(esame.getEsameEseguito(), esame);
				paziente= cercaPazientebyCodiceFiscale(esame.getCodiceFiscale());
				esame.addPaziente(paziente);
				paziente.addEsame(esame);
			}
			catch(pazienteNotFoundException p) {
				System.err.println("LANCIATA ECCEZIONE DI TIPO PAZIENTE NON FOUND");
				System.out.println(p.getMessage());
			}
			esame=Esame.read(sEsami);
			
		}	
	}
	private Paziente cercaPazientebyCodiceFiscale(String codiceFiscale) {
		Paziente p = pazienti.get(codiceFiscale);
		if(p!=null) return p;
		throw new pazienteNotFoundException("non ho trovato il paziente che ha il codice fiscale "+codiceFiscale);
	}

public void print() {
	Set<String> keySet = pazienti.keySet();
	for(String key :keySet) {
		Paziente p = pazienti.get(key);
		p.print(System.out);
		System.out.println("\nESAMI ESEGUITI DAL PAZIENTE ");
		for(Esame e : p.getEsami()) {
			e.print(System.out);
		}
		System.out.println(" ");
	}
}

public LaboratorioAnalisi filterByNomePaziente(String nome) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = pazienti.keySet();
	for(String key : keySet) {
		Paziente p = pazienti.get(key);
		if(p.getNome().equalsIgnoreCase(nome)) {
			filtroPazienti.put(p.getCodiceFiscale(),p);
			for(Esame e : p.getEsami()) {
				filtroEsame.put(e.getEsameEseguito(), e);
			}
		}
		
	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);
}

public LaboratorioAnalisi filterByCognomePaziente(String cognome) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = pazienti.keySet();
	for(String key : keySet) {
		Paziente p = pazienti.get(key);
		if(p.getCognome().equalsIgnoreCase(cognome)) {
			filtroPazienti.put(p.getCodiceFiscale(),p);
			for(Esame e : p.getEsami()) {
				filtroEsame.put(e.getEsameEseguito(), e);
			}
		}
		
	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);	
}

public LaboratorioAnalisi filterByDataNascita(Date dataNascita) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = pazienti.keySet();
	for(String key : keySet) {
		Paziente p = pazienti.get(key);
		if(p.getData().equals(dataNascita)) {
			filtroPazienti.put(p.getCodiceFiscale(),p);
			for(Esame e : p.getEsami()) {
				filtroEsame.put(e.getEsameEseguito(), e);
			}
		}
		
	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);
}

public LaboratorioAnalisi filterByluogoNascita(String luogoNascita) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = pazienti.keySet();
	for(String key : keySet) {
		Paziente p = pazienti.get(key);
		if(p.getLuogo().equalsIgnoreCase(luogoNascita)) {
			filtroPazienti.put(p.getCodiceFiscale(),p);
			for(Esame e : p.getEsami()) {
				filtroEsame.put(e.getEsameEseguito(), e);
			}
		}

	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);
}
public LaboratorioAnalisi filteEsamibydataEsame(Date dataEsame) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = esami.keySet();
	for(String key : keySet) {
		Esame e = esami.get(key);
		if(e.getDataEsame().equals(dataEsame)) {
			filtroEsame.put(e.getEsameEseguito(),e);
			for(Paziente p : e.getPazienti()) {
				filtroPazienti.put(p.getCodiceFiscale(), p);
			}
		}

	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);
}


public LaboratorioAnalisi filteEsamibyEsameEseguito(String nomeEsame) {
	HashMap<String, Paziente> filtroPazienti = new HashMap<String,Paziente>();
	HashMap<String , Esame> filtroEsame = new HashMap<String,Esame>();
	
	Set<String> keySet = esami.keySet();
	for(String key : keySet) {
		Esame e = esami.get(key);
		if(e.getEsameEseguito().equalsIgnoreCase(nomeEsame)) {
			filtroEsame.put(e.getEsameEseguito(),e);
			for(Paziente p : e.getPazienti()) {
				filtroPazienti.put(p.getCodiceFiscale(), p);
			}
		}

	}
	return new LaboratorioAnalisi(filtroPazienti, filtroEsame);
}





	private HashMap<String, Paziente> pazienti;
	private HashMap<String, Esame> esami;
	
	
}
