package it.guidofonzo.hotmail.it.classi;

import java.util.ArrayList;
import java.util.Scanner;



import it.guidofonzo.hotmail.it.util.ProductNotFoundException;



public class AziendaArticoliSportivi {
	
	private AziendaArticoliSportivi(ArrayList<Magazzino> magazzini, ArrayList<Prodotto> prodotti,
			ArrayList<Giacenza> giacenze) {
		this.magazzini = magazzini;
		this.prodotti = prodotti;
		this.giacenze = giacenze;
	}


	public AziendaArticoliSportivi(Scanner sMagazzini, Scanner sProdotti, Scanner sGiacenze) {
		this.magazzini=new ArrayList<Magazzino>();
		this.prodotti=new ArrayList<Prodotto>();
		this.giacenze=new ArrayList<Giacenza>();
		
		Magazzino m=Magazzino.read(sMagazzini);
		while(m!=null) {
			magazzini.add(m);
			m=Magazzino.read(sMagazzini);
		}
		
		Prodotto p=Prodotto.read(sProdotti);
		while(p!=null) {
			prodotti.add(p);
			p=Prodotto.read(sProdotti);
		}
		
		Giacenza g=Giacenza.read(sGiacenze);
		while(g!=null) {
			try {
				giacenze.add(g);
				Magazzino magazzino=cercaMagazzino(g.getCodiceMagazzino());
				Prodotto prodotto=cercaProdotto(g.getCodiceProdotto());
				g.setMagazzino(magazzino);
				g.setProdotto(prodotto);
				magazzino.aggiungiGiacenza(g);
				prodotto.addGiacenza(g);
			}
			catch(StockNotFoundException e) {
				System.err.println("Generata eccezione di tipo Stok not Found "+e.getMessage());
			}
			catch(ProductNotFoundException f) {
				System.err.println("Generata eccezione di tipo Prodotto non Found "+f.getMessage());
			}
			g=Giacenza.read(sGiacenze);
		}
	}
	
	
	
	
	
	private Magazzino cercaMagazzino(String codice) {
		int i=0;
		boolean trovato=false;
		while(i<magazzini.size()&&!trovato) {
			if(magazzini.get(i).getCodice().equalsIgnoreCase(codice)) {
				trovato=true;
			}
			else {
				i++;
			}
		}
		if(trovato) return magazzini.get(i);
		throw new ProductNotFoundException("Non ho trovato il prodotto che possiede il codice prodotto "+codice);
	}
	
	
	private Prodotto cercaProdotto(String codice) {
		int i=0;
		boolean trovato=false;
		while(i<prodotti.size()&&!trovato) {
			if(prodotti.get(i).getCodice().equalsIgnoreCase(codice)) {
				trovato=true;
			}
			else {
				i++;
			}
		}
		if(trovato) return prodotti.get(i);
		throw new ProductNotFoundException("Non ho trovato il prodotto che possiede il codice prodotto "+codice);
	}
	
	
	
	public void print() {
		
	for(Magazzino m :magazzini) {
		m.print();
		
	}
	for(Prodotto p :prodotti) {
		p.print();
	}
	
	}
	
	public AziendaArticoliSportivi filterByCodiceProdotto(String codiceProdotto) { 

	 ArrayList<Magazzino> filterMagazzini=new ArrayList<Magazzino>();
	 ArrayList<Prodotto> filterProdotti=new ArrayList<Prodotto>();
	ArrayList<Giacenza> filterGiacenze=new ArrayList<Giacenza>();
	
	Prodotto pro = cercaProdotto(codiceProdotto);
	for(Giacenza g:giacenze) {
		if(pro.getCodice().equals(g.getCodiceProdotto())) {
			Magazzino mag = cercaMagazzino(g.getCodiceMagazzino());
			filterMagazzini.add(mag);
		}
	}
	return new AziendaArticoliSportivi(filterMagazzini, filterProdotti, filterGiacenze);
	}
	
	
	public AziendaArticoliSportivi filterbycodicemagazzino(String codiceMagazzino) {

		 ArrayList<Magazzino> filterMagazzini=new ArrayList<Magazzino>();
		 ArrayList<Prodotto> filterProdotti=new ArrayList<Prodotto>();
		ArrayList<Giacenza> filterGiacenze=new ArrayList<Giacenza>();
		
		Magazzino mag = cercaMagazzino(codiceMagazzino);
		for(Giacenza g: giacenze) {
			if(mag.getCodice().equals(g.getCodiceMagazzino())) {
				Prodotto pro = cercaProdotto(g.getCodiceProdotto());
				filterMagazzini.add(mag);
				filterProdotti.add(pro);
			
			}
		}
 return new AziendaArticoliSportivi(filterMagazzini, filterProdotti, filterGiacenze);
		
	}
	
	public AziendaArticoliSportivi filterbyIndirizzo(String indirizzo) {
		 ArrayList<Magazzino> filterMagazzini=new ArrayList<Magazzino>();
		 ArrayList<Prodotto> filterProdotti=new ArrayList<Prodotto>();
		ArrayList<Giacenza> filterGiacenze=new ArrayList<Giacenza>();
		
		
		for(Magazzino m :magazzini) {
			if(m.getIndirizzo().equalsIgnoreCase(indirizzo)) {
				filterMagazzini.add(m);
				for(Giacenza g : m.getGiacenze()) {
					Prodotto pro = cercaProdotto(g.getCodiceProdotto());
					filterProdotti.add(pro);
				}
			}
		}
		
	return new AziendaArticoliSportivi(filterMagazzini, filterProdotti, filterGiacenze);	
	} 
	
	
	public AziendaArticoliSportivi filterbyQuantita(int quantità) {
		 ArrayList<Magazzino> filterMagazzini=new ArrayList<Magazzino>();
		 ArrayList<Prodotto> filterProdotti=new ArrayList<Prodotto>();
		ArrayList<Giacenza> filterGiacenze=new ArrayList<Giacenza>();
		
		for(Giacenza g :giacenze) {
			if(g.getQuantità()==quantità) {  
				filterGiacenze.add(g);
				Prodotto p = cercaProdotto(g.getCodiceProdotto());
				filterProdotti.add(p);
				Magazzino m =cercaMagazzino(g.getCodiceMagazzino());
				filterMagazzini.add(m);
			}
		}
		
		return new AziendaArticoliSportivi(filterMagazzini, filterProdotti, filterGiacenze);
				
	}
	
	
	
	public ArrayList<Magazzino> getMagazzini() {
		return magazzini;
	}


	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}


	public ArrayList<Giacenza> getGiacenze() {
		return giacenze;
	}


	


	private ArrayList<Magazzino> magazzini;
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Giacenza> giacenze;
}
