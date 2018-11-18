package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Albergo;

public class AlbergoTester {

	public static void main(String[] args) throws FileNotFoundException {
	Scanner daFile =new Scanner(new File("Alberghi.dati"));
	
	Albergo alb =Albergo.read(daFile);
	alb.print(System.out);
	
	System.out.println("***********************************");
	
	Albergo alb2= Albergo.read(daFile);
	alb2.print(System.out);
	}
	
	

}
