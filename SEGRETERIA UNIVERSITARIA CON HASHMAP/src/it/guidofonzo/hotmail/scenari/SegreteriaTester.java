package it.guidofonzo.hotmail.scenari;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import it.guidofonzo.hotmail.classi.Segreteria;

public class SegreteriaTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sDocenti = new Scanner(new File("Docenti.dati"));
		Scanner sCorsi = new Scanner(new File("Corsi.dati"));
		
		Segreteria s = new Segreteria(sDocenti, sCorsi);
		
		s.print();
		

	}

}
