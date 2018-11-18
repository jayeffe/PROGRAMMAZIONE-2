
	
	
	/* 1° TIPO DI FILTRO: singolo for. Questo tipo di filtro viene utilizzato quando la caratteristica secondo
	 * la quale bisogna filtrare appartiene alla stessa classe da filtrare. Ad esempio, se voglio filtrare
	 * dei Corsi in base in base ad una variabile contenuta all'interno della classe Corso, ad esempio la variabile
	 * di tipo intero "crediti", allora utilizza questo filtro con un unico for. La sua struttura, si basa sulla creazione
	 * degli ArrayList temporanei per tutte le classi base (ad esclusione della classe di collegamento, se ci troviamo
	 * nel caso di esercizio con classe di collegamento, e delle sottoclassi, se ci troviamo in un esercizio con ereditarietà).
	 * Tale procedura va fatta per ogni filtro, di qualsiasi tipo esso sia. Fatti gli ArrayList temporanei, utilizziamo un for
	 * esteso basato sulla classe da filtrare. Ad esempio, se la richiesta di filtro è "trovare tutti i corsi con 
	 * più di n crediti", allora il for esteso andrà fatto sui corsi (da notare che "crediti" è una variabile di Corso,
	 * perciò filtro di 1° tipo). All'interno del for esteso, andrà effettuata la verifica, attraverso un if, della particolare
	 * condizione richiesta dal filtro. Per l'esempio di richiesta precedente, all'interno della condizione dell'if, andrà
	 * preso il numero di crediti dal singolo corso con un metodo get, e dovrà esser confrontato (essendo intero, con operatori
	 * del tipo <, >, ==, !=. Se fosse stata una String, allora si utilizza equals e equalsIgnoreCase) con la variabile parametro
	 * passata al metodo del filtro (ovvero la caratteristica sulla quale bisogna effettuare il filtro). All'interno del if (ovvero,
	 * cosa viene eseguito se si verifica la condizione richiesta, ad esempio che i crediti di quel determinato corso sono maggiori
	 * di n) avviene l'aggiunta del corso all'ArrayList temporaneo di corsi e l'aggiunta di uno o di più docenti che insegnano
	 * in quel corso all'interno dell'ArrayList temporaneo dei docenti (docente/docenti a seconda che il problema definisca che in
	 * corso possa insegnare un solo docente o meno). Quando bisogna aggiungere un singolo oggetto all'ArrayList si usa il metodo "add",
	 * quando si deve aggiungere un intero insieme di oggetti all'ArrayList (ad esempio nel caso in cui ad un corso siano assegnati più docenti e,
	 * di conseguenza, dovranno esser aggiunti tutti insieme all'ArrayList se quel corso rispetta la condizione del filtro), si
	 * usa il metodo "addAll" con, nei parametri del metodo, un intero ArrayList. Effettuata l'aggiunta, al di fuori del for, si 
	 * definisce il ritorno con le parole chiave "return new *NomeClasseGestore* (*ArrayList temporanei separati da una virgola*);".
	 * Ricordiamo che il tipo di ritorno del filtro deve essere sempre la classe gestore. La prima volta che verrà creato un filtro,
	 * apparirà un errore sulla riga "return new ...", poiché manca il costruttore con i filtri come parametri. Cliccando sull'errore,
	 * si creerà automaticamente. Al suo interno bisognerà inzializzare gli ArrayList con quelli temporanei.
	 */
	
	/* ESEMPIO 1° TIPO */
	

	

   /*


    public ArchivioUniversita filterCorsiByCreditiMin(int creditiMin){
		ArrayList<Docente> d = new ArrayList<Docente>();
		ArrayList<Corso> c = new ArrayList<Corso>();
		for(Corso corso : corsi){
			if(corso.getCrediti() > creditiMin){
				c.add(corso);
				d.add(corso.getDocente());
			}
		}
		return new ArchivioUniversita(d, c);
	}
	
	
	*/


