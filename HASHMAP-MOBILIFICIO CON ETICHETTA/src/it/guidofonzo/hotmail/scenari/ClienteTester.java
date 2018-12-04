package it.guidofonzo.hotmail.scenari;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import it.guidofonzo.hotmail.classi.Cliente;

public class ClienteTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner daFile = new Scanner(new File("cliente.txt"));
		
		Cliente c1 = Cliente.read(daFile);
		c1.print(System.out);
		System.out.println("-------------------------");
		
		Cliente c2 = Cliente.read(daFile);
		c2.print(System.out);
		
		
	}

}
