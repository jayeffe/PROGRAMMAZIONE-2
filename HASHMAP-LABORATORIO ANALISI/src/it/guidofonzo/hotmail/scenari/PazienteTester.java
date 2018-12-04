package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Paziente;

public class PazienteTester {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile= new Scanner(new File("Pazienti.dat"));
		
	Paziente p1 = Paziente.read(daFile);
			p1.print(System.out);
	
System.out.println("**************************");
    

Paziente p2 = Paziente.read(daFile);
		p2.print(System.out);
		
System.out.println("**************************");
		
Paziente p3 =Paziente.read(daFile);
p3.print(System.out);
		
	}
}