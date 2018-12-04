package it.guidofonzo.hotmail.classi;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import it.guidofonzo.hotmail.util.Costanti;

public class Preventivo {

private Preventivo(String iD, Date data, String cfCliente, int sconto, ArrayList<Mobile> mobili) {
	
		this.ID = iD;
		this.data = data;
		this.cfCliente = cfCliente;
		this.sconto = sconto;
		this.mobili = mobili;
	}




public void addCliente(Cliente cliente) {
	this.cliente = cliente;
}




public static Preventivo read(Scanner s){
	if(!s.hasNextLine()) return null;
	String ID=s.nextLine();
	if(!s.hasNextLine()) return null;
	String d=s.nextLine();
	SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);
	Date data;
	try {
		data=sdf.parse(d);
	}
	catch(ParseException e) {
		System.err.println("Errore conversione data.");
		data=new Date();
	}
	if(!s.hasNextLine()) return null;
	String cfcliente=s.nextLine();
	if(!s.hasNextLine()) return null;
	int sconto=Integer.parseInt(s.nextLine());
	Mobile mobile=Mobile.read(s);
	ArrayList<Mobile> mobili=new ArrayList<Mobile>();
	while(mobile!=null) {
		mobili.add(mobile);
		mobile=Mobile.read(s);
	}
	return new Preventivo(ID, data, cfcliente, sconto, mobili);
}



public String getID() {
	return ID;
}




public Date getData() {
	return data;
}




public String getCfCliente() {
	return cfCliente;
}




public int getSconto() {
	return sconto;
}




public ArrayList<Mobile> getMobili() {
	return mobili;
}




public Cliente getCliente() {
	return cliente;
}




public void print() {
	SimpleDateFormat sdf=new SimpleDateFormat(Costanti.DATEFORMAT);
	System.out.println("ID: "+ID);
	System.out.println("Data: "+sdf.format(data));
	System.out.println("cfCliente: "+cfCliente);
	System.out.println("Sconto: "+sconto+"%");
	for(Mobile m: mobili) {
		m.print();
	}
}

// TOTALE
public double prezzoTotale() {
	double tot=0;
	for(Mobile m: mobili) tot+=m.getPrezzo()*m.getQuantità();
	return tot;
}

public double calcolaSconto() {
	return prezzoTotale()*(1-(double)sconto/100);
}
 



private String ID;
private Date data;
private String cfCliente;
private int sconto;
private ArrayList<Mobile> mobili;
private Cliente cliente;

}
