package com.ungoloaugusto.gmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ungoloaugusto.gmail.classi.Proprietario;

public class ProprietarioTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc=new Scanner(new File("proprietari.txt"));
		Proprietario p1=Proprietario.read(sc);
		p1.print(System.out);
		
		
		Proprietario p2=Proprietario.read(sc);
		p2.print(System.out);
		
		Proprietario p3=Proprietario.read(sc);
		p3.print(System.out);
		
		

	}

}
