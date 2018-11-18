package it.guidofonzo.hotmail.classi;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList; 
import java.util.Scanner;

import it.guidofonzo.hotmail.util.DestinatarioNotFound;

public class CorriereEspresso {
	
	private CorriereEspresso( ArrayList<Destinatario> destinazioni,ArrayList<Pacco> pacchi) {
		this.destinatari = destinazioni;
		this.pacchi = pacchi;
		
	}
	public CorriereEspresso(Scanner sDestinatari,Scanner sPacchi) {
		destinatari = new ArrayList<Destinatario>();
		pacchi = new ArrayList<Pacco>();
		
		Destinatario destinatario= Destinatario.read(sDestinatari);
		while(destinatario!=null) {
			destinatari.add(destinatario);
			
			destinatario=Destinatario.read(sDestinatari);
			
			
		}
		Pacco p = Pacco.read(sPacchi);
		while(p!=null) {
			
			try {
				pacchi.add(p);
				Destinatario d = cercaPaccoPerCfCliente(p.getCfDestinatario());
		        p.AddDestinazioni(d);
		        d.addPacco(p);
			
				
			}
			catch (DestinatarioNotFound e) {
				System.err.println("catturata eccezione ");
				
			}
			p=Pacco.read(sPacchi);
		}
		
	}
	
	
	
	
	private Destinatario cercaPaccoPerCfCliente(String codiceFiscale) {
		int i=0;
		boolean trovato = false;
		while(i<destinatari.size() && !trovato) {
			if(destinatari.get(i).getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
				trovato = true;
			}
			else {
				i++;
			}
			
		}
		if(trovato) return destinatari.get(i);
		throw new DestinatarioNotFound("non ho trovato il destinatario con il codice fiscale"+codiceFiscale);
	}


	public void print(PrintStream ps) {
		System.out.println("DESTINATARI ");
		for(Destinatario d : destinatari) {
			d.print(ps);
			System.out.println("\n");
		}
		System.out.println("\n PACCHI ");
		for(Pacco p : pacchi) {
			p.print(ps);
		}
		System.out.println("\n");

	}

	public void printDestinatari() {
		for(Destinatario d : destinatari) {
			d.print(System.out);
			}
	}

	public void printPacchi() {
		for(Pacco p : pacchi) { 
			p.print(System.out);
			System.out.println("\n");
		}
	} 
	
	public ArrayList<Destinatario> getDestinatari() {
		return destinatari;
	}
	public ArrayList<Pacco> getPacchi() {
		return pacchi;
	}


	
	// filtro per codice fiscale
	public CorriereEspresso filterByCf(String cf) {
		ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
		ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
		
		for(Destinatario d :destinatari) {
			if(d.getCodiceFiscale().equalsIgnoreCase(cf)) {
				filterDestinatari.add(d);
				for(Pacco p : d.getPacchi()) {
					filterPacchi.add(p);
				}
			}
		}
		return new CorriereEspresso(filterDestinatari, filterPacchi);
	}
	
	// filtro per nome
		public CorriereEspresso filterByNome(String nome) {
			ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
			ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
			
			for(Destinatario d :destinatari) {
				if(d.getNome().equalsIgnoreCase(nome)) {
					filterDestinatari.add(d);
					for(Pacco p : d.getPacchi()) {
						filterPacchi.add(p);
					}
				}
			}
			return new CorriereEspresso(filterDestinatari, filterPacchi);
		}
	
		// filtro per cognome
				public CorriereEspresso filterByCogNome(String cognome) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Destinatario d :destinatari) {
						if(d.getCognome().equalsIgnoreCase(cognome)) {
							filterDestinatari.add(d);
							for(Pacco p : d.getPacchi()) {
								filterPacchi.add(p); 
							}
						}
					}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
				}
				
				//filtro per citta
	
				public CorriereEspresso filterByCitta(String citta) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Destinatario d :destinatari) {
						if(d.getCittà().equalsIgnoreCase(citta)) {
							filterDestinatari.add(d);
							for(Pacco p : d.getPacchi()) {
								filterPacchi.add(p);
							}
						}
					}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
				}
				
				// filtro per via
				public CorriereEspresso filterByVia(String indirizzo) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Destinatario d :destinatari) {
						if(d.getIndirizzo().equalsIgnoreCase(indirizzo)) {
							filterDestinatari.add(d);
							for(Pacco p : d.getPacchi()) {
								filterPacchi.add(p);
							}
						}
					}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
				}
				// filtro per provincia
				public CorriereEspresso filterByProvincia(String provincia) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Destinatario d :destinatari) {
						if(d.getProvincia().equalsIgnoreCase(provincia)) {
							filterDestinatari.add(d);
							for(Pacco p : d.getPacchi()) {
								filterPacchi.add(p);
							}
						}
					}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
				}
				
				// filtro per cap
				public CorriereEspresso filterByCap(int cap) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Destinatario d :destinatari) {
						if(d.getCap()==cap) {
							filterDestinatari.add(d);
							for(Pacco p : d.getPacchi()) {
								filterPacchi.add(p);
							}
						}
					}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
				}
				
				// filtro per Codice
				public CorriereEspresso filterByCodicePacco(String codice) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Pacco p :pacchi) {
						if(p.getCodicePacco().equalsIgnoreCase(codice)) {
							filterPacchi.add(p);
							filterDestinatari.add(p.getDestinazioni());
								
							}
						}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
					}
				
				
				// filtro per Peso
				public CorriereEspresso filterByPeso(int peso) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Pacco p :pacchi) {
						if(p.getPeso()>=peso) {
							filterPacchi.add(p);
							filterDestinatari.add(p.getDestinazioni());
								
							}
						}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
					}
				
				
				// filtro per Peso <
				public CorriereEspresso filterByPesom(int pesom) {
					ArrayList<Destinatario> filterDestinatari = new ArrayList<Destinatario>();
					ArrayList<Pacco> filterPacchi = new ArrayList<Pacco>();
					
					for(Pacco p :pacchi) {
						if(p.getPeso()<=pesom) {
							filterPacchi.add(p);
							filterDestinatari.add(p.getDestinazioni());
								
							}
						}
					return new CorriereEspresso(filterDestinatari, filterPacchi);
					}
				
public void StampaSuFile(String nomeFile, CorriereEspresso c) {
	File file = new File(nomeFile);
	PrintStream ps = null;
	try {
		if(file.exists()) {
			ps=new PrintStream(file); 
			c.print(ps);
		}
		else {
		file.createNewFile();
		ps=new PrintStream(file);
		}
	}	
		catch(IOException e) {
			e.printStackTrace();
		}
	
} 

public void add(Scanner in , Scanner in2) {
	CorriereEspresso c = new CorriereEspresso(in, in2);
	
	for(Destinatario d : c.getDestinatari()) {
		this.destinatari.add(d);
		
	}
	for(Pacco p: c.getPacchi() ) {
		this.pacchi.add(p);
	}
	
}

public void addFromTastiera() {
	System.out.println("inserisci il tipo di file ");
	Scanner sc = new Scanner(System.in);
	String etichetta =sc.nextLine();
	Destinatario d =null;
	Pacco p =null;
	

	switch (etichetta) {
	case "Destinatari":
		d=Destinatario.read(sc);
		break;

	case "Pacchi":
		p=Pacco.read(sc);
		break;
	}
	if(d!=null) {
		destinatari.add(d);
	}
	else if(p!=null) {
	 pacchi.add(p);
	}
}

public void bubbleSort() {
	int i=0;
	boolean ordinato=false;
	while(i<destinatari.size()&&!ordinato) {
		ordinato=true;
		for(int j=0;j< destinatari.size() - i - 1;j++) {
			if(destinatari.get(j).CompareTo(destinatari.get(j+1))>0) {
				Destinatario destTemp = destinatari.get(j);
				destinatari.set(j, destinatari.get(j+1));
				destinatari.set(j+1, destTemp);
				
			}
		}
		i++;
	}
}
public String toString() {
		String string ="DESTINATARI ";
		for(Destinatario d : destinatari) {
			string+=d.toString()+"\n ";
		}
		for(Pacco p:pacchi) {
			string+=p.toString()+"\n ";
		}
		return string;
	}


	private ArrayList<Destinatario> destinatari;
	private ArrayList<Pacco> pacchi;

}
