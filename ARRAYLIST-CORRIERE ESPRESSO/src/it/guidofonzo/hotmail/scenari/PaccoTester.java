package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Pacco;

public class PaccoTester  {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner daFile = new Scanner(new File("Pacchi.dat"));
		
		
		Pacco p1 = Pacco.read(daFile);
		p1.print(System.out);
		
		System.out.println("**************************");

		Pacco p2 = Pacco.read(daFile);
		p2.print(System.out);
		
		System.out.println("**************************");

		
		Pacco p3 = Pacco.read(daFile);
		p3.print(System.out);
		
		System.out.println("**************************");

		
	}
	
}

	