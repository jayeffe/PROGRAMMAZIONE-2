package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Possessore;

public class PossessoriTester {

	public static void main(String[] args) throws FileNotFoundException {
		
    Scanner dafile = new Scanner(new File("Proprietari.txt"));
Possessore p = Possessore.read(dafile);
p.print(System.out);

Possessore p1 = Possessore.read(dafile);
p1.print(System.out);

	}

}
