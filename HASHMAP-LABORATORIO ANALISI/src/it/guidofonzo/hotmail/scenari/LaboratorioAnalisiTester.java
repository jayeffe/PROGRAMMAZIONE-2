package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.LaboratorioAnalisi;
import it.guidofonzo.hotmail.util.Costanti;

public class LaboratorioAnalisiTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		Scanner sPazienti = new Scanner(new File("Pazienti.dat"));
		Scanner sEsami = new Scanner(new File("Esami.dat"));
		
		LaboratorioAnalisi lab = new LaboratorioAnalisi(sPazienti, sEsami);
		
		lab.print();
		
		System.out.println("FILTRO PER NOME ");
		lab.filterByNomePaziente("Paola").filterByCognomePaziente("Bianchi").print();
		
		
		
		
		System.out.println("FILTRO PER DATA DI NASCITA ");

/*-------------------------------------------------------------------------------------------------------------*/
	System.out.println("INSERIRE DATA DI NASCITA DEL PAZIENTE ");
	
Date dataEsame;
System.out.println("inserire data gg-mm-yyyy");
SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);

try {
String data=in.nextLine();

dataEsame = sdf.parse(data);
lab.filterByDataNascita(dataEsame).print();
}
catch(ParseException e) {
System.err.println("formato non ammesso");
dataEsame=new Date();
}
		
/*-------------------------------------------------------------------------------------------------------------*/
System.out.println("\n FILTRO PER LUOGO DI NASCITA ");
lab.filterByluogoNascita("Benevento").print();


System.out.println("\n \n FILTRO PER NOME ESAME ES: EMOCROMO");
lab.filteEsamibyNome("emocromo").print();
	}

}
