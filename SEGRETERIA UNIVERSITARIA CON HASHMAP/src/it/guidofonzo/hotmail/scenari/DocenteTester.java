package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Docente;

public class DocenteTester {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner daFile = new Scanner(new File("Docenti.dati"));
		
		Docente d1 = Docente.read(daFile);
	    d1.print(System.out);
		
		
		System.out.println("-----------------------------");
		Docente d2 = Docente.read(daFile);
	    d2.print(System.out);
		
		
		System.out.println("-----------------------------");
		Docente d3 = Docente.read(daFile);
	    d3.print(System.out);
		
		
		System.out.println("-----------------------------");
		Docente d4 = Docente.read(daFile);
	    d4.print(System.out);
		
		
		System.out.println("-----------------------------");
		
		
		
	}
	

}
