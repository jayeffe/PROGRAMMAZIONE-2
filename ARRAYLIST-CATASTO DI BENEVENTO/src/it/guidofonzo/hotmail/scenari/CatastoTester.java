package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.CatastoBenevento;

public class CatastoTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner  sSoluzioniAbitative = new Scanner(new File("Soluzioni.txt"));
		Scanner sPossessori=new Scanner(new File("Proprietari.txt"));
		Scanner sProPoss = new Scanner(new File("Proprietà.txt"));
		
		CatastoBenevento cabn = new CatastoBenevento(sSoluzioniAbitative, sPossessori, sProPoss);
		cabn.print(System.out);

	}

}
