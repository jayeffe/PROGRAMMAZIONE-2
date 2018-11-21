package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Propriet‡Possessore {
public Propriet‡Possessore(String codiceFiscale, String identificativoAbitazione) {
		
		this.codiceFiscale = codiceFiscale;
		this.identificativoAbitazione = identificativoAbitazione;
	}

public static Propriet‡Possessore read(Scanner s) {
	if(!s.hasNextLine()) return null;
	String codiceFiscale=s.nextLine();
	
	if(!s.hasNextLine()) return null;
	String identificativoAbitazione=s.nextLine();
	
	return new Propriet‡Possessore(codiceFiscale, identificativoAbitazione);
}


public String getCodiceFiscale() {
	return codiceFiscale;
}

public String getIdentificativoAbitazione() {
	return identificativoAbitazione;
}





public void print(PrintStream ps) {
	ps.println(codiceFiscale);
	ps.println(identificativoAbitazione);
}
private String codiceFiscale;
private String identificativoAbitazione;


}
