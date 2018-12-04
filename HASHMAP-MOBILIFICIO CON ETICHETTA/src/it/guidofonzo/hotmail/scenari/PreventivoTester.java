package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Mobile;
import it.guidofonzo.hotmail.classi.Preventivo;

public class PreventivoTester {
public static void main(String[] args) throws FileNotFoundException {
	
	Scanner daFile = new Scanner(new File("Preventivo.txt"));
	
	

	Preventivo p1 = Preventivo.read(daFile);
	p1.print();
	
	
	
	

	
	
}
}
