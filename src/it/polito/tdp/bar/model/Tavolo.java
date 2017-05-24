package it.polito.tdp.bar.model;

public class Tavolo {
	
	private int numPosti;
	private boolean occupato;

	public Tavolo(int numPosti) {
		this.numPosti = numPosti;
		occupato = false;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

}
