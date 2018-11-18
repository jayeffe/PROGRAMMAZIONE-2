package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.CorriereEspresso;
import jdk.net.NetworkPermission;

public class CorriereEspressoTester {

	public static void main(String[] args) throws FileNotFoundException {

Scanner sDestinatari = new Scanner(new File("Destinatari.dat"));
Scanner sPacchi = new Scanner(new File("Pacchi.dat"));

CorriereEspresso  c = new CorriereEspresso(sDestinatari, sPacchi);
c.print(System.out);
c.bubbleSort();

System.out.println("ORDINATO ");
c.print(System.out);



/* STAMPA IL RISULTATO DI UN FILTRO SU FILE */
//c.StampaSuFile("FiltroName.txt", c.filterByNome("Luigi"));


// c.add(new Scanner(new File("AggiuntaDestinatari.txt")), new Scanner(new File("AggiuntaPacchi.txt")));
// c.addFromTastiera();

//PrintStream ps= new PrintStream(new File("Pacchi.dat"));
// c.print(ps);
	}
}



/*

System.out.println("***********FILTRO PER CODICE FISCALE*****************");
c.filterByCf("FNZGFT56C24A783S").printDestinatari();

System.out.println("***********FILTRO PER NOME*****************");
c.filterByNome("LUIGI").printDestinatari();

System.out.println("***********FILTRO PER COGNOME*****************");
c.filterByCogNome("ROSSI").printDestinatari();

System.out.println("***********FILTRO PER CITTA*****************");
c.filterByCitta("AVELLINO").printDestinatari();

System.out.println("***********FILTRO PER PESO MAGGIORE DI *****************");
c.filterByPeso(10).printPacchi();
System.out.println("***********FILTRO PER PESO MINORE DI *****************");
c.filterByPesom(10).printPacchi();

System.out.println("***********FILTRO PER CODICE PACCO*****************");
c.filterByCodicePacco("A-344").printPacchi();
		
	}


}   */ 