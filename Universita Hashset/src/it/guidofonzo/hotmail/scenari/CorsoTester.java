package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Corso;

public class CorsoTester {

	public static void main(String[] args) throws FileNotFoundException {
		
Scanner daFile = new Scanner(new File("Corsi.dati"));
 Corso c1 =Corso.read(daFile);
 c1.print(System.out);
 System.out.println("******************************");
 
 Corso c2 = Corso.read(daFile);
 c2.print(System.out);
 System.out.println("******************************");

 Corso c3 = Corso.read(daFile);
 c3.print(System.out);
 System.out.println("******************************");

 Corso c4 = Corso.read(daFile);
 c4.print(System.out);
 System.out.println("******************************");


	}

}
