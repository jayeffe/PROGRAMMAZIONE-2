package com.ungoloaugusto.gmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ungoloaugusto.gmail.classi.Comune;



public class ComuneTester {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sAbitazione = new Scanner( new File("soluzioni.txt"));
		Scanner sProprietario = new Scanner (new File("proprietari.txt"));
		Scanner sProprieta = new Scanner (new File("proprieta.txt"));
		Comune s = new Comune(sAbitazione, sProprietario, sProprieta);
	
		s.filterBynome("AUGUSTO").printAbitazione();
		
		
		
		

}
}