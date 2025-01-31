package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
		tekstgr = new Tekstgrensesnitt();
	}
	public void start() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		Film b = new Film(2, "Peter Jackson", "Lord of the Rings: The Two Towers", 2002, "Fantasy", "New Line Cinema");
		Film c = new Film(3, "Peter Jackson", "Lord of the Rings: The Return of the King", 2003, "Fantasy", "New Line Cinema");
		Film d = new Film(4, "Martin Scorsese", "Killers of the Flower Moon", 2023, "History", "Paramount Pictures");
		Film e = new Film(5, "Andrei Tarkovsky", "Andrei Rublev", 1966, "History", "Mosfilm");
		filmarkiv.leggTilFilm(a);
		filmarkiv.leggTilFilm(b);
		filmarkiv.leggTilFilm(c);
		filmarkiv.leggTilFilm(d);
		filmarkiv.leggTilFilm(e);
	}
}
