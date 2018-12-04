package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



import it.guidofonzo.hotmail.classi.LaboratorioAnalisi;
import it.guidofonzo.hotmail.classi.Paziente;
import it.guidofonzo.hotmail.util.Costanti;

public class LaboratorioTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sEsami = new Scanner(new File("Esami.dat"));
		Scanner sPazienti= new Scanner(new File("Pazienti.dat"));
		
		LaboratorioAnalisi lab=new LaboratorioAnalisi(sEsami, sPazienti);
		
		System.out.println("ciao");
	}
}	


