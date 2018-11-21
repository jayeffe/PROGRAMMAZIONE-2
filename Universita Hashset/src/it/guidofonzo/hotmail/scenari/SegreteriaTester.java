package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Segreteria;

public class SegreteriaTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sDocenti = new Scanner(new File("Docenti.dati"));
		Scanner sCorsi = new Scanner(new File("Corsi.dati"));
		
		Segreteria s = new Segreteria(sDocenti, sCorsi);
		
		System.out.println("FILTRO PER NOME" );
		s.filterbyCodiceFiscale("Franco").print();
		
		System.out.println("*********************************");
		System.out.println("\n FILTRO PER COGNOME ");
		s.filterBycognome("Frattolillo").print();
		
		
		
		
		
		
	}

}
