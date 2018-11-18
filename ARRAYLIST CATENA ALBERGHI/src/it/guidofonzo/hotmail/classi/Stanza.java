package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stanza<ServiziStanza> {
	
	
public Stanza(String codiceAlbergo, ArrayList<TipoStanza> tipo) {
		this.codiceAlbergo = codiceAlbergo;
		this.tipo=tipo;
	}



public void addAlbergo(Albergo al) {
	this.albergo=al;
}


public static Stanza read(Scanner sc) {
	ArrayList<TipoStanza> ti = new ArrayList<TipoStanza>();
	if (!sc.hasNextLine()) return null;
	String codiceAlbergo = sc.nextLine();

	TipoStanza tp = TipoStanza.read(sc);

	while (tp != null) {
		ti.add(tp);
		tp = TipoStanza.read(sc);
	}

	return new Stanza(codiceAlbergo, ti);
}



public String getCodiceAlbergo() {
	return codiceAlbergo;
}


public void print(PrintStream ps) {
	ps.println("codice albergo "+codiceAlbergo);

	for (TipoStanza tp : tipo)
		tp.print();
}

	



private String codiceAlbergo;
private ArrayList<TipoStanza> tipo;
private Albergo albergo;


}
