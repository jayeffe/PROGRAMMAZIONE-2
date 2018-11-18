package com.ungoloaugusto.gmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class Proprieta {
	
	public Proprieta(String cfPossessore, String identificavoAbitazione) {
		this.cfPossessore = cfPossessore;
		this.identificativoAbitazione = identificavoAbitazione;
	}
	
	
	public String getCfPossesore() {
		return cfPossessore;
	}
	public String getIdentificavoAbitazione() {
		return identificativoAbitazione;
	}
	
	
	
	public static Proprieta read(Scanner sp) {
		if(!sp.hasNext()) return null;
		String cfPossessore=sp.nextLine();
		if(!sp.hasNext()) return null;
		String identificativoAbitazione=sp.nextLine();
		
		return new Proprieta(cfPossessore, identificativoAbitazione);
	}
	
	
	public void print(PrintStream ps) {
		ps.println(cfPossessore);
		ps.println(identificativoAbitazione);
	}








	private String cfPossessore;
	private String identificativoAbitazione;

}
