package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Stanza;

public class TipoStanzaTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner daFile= new Scanner(new File("Stanze.dati"));
		
		Stanza ts = Stanza.read(daFile);
		ts.print(System.out);
		
		
	}

}
