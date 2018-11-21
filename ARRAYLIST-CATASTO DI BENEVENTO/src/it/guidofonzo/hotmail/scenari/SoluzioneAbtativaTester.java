package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.SoluzioneAbitativa;

public class SoluzioneAbtativaTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile=new Scanner(new File("Soluzioni.txt"));
		
		SoluzioneAbitativa so = SoluzioneAbitativa.read(daFile);
		so.print(System.out);
		
		SoluzioneAbitativa s1 = SoluzioneAbitativa.read(daFile);
        s1.print(System.out);
	}

}
