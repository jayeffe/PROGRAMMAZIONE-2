package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Corso;

public class CorsoTester {
public static void main(String[] args) throws FileNotFoundException {
	
	Scanner daFile = new Scanner(new File("ElencoCorsi.dati"));
	
	Corso cor = Corso.read(daFile);
	cor.print(System.out);
	
	
	Corso cor2 = Corso.read(daFile);
	cor2.print(System.out);
}








}
