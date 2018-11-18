package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import it.guidofonzo.hotmail.classi.CorriereEspresso;

public class CorriereFrameViever {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sDestinatari= new Scanner(new File("Destinatari.dat"));
		Scanner sPacchi = new Scanner(new File("Pacchi.dat"));
		
		CorriereEspresso c = new CorriereEspresso(sDestinatari, sPacchi);
		JFrame frame = new CorriereEspressoGraphic(c);
		frame.setTitle("CORRIERE");
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
