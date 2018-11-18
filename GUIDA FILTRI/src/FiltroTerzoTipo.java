/* 3° TIPO FILTRO: doppio for. Questo filtro viene utilizzato quando la variabile sulla quale bisogna filtrare non appartiene
	 * alla classe da filtrare e non rappresenta una variabile chiave. Di conseguenza, poiché non basta fare un for esteso sulla classe
	 * da filtrare, si dovrà effettuare un ulteriore for esteso (all'interno del primo) che però avrà, come ArrayList di riferimento,
	 * quello della classe base del for esteso più esterno (ad esempio, il primo for esteso è su docenti, il secondo sarà sui corsi di 
	 * un particolare docente, quindi avrà come ArrayList quello ottenuto dal getCorsi()). All'interno si effettuerà la verifica della
	 * condizione con l'if e le aggiunte come negli altri filtri. Si procederà poi con il return.
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