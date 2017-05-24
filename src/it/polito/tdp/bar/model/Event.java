package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	public enum EventType { 
		ARRIVO_GRUPPO_CLIENTI, // arriva un nuobo gruppo di clienti
		FREE_TAVOLO // un gruppo di clienti esce e libera un tavolo (da schedulare solo se i clienti erano al tavolo e non al bancone)
		} ;
		
	private int time;
	private EventType type;
	private GruppoClienti clienti;

	public Event(int time, EventType type, GruppoClienti clienti) {
		this.time = time;
		this.type = type;
		this.clienti = clienti;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + "]";
	}

	public GruppoClienti getClienti() {
		return clienti;
	}

	public void setClienti(GruppoClienti clienti) {
		this.clienti = clienti;
	}

	@Override
	public int compareTo(Event other) {
		// TODO Auto-generated method stub
		return this.time - other.time;
	}

}
