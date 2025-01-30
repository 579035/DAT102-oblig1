package no.hvl.dat102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	Scanner input = new Scanner(System.in);
	public Film lesFilm() {
		//TODO
		return null;
	}
	public void skrivUtFilm (Film film) {
		System.out.println(film.toString());
	}
	public void skrivUtFilmDelstrengTittel(FilmarkivADT arkiv, String delstreng) {
		Film[] tab = arkiv.soekTittel(delstreng);
		for (int i = 0; i<tab.length;i++) {
			System.out.println(tab[i]);
		}
	}
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] tab = arkiv.soekProdusent(delstreng);
		for (int i = 0; i<tab.length;i++) {
			System.out.println(tab[i]);
		}
	}
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer: "+arkiv.antall());
		System.out.println("Antall filmer etter sjanger: ");
		System.out.println("Action: "+arkiv.antall(Sjanger.ACTION));
		System.out.println("Comedy: "+arkiv.antall(Sjanger.COMEDY));
		System.out.println("Documentary: "+arkiv.antall(Sjanger.DOCUMENTARY));
		System.out.println("Drama: "+arkiv.antall(Sjanger.DRAMA));
		System.out.println("Fantasy: "+arkiv.antall(Sjanger.FANTASY));
		System.out.println("History: "+arkiv.antall(Sjanger.HISTORY));
		System.out.println("Horror: "+arkiv.antall(Sjanger.HORROR));
		System.out.println("Sci-Fi: "+arkiv.antall(Sjanger.SCIFI));
	}
}
