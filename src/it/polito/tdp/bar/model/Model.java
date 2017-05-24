package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.bar.model.Event.EventType;

public class Model {
	
	Simulator sim;

	public String doSimula() {

		Simulator sim = new Simulator();
		
		int time = 0;

		
		for(int i = 0 ; i < 2000 ; i++){
			
			time += (int)(1+Math.random()*10);
			
			int numClienti = (int)(1+Math.random()*10);
			
			float tolleranza = (float)(Math.random()*0.9);
			
			int durata = (60 + (int)((Math.random()*61)));//System.out.println(durata);
			
			GruppoClienti clienti = new GruppoClienti(numClienti, durata,tolleranza);
			
			sim.addGruppoClienti(clienti, time);
		}
		Map<Integer,Integer>tavoli = new TreeMap<Integer,Integer>();
		tavoli.put(10, 2); //Numero di tavoli con 10 posti = 2
		tavoli.put(8, 4);
		tavoli.put(6, 4);
		tavoli.put(4, 5);
		for(Integer tp : tavoli.keySet())
			System.out.println(tp);
		sim.run();
		
		String ris = "Numero clienti totale: " + sim.getNumeroTotaleClienti() + "\nNumero clienti soddisfatti: " + sim.getNumeroClientiSoddisfatti() + "\nNumeroClientiInsoddisfatti: " + sim.getNumeroClientiInsoddisfatti() + "\n\n";
		
		return ris;
		
	}
	
	

}
