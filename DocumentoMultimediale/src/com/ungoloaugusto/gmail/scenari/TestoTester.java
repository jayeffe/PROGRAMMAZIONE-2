package com.ungoloaugusto.gmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import com.ungoloaugusto.gmail.classi.ArchivioMultimediale;


public class TestoTester {
	
	public static void main(String[] args) throws IOException {
		Scanner c=new Scanner(System.in);
		Scanner in=new Scanner(new File("indice.txt"));
		
		ArchivioMultimediale arc = new ArchivioMultimediale(in);
		arc.print(System.out);
		
//		arc.remove(0);
		
//		arc.add(new Scanner(new File("aggiunta.txt")));
		
		arc.addFromTastiera();
		
		PrintStream ps = new PrintStream(new File("indice.txt"));
		arc.print(ps);
		
		arc.salvaRisultati("save.txt", arc.filterBySoglia(1500000000));
		
		
		System.out.println(" inserire la soglia in byte ");
		int soglia = Integer.parseInt(c.nextLine());
		arc.filterBySoglia(soglia).print(System.out);
		
		
		
}}
	
