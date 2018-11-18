package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.CatenaAlberghi;

public class CatenaAlberghiTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sAlbrghi=new Scanner(new File("Alberghi.dati"));
		Scanner ssTanze=new Scanner(new File("Stanze.dati"));
		
		CatenaAlberghi cat = new CatenaAlberghi(sAlbrghi, ssTanze);
		cat.print();

	}

}
