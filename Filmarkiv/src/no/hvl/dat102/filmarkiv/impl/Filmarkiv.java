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
	
	private void utvidTabell() {
		Film[] nyttArkiv = new Film[arkiv.length*2];
		System.arraycopy(arkiv, 0, nyttArkiv, 0, arkiv.length);
		arkiv = nyttArkiv;
		}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i<antall;i++) {
			if (arkiv[i].getFilmnr() == filmnr) {
				arkiv[i] = arkiv[antall-1];
				arkiv[antall-1] = null;
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
		trimTab(tittelMatch);
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
		trimTab(produsentMatch);
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
	
	private int tabellStørrelse(Film[] tab) {
		int størrelse = 0;
		for (int i = 0; i < tab.length ; i++) {
			if (tab[i] != null) {
				størrelse++;
			}
		}
		return størrelse;
	}
	private Film[] trimTab(Film[] tab) {
		int n = tabellStørrelse(tab);
		Film[] nyTab = new Film[n];
		int i = 0;
		while (i < n) {
			nyTab[i] = tab[i];
			i++;
		}
		return nyTab;
	}

}
