package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Destinatario;

public class DestinazioneTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile= new Scanner(new File("Destinazioni.dat"));
		
		
		Destinatario d1 = Destinatario.read(daFile);
		d1.print(System.out);
		
		System.out.println("******************************");
		Destinatario d2 = Destinatario.read(daFile);
		d2.print(System.out);
		
		System.out.println("******************************");

	    Destinatario d3 = Destinatario.read(daFile);
	    d3.print(System.out);
		
		
		
		
		
		
	}

}
