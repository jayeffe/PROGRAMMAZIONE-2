package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.GroupLayout.SequentialGroup;

import it.guidofonzo.hotmail.classi.LaboratorioAnalisi;
import it.guidofonzo.hotmail.classi.Paziente;
import it.guidofonzo.hotmail.util.Costanti;

public class LaboratorioTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		
		Scanner sEsami = new Scanner(new File("Esami.dat"));
		Scanner sPazienti= new Scanner(new File("Pazienti.dat"));
		
		LaboratorioAnalisi lab=new LaboratorioAnalisi(sEsami, sPazienti);
		
	lab.add(new Scanner(new File("EsameTemp.txt")), new Scanner(new File("PazientiTemp.txt")));
	lab.addFromTastiera();
	PrintStream ps = new PrintStream(new File("AGGIORNAMENTO.DAT"));
	lab.print(ps);
	
		
		
		
		
System.out.println("PAZIENTI ");
lab.printPazienti();

System.out.println("\n ESAMI ");
lab.printEsami();

System.out.println("\n FILTRO PER DATA ESAME ");

		
Date dataEsame; 
System.out.println("inserire data gg-mm-yyyy ");
SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);

try {
	String data=in.nextLine();

	dataEsame = sdf.parse(data);
	lab.filterExambyData(dataEsame).printEsami();
}
catch(ParseException e) {
	System.err.println("formato non ammesso");
	dataEsame=new Date();
}

System.out.println("\n *****FILTRO PER NOME ***********");
lab.filterAnalisiByNome("Mario").printPazienti();

System.out.println("\n ***********FILTRO PER ANALISI **************");
lab.filterbyAnalisi("Emocromo").printEsami();

		
	}
}


