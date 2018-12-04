package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Biblioteca;

public class BibliotecaTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sPubblicazioni = new Scanner(new File("Pubblicazioni.dat"));
		Scanner sUtenti = new Scanner(new File("Utenti.dat"));
		Scanner sPrestiti = new Scanner(new File("Prestiti.dat"));
		
		
		Biblioteca b =new Biblioteca(sPubblicazioni, sUtenti, sPrestiti);
		b.print();
		b.BubbleSort();
		System.out.println("*************************************************");
		System.out.println("ELENCO ORDINATO DIPENDENTI ");
		;
		b.print();
		
		System.out.println("\n\n filtro per nome utente e e vedo che ha in prestito");
		b.filtraByUtente("Paolo").printPrestiti();
		
		

	}

}
