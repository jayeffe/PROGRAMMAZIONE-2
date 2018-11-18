/* 3� TIPO FILTRO: doppio for. Questo filtro viene utilizzato quando la variabile sulla quale bisogna filtrare non appartiene
	 * alla classe da filtrare e non rappresenta una variabile chiave. Di conseguenza, poich� non basta fare un for esteso sulla classe
	 * da filtrare, si dovr� effettuare un ulteriore for esteso (all'interno del primo) che per� avr�, come ArrayList di riferimento,
	 * quello della classe base del for esteso pi� esterno (ad esempio, il primo for esteso � su docenti, il secondo sar� sui corsi di 
	 * un particolare docente, quindi avr� come ArrayList quello ottenuto dal getCorsi()). All'interno si effettuer� la verifica della
	 * condizione con l'if e le aggiunte come negli altri filtri. Si proceder� poi con il return.
	 * */
	
	
/*

    public ArchivioUniversita filterDocentiByCrediti(int crediti){
		ArrayList<Docente> d = new ArrayList<Docente>();
		ArrayList<Corso> c = new ArrayList<Corso>();
		for(Docente docente : docenti){
			for(Corso corso : docente.getCorsi()){
				if(corso.getCrediti() == crediti){
					c.add(corso);
					d.add(docente);
				}
			}
		}
		return new ArchivioUniversita(d, c);
	}



*/