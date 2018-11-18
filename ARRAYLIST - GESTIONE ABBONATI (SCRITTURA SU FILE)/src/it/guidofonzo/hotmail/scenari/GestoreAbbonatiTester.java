package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.GestoreAbbonati;

public class GestoreAbbonatiTester {

	public static void main(String[] args) throws IOException {
		
	Scanner sTifosi = new Scanner(new File("Tifosi.dati"));
	
	GestoreAbbonati ge = new GestoreAbbonati(sTifosi);
	
	//******** AGGIUNGERE IL RISULTATO DI UN FILTRO DATASTIERA
	ge.printOnFile("Statistiche.dati", ge.filterBySesso("M"));
	
    // AGGIUNTA ALLE STATISTICHE 
	ge.printOnFile("Statistiche.dati", ge.filterBySesso("F"));

	// AGGIUNTA DIUN TIFOSO:
    //ge.add(new Scanner(new File("Temp.txt")));
	//ge.addFromTastiera();
	//PrintStream ps = new PrintStream(new File("Tifosi.dati"));
	//ge.print(ps);
	
	ge.removeFile(new File("Temp.txt"));
	
	}
	
	
	
	

}
