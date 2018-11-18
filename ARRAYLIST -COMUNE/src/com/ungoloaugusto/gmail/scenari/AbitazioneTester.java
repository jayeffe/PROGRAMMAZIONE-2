package com.ungoloaugusto.gmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ungoloaugusto.gmail.classi.Abitazione;

public class AbitazioneTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("soluzioni.txt"));
		Abitazione abitazione1=Abitazione.read(s);
		abitazione1.print(System.out);
		
		Abitazione abitazione2=Abitazione.read(s);
		abitazione2.print(System.out);
		
		Abitazione abitazione3=Abitazione.read(s);
		abitazione3.print(System.out);
		
		
		

	}

}
