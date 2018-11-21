package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.cert.Certificate;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

import it.guidofonzo.hotmail.classi.Corso;
import it.guidofonzo.hotmail.classi.Docente;
import it.guidofonzo.hotmail.classi.Docenze;
import it.guidofonzo.hotmail.classi.Segreteria;

public class SegreteriaTester {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new  Scanner(System.in);
		
		Scanner cor = new Scanner( new File("ElencoCorsi.dati"));
		Scanner doc = new Scanner (new File("docenti.dati"));
		Scanner dcnz = new Scanner (new File("docenze.dati"));
		
		
		Segreteria s =new Segreteria(cor, doc, dcnz);
		

	s.filtraPerNome("Maria").print();
	
	
	}
}
