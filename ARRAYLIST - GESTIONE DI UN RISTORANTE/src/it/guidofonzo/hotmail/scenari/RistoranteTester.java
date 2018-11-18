package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Ristorante;
import it.guidofonzo.hotmail.classi.Tavolo;

public class RistoranteTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sOrdini=new Scanner(new File("Menu.dat"));
		Scanner sPreconti =new Scanner(new File("preordine.dat"));
		
	Ristorante ri = new Ristorante(sOrdini, sPreconti);
	ri.print(System.out);
		
	System.out.println("*********************************");
	
	
	ri.aggiungiTavolo("1a", 3);


	}
	
	

}
