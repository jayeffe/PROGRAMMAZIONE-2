package it.guidofonzo.hotmail.classi;


import java.util.Scanner;

public class Mobile {

	public Mobile(String mobile, String tipo, int quantità, double prezzo) {
		this.mobile = mobile;
		this.tipo = tipo;
		this.quantità = quantità;
		this.prezzo = prezzo;
	}
	
	public static Mobile read(Scanner s){
		if(!s.hasNextLine()) return null;
		String mobile=s.nextLine();
		
		if(mobile.equals("#")) return null;
		
		if(!s.hasNextLine()) return null;
		String tipo=s.nextLine();
		
		if(!s.hasNextInt()) return null;
		
		int quantità=Integer.parseInt(s.nextLine());
		
		if(!s.hasNextLine()) return null;
		
		double prezzo=Double.parseDouble(s.nextLine());
		return new Mobile(mobile, tipo, quantità, prezzo);
	}
	
	public void print() {
		System.out.println(" ");
		System.out.println("Mobile: "+mobile);
		System.out.println("Tipo: "+tipo);
		System.out.println("Quantità: "+quantità);
		System.out.println("Prezzo: "+prezzo);
	}
	
	
	public String getMobile() {
		return mobile;
	}
	public String getTipo() {
		return tipo;
	}
	public int getQuantità() {
		return quantità;
	}
	public double getPrezzo() {
		return prezzo;
	}
	private String mobile;
	private String tipo;
	private int quantità;
	private double prezzo;

}
