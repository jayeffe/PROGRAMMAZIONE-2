package it.guidofonzo.hotmail.scenari;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import it.guidofonzo.hotmail.classi.GestoreAbbonati;

public class AbbonatiFrame {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sTifosi = new Scanner(new File("Tifosi.dati"));
		
		GestoreAbbonati ga = new GestoreAbbonati(sTifosi);
		
		JFrame frame = new GestioneAbbonatiFrame(ga);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
