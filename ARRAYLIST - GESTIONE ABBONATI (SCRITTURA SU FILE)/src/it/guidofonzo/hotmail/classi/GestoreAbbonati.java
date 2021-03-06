package it.guidofonzo.hotmail.classi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestoreAbbonati {
	
private GestoreAbbonati(ArrayList<Tifoso> tifosi) {
		this.tifosi = tifosi;
	}

public GestoreAbbonati(Scanner sTifosi ) {
	tifosi=new ArrayList<Tifoso>();
	Tifoso t =Tifoso.read(sTifosi);
	while(t!=null) {
		tifosi.add(t);
		t=Tifoso.read(sTifosi);
	}
		
}
public void printTifosi(PrintStream ps) {
	ps.println("************************************");
	ps.println("TOTALE TIFOSI = "+tifosi.size());
	ps.println("************************************");

	for(Tifoso ti:tifosi) {
		ti.print(ps);
		ps.println(" ");
		
	} 
}

public void print(PrintStream ps) {
	for(Tifoso ti:tifosi) {
		ti.print(ps);	
	} 
}


public void removeFile(File f) {
	f.delete();
}


public GestoreAbbonati filterByNome(String nome) {
	ArrayList<Tifoso>filterTifoso=new ArrayList<Tifoso>();
	for(Tifoso t :tifosi) {
		if(t.getNome().equalsIgnoreCase(nome)) {
			filterTifoso.add(t);
			
		}
		
	}
	return new GestoreAbbonati(filterTifoso);
}


public GestoreAbbonati filterBycognome(String cognome) {
	ArrayList<Tifoso>filterTifoso=new ArrayList<Tifoso>();
	for(Tifoso t :tifosi) {
		if(t.getCognome().equalsIgnoreCase(cognome)) {
			filterTifoso.add(t);
			
		}
		
	}
	return new GestoreAbbonati(filterTifoso);
}



public GestoreAbbonati filterBySesso(String sesso) {
	ArrayList<Tifoso>filterTifoso=new ArrayList<Tifoso>();
	for(Tifoso t :tifosi) {
		if(t.getSesso().equalsIgnoreCase(sesso)) {
			filterTifoso.add(t);
			
		}
		
	}
	return new GestoreAbbonati(filterTifoso);
}


public GestoreAbbonati filterByLuogoResidenza(String residenza) {
	ArrayList<Tifoso>filterTifoso=new ArrayList<Tifoso>();
	for(Tifoso t :tifosi) {
		if(t.getLuogoResidenza().equalsIgnoreCase(residenza)) {
			filterTifoso.add(t);
			
		}
		
	}
	return new GestoreAbbonati(filterTifoso);
}

public void printOnFile(String nomeFile, GestoreAbbonati g) {
	File file = new File(nomeFile);
	PrintStream ps = null;
	try {
	if(file.exists()) {
	 ps=new PrintStream(new FileOutputStream(file,true));
	 g.printTifosi(ps);
	 
	 
	}
	else {
		
		file.createNewFile();
		
	}
		
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
}
public void add(Scanner in) {
	GestoreAbbonati ge = new GestoreAbbonati(in);
	
	for(Tifoso t : ge.getTifosi()) {
		this.tifosi.add(t);
	}
}

public void addFromTastiera() {
	System.out.println("inserire gli elementi: ");
	Scanner sc = new Scanner(System.in);
    Tifoso t =null;
    t=Tifoso.read(sc);
    if(t!=null) {
    	this.tifosi.add(t);
    }
}
  
	public ArrayList<Tifoso> getTifosi() {
		return tifosi;
	}
	
	public String toString() {
		String string ="ELENCO TIFOSI";
		for(Tifoso t:tifosi) {
			string+=t.toString()+"\n \n";
		}
		return string;
	}

	private ArrayList<Tifoso> tifosi;
}
