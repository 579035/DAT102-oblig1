package no.hvl.dat102.filmarkiv.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
	
	Filmarkiv testArkiv;
	
	@BeforeEach
	public void oppsett(){
		testArkiv = new Filmarkiv(5);
	}

	@Test
	void testLeggTil() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		testArkiv.leggTilFilm(a);
		assertEquals(1, testArkiv.antall());
	}
	@Test
	void testFinnFilm(){
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		testArkiv.leggTilFilm(a);
		assertEquals(a, testArkiv.finnFilm(1));
	}
	@Test
	void testSlettFilm() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		testArkiv.leggTilFilm(a);
		assertTrue(testArkiv.slettFilm(1));
		assertEquals(0, testArkiv.antall());
	}
	@Test
	void testSoekTittel() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		Film b = new Film(2, "Peter Jackson", "Lord of the Rings: The Two Towers", 2002, "Fantasy", "New Line Cinema");
		Film c = new Film(3, "Peter Jackson", "Lord of the Rings: The Return of the King", 2003, "Fantasy", "New Line Cinema");
		Film d = new Film(4, "Martin Scorsese", "Killers of the Flower Moon", 2023, "History", "Paramount Pictures");
		Film e = new Film(5, "Andrei Tarkovsky", "Andrei Rublev", 1966, "History", "Mosfilm");
		testArkiv.leggTilFilm(a);
		testArkiv.leggTilFilm(b);
		testArkiv.leggTilFilm(c);
		testArkiv.leggTilFilm(d);
		testArkiv.leggTilFilm(e);
		Film[] LOTR = new Film[3];
		LOTR[0]= a;
		LOTR[1]= b;
		LOTR[2]= c;
		assertEquals(LOTR[0].getFilmnr(), testArkiv.soekTittel("Lord")[0].getFilmnr());
		assertEquals(LOTR[1].getFilmnr(), testArkiv.soekTittel("Lord")[1].getFilmnr());
		assertEquals(LOTR[2].getFilmnr(), testArkiv.soekTittel("Lord")[2].getFilmnr());
	}
	@Test
	void testAntallSjanger() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		Film b = new Film(2, "Peter Jackson", "Lord of the Rings: The Two Towers", 2002, "Fantasy", "New Line Cinema");
		Film c = new Film(3, "Peter Jackson", "Lord of the Rings: The Return of the King", 2003, "Fantasy", "New Line Cinema");
		Film d = new Film(4, "Martin Scorsese", "Killers of the Flower Moon", 2023, "History", "Paramount Pictures");
		Film e = new Film(5, "Andrei Tarkovsky", "Andrei Rublev", 1966, "History", "Mosfilm");
		testArkiv.leggTilFilm(a);
		testArkiv.leggTilFilm(b);
		testArkiv.leggTilFilm(c);
		testArkiv.leggTilFilm(d);
		testArkiv.leggTilFilm(e);
		assertEquals(3, testArkiv.antall(Sjanger.FANTASY));
		assertEquals(2, testArkiv.antall(Sjanger.HISTORY));
	}
	@Test
	void testAntall() {
		Film a = new Film(1, "Peter Jackson", "Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "New Line Cinema");
		Film b = new Film(2, "Peter Jackson", "Lord of the Rings: The Two Towers", 2002, "Fantasy", "New Line Cinema");
		Film c = new Film(3, "Peter Jackson", "Lord of the Rings: The Return of the King", 2003, "Fantasy", "New Line Cinema");
		Film d = new Film(4, "Martin Scorsese", "Killers of the Flower Moon", 2023, "History", "Paramount Pictures");
		Film e = new Film(5, "Andrei Tarkovsky", "Andrei Rublev", 1966, "History", "Mosfilm");
		testArkiv.leggTilFilm(a);
		testArkiv.leggTilFilm(b);
		testArkiv.leggTilFilm(c);
		testArkiv.leggTilFilm(d);
		testArkiv.leggTilFilm(e);
		assertEquals(5, testArkiv.antall());
	}
}
