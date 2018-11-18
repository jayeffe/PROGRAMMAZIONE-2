package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Preconto;

public class PrecontoTester {
	public static void main(String[] args) throws FileNotFoundException {
		
		
Scanner daFile = new Scanner(new File("Preordine.dat"));

Preconto pre = Preconto.read(daFile);
pre.print(System.out);
	}
}
