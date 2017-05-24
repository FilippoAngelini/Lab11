package it.polito.tdp.bar.model;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {
	
	private Map <Integer,Integer> tavoli; //chiave=num posti al tavolo (tipo di tavolo), valore=num di tavoli di quel tipo liberi
	
	//Misure di interesse
	private int numeroTotaleClienti;
	private int numeroClientiSoddisfatti;
	private int numeroClientiInsoddisfatti;
	
	// coda degli eventi
	private PriorityQueue<Event> queue;
	
	public Simulator(){
		this.queue = new PriorityQueue<>();
		tavoli = new TreeMap<Integer,Integer>();
		tavoli.put(10, 2); //Numero di tavoli con 10 posti = 2
		tavoli.put(8, 4);
		tavoli.put(6, 4);
		tavoli.put(4, 5);
		numeroTotaleClienti = 0;
		numeroClientiSoddisfatti = 0;
		numeroClientiInsoddisfatti = 0;
	}
	
	public void addGruppoClienti(GruppoClienti clienti, int time) {
		Event e = new Event(time, EventType.ARRIVO_GRUPPO_CLIENTI, clienti) ;
		queue.add(e) ;
	}
	
	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();

			switch (e.getType()) {
			case ARRIVO_GRUPPO_CLIENTI:
				processNuovoGruppoClienti(e);
				break;
			case FREE_TAVOLO:
				processFreeTavolo(e);
				break;
			default:
				break;
			}
		}
	}

	private void processNuovoGruppoClienti(Event e) {
		
		GruppoClienti clienti = e.getClienti();
		int numClienti = clienti.getNumClienti();
		float tolleranza = clienti.getTolleranza();
		
		this.numeroTotaleClienti += numClienti;
		
		for(Integer tableType : tavoli.keySet()){
			if(numClienti<=tableType && tavoli.get(tableType)>0 && numClienti >= (tableType/2)){
				tavoli.put(tableType,tavoli.get(tableType)-1);
				this.numeroClientiSoddisfatti+=numClienti;
				clienti.setNumPostiTavoloOccupato(tableType);
				Event ne = new Event (e.getTime() + clienti.getDurata(), EventType.FREE_TAVOLO, clienti);
				queue.add(ne);
				return;
			}
		}
		
		
		double random = Math.random();
		
		if(random <= tolleranza) //clienti vanno al bancone
			this.numeroClientiSoddisfatti+=numClienti;
		else //i clienti lasciano il bar senza essere serviti
			this.numeroClientiInsoddisfatti+=numClienti;
	}
	
	private void processFreeTavolo(Event e) {
		
		GruppoClienti clienti = e.getClienti();
		int tableType = clienti.getNumPostiTavoloOccupato();
		
		tavoli.put(tableType,tavoli.get(tableType)+1);
	}

	public int getNumeroTotaleClienti() {
		return numeroTotaleClienti;
	}

	public int getNumeroClientiSoddisfatti() {
		return numeroClientiSoddisfatti;
	}

	public int getNumeroClientiInsoddisfatti() {
		return numeroClientiInsoddisfatti;
	}
	
}
