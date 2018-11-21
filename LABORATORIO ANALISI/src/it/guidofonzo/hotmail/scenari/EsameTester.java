package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Esame;

public class EsameTester {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile=new Scanner(new File("Esami.dat"));
		
		Esame e1 = Esame.read(daFile);
		e1.print(System.out);
		
		System.out.println("**************");
		
		Esame e2 = Esame.read(daFile);
		e2.print(System.out);

		System.out.println("**************");

		Esame e3 = Esame.read(daFile);
		e3.print(System.out);
	}

}
