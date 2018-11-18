package com.ungoloaugusto.gmail.classi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


import com.ungoloaugusto.gmail.util.MistakenLabelException;

public class ArchivioMultimediale {

	private ArchivioMultimediale(ArrayList<Testo> testi) {
		this.testi = testi;
	}
	
	public ArchivioMultimediale(Scanner in) {
		
		testi=new ArrayList<Testo>();
		String etichetta=null;
		Testo test=null;
		boolean finito=false;

		
		while(in.hasNextLine()) {
			
		
			etichetta=in.nextLine();
		
				try {
				if(!(etichetta.equalsIgnoreCase("Testo")||etichetta.equalsIgnoreCase("Audio") || etichetta.equalsIgnoreCase("Immagine") || etichetta.equalsIgnoreCase("Video")))
				throw new MistakenLabelException(" l'etichetta letta è diversa ");
//				 
//				if(etichetta.equalsIgnoreCase("Audio")) {
//					test=Audio.read(in);
//				 	testi.add(test);
//				 	}
//				 
//				else{ 
//					if(etichetta.equalsIgnoreCase("Immagine")){
//						
//						
//					test=Immagine.read(in);
//					testi.add(test);
//					}else {
//					if(etichetta.equalsIgnoreCase("Video")) {
//						test=Video.read(in);
//						testi.add(test);
//						}
//				}
//					if(etichetta.equalsIgnoreCase("Testo")) {
//						test=Testo.read(in);
//						testi.add(test);
//						}
//				
				switch (etichetta) {
				case "Audio":
					test=Audio.read(in);
				 	break;
				case "Immagine":
					test=Immagine.read(in);
					break;
				case "Video":
					test=Video.read(in);
					break;
				case "Testo":
					test=Testo.read(in);
					break;
				}
				if(test != null)
					testi.add(test);
			
			}catch(MistakenLabelException e) {
					System.err.println("Catturata eccezionedi tipo mistakenLabelExcepiton ");
					System.err.println("nella lettura della label " + etichetta);
				System.err.println("il resto delfile sara' ignorato");
				finito  = true;
		
		
		
					
	}
				
		}
		
	}
	

	public ArrayList<Testo> getTesti(){
		return testi;
	}
	
	
	public ArchivioMultimediale filterBySoglia(int soglia) {
		ArrayList<Testo> filtrotesto=new ArrayList<Testo>();
		for(Testo t: testi) {
			if(t.getDimensioneBytes()>soglia) {
				filtrotesto.add(t);
			}
		}
		return new ArchivioMultimediale(filtrotesto);
	}
	
	public void add(Scanner in) {
		ArchivioMultimediale a = new ArchivioMultimediale(in);
		
		for (Testo testo : a.getTesti()) {
			this.testi.add(testo);
		}
	}
	public void addFromTastiera() {
		System.out.println("Inserisci tipo di file");
		Scanner sc = new Scanner(System.in);
		String etichetta = sc.nextLine();
		Testo test = null;
		switch (etichetta) {
		case "Audio":
			test=Audio.read(sc);
		 	break;
		case "Immagine":
			test=Immagine.read(sc);
			break;
		case "Video":
			test=Video.read(sc);
			break;
		case "Testo":
			test=Testo.read(sc);
			break;
		}
		if(test != null)
			testi.add(test);
		else
			System.err.println("Errore nell'inserimento");
		
	}
	
	public void print(PrintStream ps) {
		for(Testo t:testi) {
			if(t instanceof Audio ) {
				ps.println("Audio");
			}else if(t instanceof Immagine) {
				ps.println("Immagine");
			}else if(t instanceof Video) {
				ps.println("Video");
			}else {
				ps.println("Testo");
			}
			t.print(ps);
		}
		
	}
	
	public void salvaRisultati(String nomeFile, ArchivioMultimediale a) throws IOException {
		File f = new File(nomeFile);
		
		PrintStream ps = null;
		if(f.exists())
			ps = new PrintStream(f);
		else {
			f.createNewFile();
			ps = new PrintStream(f);	
		}
		a.print(ps);
	}
	
	public void remove(int n) {
		testi.remove(n);
	}
	

	
	private ArrayList<Testo> testi;
	
}
