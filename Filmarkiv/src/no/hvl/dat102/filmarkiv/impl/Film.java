package no.hvl.dat102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int årstall;
	private Sjanger sjanger;
	private String filmselskap;

	public Film () {
		
	}
	public Film(int filmnr, String produsent, String tittel, int årstall,String sjanger, String filmselskap) {
		super();
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.årstall = årstall;
		this.filmselskap = filmselskap;
		this.sjanger = Sjanger.finnSjanger(sjanger);
	}
	public int getFilmnr() {
		return filmnr;
	}
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	public String getProdusent() {
		return produsent;
	}
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getÅrstall() {
		return årstall;
	}
	public void setÅrstall(int årstall) {
		this.årstall = årstall;
	}
	public String getFilmselskap() {
		return filmselskap;
	}
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr;
	}
	
	
}