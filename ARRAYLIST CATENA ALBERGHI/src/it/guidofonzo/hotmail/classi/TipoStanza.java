package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.Scanner;

public class TipoStanza {

	
public TipoStanza(int numero, double prezzo, boolean tv, boolean condizionatore, boolean frigo,
			boolean internet) {

		this.numero = numero;
		this.prezzo = prezzo;
		this.tv = tv;
		this.condizionatore = condizionatore;
		this.frigo = frigo;
		this.internet = internet;
	}

public static boolean toBoolean(String s) {
	if (s.equals("si"))
		return true;
	return false;
}
public static TipoStanza read(Scanner sc) {
	String k = sc.nextLine();
	if (k.equals("#"))  return null;
	
	
	if (!sc.hasNextLine()) return null;
	double numero= Double.parseDouble(sc.nextLine());
	
		if (!sc.hasNextLine()) return null;
		double prezzo= Double.parseDouble(sc.nextLine());


		if (!sc.hasNextLine())  return null;
		String s = sc.nextLine();
		boolean tv = false;
		
		if (s.equals("si") || s.equals("no"))
			tv = toBoolean(s);

		if (!sc.hasNextLine()) return null;
		s = sc.nextLine();
		boolean condizionatore = false;
		
		if (s.equals("si") || s.equals("no"))
			condizionatore = toBoolean(s);

		if (!sc.hasNextLine()) return null;
		s = sc.nextLine();
		boolean frigo = false;
		
		if (s.equals("si") || s.equals("no"))
			frigo = toBoolean(s);

		if (!sc.hasNextLine()) return null;
		s = sc.nextLine();
		boolean internet = false;

		if (s.equals("si") || s.equals("no"))
			internet = toBoolean(s);

		return new TipoStanza(numero, prezzo, tv, condizionatore, frigo, internet);
}

public void print() {
	System.out.println("numero"+numero);
	System.out.println("prezzo"+prezzo);
	System.out.println("tv"+tv);
	System.out.println("condizionatore"+condizionatore);
	System.out.println("frigoBar"+frigo);
	System.out.println("accesso a internet "+internet);
}


private int numero;
private double prezzo;
private boolean tv;
private boolean condizionatore;
private boolean frigo;
private boolean internet;
}



