/* 2° TIPO DI FILTRO: semplificato. Questo filtro viene utilizzato quando la variabile sulla quale bisogna filtrare non appartiene
	 * alla classe da filtrare, ma essa rappresenta la variabile chiave dell'altra classe. Ad esempio, ponendo che un docente possa
	 * insegnare in più corsi (quindi nella classe base Docente avremo un ArrayList di corsi e in corso solo un Docente), se ci viene
	 * richiesto il filtro di tutti i corsi di un determinato docente dato il codice fiscale del docente, allora esso è un filtro di
	 * 2° tipo. In esso non viene utilizzato alcun for, in quanto abbiamo già l'ArrayList di corsi sostenuti da quel docente
	 * memorizzato all'interno della classe base. Quindi, dopo gli ArrayList temporanei, verrà semplicemente dichiarata una variabile
	 * docente il cui contenuto sarà dato da un searchDocenteByCodiceFiscale, che avrà come parametro il parametro del filtro. Memorizzato
	 * questo docente, esso verrà aggiunto all'ArrayList temporaneo di docenti attraverso un add, così come tutti i corsi di quel docente
	 * (richiamati attraverso il metodo creato durante il collegamento "getCorsi()") saranno aggiunti all'ArrayList temporaneo dei corsi,
	 * attraverso, però, un metodo addAll (poiché il metodo getCorsi restituisce un ArrayList).
	 * Poi si procederà con il return.
	 */
	
	/* ESEMPIO 2° TIPO FILTRO */
	
	

   /*
    public ArchivioUniversita filterCorsiByCodiceFiscale(String codiceFiscale){
		ArrayList<Docente> d = new ArrayList<Docente>();
		ArrayList<Corso> c = new ArrayList<Corso>();
		Docente docente = searchDocenteByCodiceFiscale(codiceFiscale);
		d.add(docente);
		c.addAll(d.getCorsi());
		return new ArchivioUniversita(d, c);
	}
	
	*/