package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Mobilificio;
import it.guidofonzo.hotmail.classi.Preventivo;

public class MobilificioTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sClienti = new Scanner(new File("Cliente.txt"));
		Scanner sPreventivo = new Scanner(new File("Preventivo.txt"));
		
		Mobilificio mob  = new Mobilificio(sClienti, sPreventivo);
		System.out.println("CLIENTI ");
		mob.printCliente();
		
		System.out.println("-----------------------------------");

		System.out.println("PREVENTIVI");
		mob.printPreventivi();
		

	}

}
