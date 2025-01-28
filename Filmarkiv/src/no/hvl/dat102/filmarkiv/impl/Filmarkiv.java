package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class Filmarkiv implements FilmarkivADT {
	private Film[] arkiv;
	private int antall;
	
	
	public Filmarkiv( int kapasitet) {
		super();
		this.arkiv = new Film[kapasitet];
		this.antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i<antall;i++) {
			if (arkiv[i].getFilmnr() == nr) {
				return arkiv[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == arkiv.length) {
			utvidTabell();
		}
		arkiv[antall] = nyFilm;
		antall++;
	}
	
	public void utvidTabell() {
		Film[] nyttArkiv = new Film[arkiv.length*2];
		System.arraycopy(arkiv, 0, nyttArkiv, 0, arkiv.length);
		arkiv = nyttArkiv;
		}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i<antall;i++) {
			if (arkiv[i].getFilmnr() == filmnr) {
				arkiv[i] = arkiv[antall];
				arkiv[antall] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tittelMatch = new Film[arkiv.length];
		int resultater = 0;
		for (int i = 0; i<antall;i++) {
			if (arkiv[i].getTittel().contains(delstreng)) {
				tittelMatch[resultater] = arkiv[i];
				resultater++;
			}
		}
		return tittelMatch;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsentMatch = new Film[arkiv.length];
		int resultater = 0;
		for (int i = 0; i<antall;i++) {
			if (arkiv[i].getProdusent().contains(delstreng)) {
				produsentMatch[resultater] = arkiv[i];
				resultater++;
			}
		}
		return produsentMatch;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int resultater = 0;
		for (int i = 0; i<antall;i++) {
			if (sjanger == arkiv[i].getSjanger()) {
				resultater++;
			}
		}
		return resultater;
	}

	@Override
	public int antall() {
		return antall;
	}
	

}
