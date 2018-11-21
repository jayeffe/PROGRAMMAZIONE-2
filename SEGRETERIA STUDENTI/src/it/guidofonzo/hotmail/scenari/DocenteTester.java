package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Docente;

public class DocenteTester {
public static void main(String[] args) throws FileNotFoundException, ParseException {
	
	Scanner doc = new Scanner(new File("docenti.dati"));
	
Docente d = Docente.read(doc);
d.print(System.out);
	
System.out.println("\n ***************************");

Docente d1 = Docente.read(doc);
d1.print(System.out);


System.out.println("******************************");
d.print(System.out);

}
}
