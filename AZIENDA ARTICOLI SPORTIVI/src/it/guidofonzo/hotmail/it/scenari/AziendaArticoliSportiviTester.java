package it.guidofonzo.hotmail.it.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.it.classi.AziendaArticoliSportivi;

public class AziendaArticoliSportiviTester {
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sProdotti=new Scanner(new File("prodotti.dat"));
		Scanner sGiacenze=new Scanner(new File("giacenze.dat"));
		Scanner sMagazzino=new Scanner(new File("magazzini.dat"));
		
		AziendaArticoliSportivi a=new AziendaArticoliSportivi(sMagazzino, sProdotti, sGiacenze);
		a.print();
		
		System.out.println("------FILTRO PER CODICE PRODOTTO-----------");
		a.filterByCodiceProdotto("SCP22LK").print();
		
		
		System.out.println("--------FILTRO PER CODICE MAGAZZINO-----------");
        a.filterbycodicemagazzino("ENG07F12").print();
        
		
        System.out.println("---FILTRO PER INDIRIZZO--------");

        a.filterbyIndirizzo("Via Roma, 24").print();
        
        
        System.out.println("--FILTRO PER QUANTITA-----------");
        a.filterbyQuantita(20).print();

}
}
