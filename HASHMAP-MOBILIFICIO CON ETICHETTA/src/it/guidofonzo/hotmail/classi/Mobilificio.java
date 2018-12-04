package it.guidofonzo.hotmail.classi;

import java.util.ArrayList;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.clienteNotFoundException;

public class Mobilificio {
private Mobilificio(ArrayList<Cliente> clienti, ArrayList<Preventivo> preventivi) {
		
		this.clienti = clienti;
		this.preventivi = preventivi;
	}
public Mobilificio(Scanner sClienti,Scanner sPreventivi) { 
	clienti = new ArrayList<Cliente>();
	preventivi=new ArrayList<Preventivo>();
	
	Cliente cliente = Cliente.read(sClienti);
	while(cliente!=null) {
		
		clienti.add(cliente); 
		cliente=Cliente.read(sClienti);
	}
	
	Preventivo preventivo = Preventivo.read(sPreventivi);
	while(preventivo!=null) {
		try {
			preventivi.add(preventivo);
			cliente= cercaCliente(preventivo.getCfCliente());
			preventivo.addCliente(cliente);
			cliente.addPreventivo(preventivo);
			
		}
		catch(clienteNotFoundException e) {
			System.err.println("GENERATA ECCEZIONE DI TIPO CLIENTE NOT FOUND");
			System.out.println(e.getMessage());
		}
		preventivo=Preventivo.read(sPreventivi);	
	}	
}

public Cliente cercaCliente(String cf) {
	int i=0;
	boolean trovato = false;
	while(i<clienti.size() &&!trovato) {
		if(clienti.get(i).getCodiceFiscale().equalsIgnoreCase(cf)) {
			trovato=true;
		}
		else {
			i++;
		}
	}
	if(trovato) return clienti.get(i);
	throw new clienteNotFoundException("Cliente non trovato "+cf);
}
 
public void printCliente() {
	for(Cliente c : clienti) {
		c.print(System.out);
		
	
	}
	System.out.println(" ");
	
}
public void printPreventivi() {
	for(Preventivo p : preventivi) {
		p.print();
		System.out.println("-------------- ");
		System.out.println("prezzo totale  "+p.prezzoTotale());
		System.out.println("Dopo lo sconto "+p.calcolaSconto());
	}
	System.out.println("\n");
}


public Mobilificio filterbyname(String nome) {
	ArrayList<Cliente> filtroCliente = new ArrayList<Cliente>();
	ArrayList<Preventivo> filtroPreventivo = new ArrayList<Preventivo>();
	for(Cliente c : clienti) {
		if(c.getNome().equalsIgnoreCase(nome)) {
			filtroCliente.add(c);
			filtroPreventivo.addAll(c.getPreventivi()); 
		}
	}
	return new Mobilificio(filtroCliente, filtroPreventivo);
}


private ArrayList<Cliente> clienti;
private ArrayList<Preventivo> preventivi;
}
