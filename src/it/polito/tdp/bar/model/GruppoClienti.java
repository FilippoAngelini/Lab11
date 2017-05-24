package it.polito.tdp.bar.model;

public class GruppoClienti {
	
	private int numClienti;
	private int durata;
	private float tolleranza;
	private int numPostiTavoloOccupato;
	
	public GruppoClienti(int numClienti, int durata, float tolleranza) {
		this.numClienti = numClienti;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.numPostiTavoloOccupato = 0;
	}

	public int getNumClienti() {
		return numClienti;
	}

	public void setNumClienti(int numClienti) {
		this.numClienti = numClienti;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public int getNumPostiTavoloOccupato() {
		return numPostiTavoloOccupato;
	}

	public void setNumPostiTavoloOccupato(int numPostiTavoloOccupato) {
		this.numPostiTavoloOccupato = numPostiTavoloOccupato;
	}
	

}
