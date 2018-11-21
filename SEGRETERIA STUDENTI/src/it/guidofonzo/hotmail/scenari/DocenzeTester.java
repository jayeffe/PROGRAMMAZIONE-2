package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Docenze;

public class DocenzeTester {
	
public static void main(String[] args) throws FileNotFoundException {
	
	Scanner daFile= new Scanner(new File("docenze.dati"));
	
	Docenze doc = Docenze.read(daFile);
	doc.print(System.out);
	
	System.out.println("********************");
	
	Docenze doc1= Docenze.read(daFile);
	doc1.print(System.out);
	
	
	
	
	
}
}
