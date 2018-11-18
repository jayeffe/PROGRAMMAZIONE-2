package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Tifoso;
import jdk.nashorn.api.tree.YieldTree;

public class TifosoTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile =new Scanner(new File("Tifosi.dati"));
		
		Tifoso t1 = Tifoso.read(daFile);
		t1.print(System.out);
		
		Tifoso t2 = Tifoso.read(daFile);
		t2.print(System.out);
		
		Tifoso t3 = Tifoso.read(daFile);
		t3.print(System.out);

	}

}
