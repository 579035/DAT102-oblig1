package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2 (LinearNode<Film> start) {
		this.start = start;
		antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		return rekursjon(nr, start).data;
	}
	public LinearNode<Film> rekursjon(int nr, LinearNode<Film> node) {
		if (node.data.getFilmnr() == nr) {
			return node;
		} else if (node.neste != null) {
			rekursjon(nr, node.neste);
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == 0) {
			start.data = nyFilm;
			antall+=1;
		}else {
			LinearNode<Film> ny = new LinearNode<>();
			ny.data = nyFilm;
			start = ny;
			antall+=1;
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> temp = start;
		LinearNode<Film> forrige = null;
		if (temp != null && temp.data.getFilmnr() == filmnr) { 
            start = temp.neste;
            antall--;
            return true; 
        }
		while (temp != null && temp.data.getFilmnr() != filmnr) { 
            forrige = temp; 
            temp = temp.neste; 
        }
		if (temp == null) {
			return false;
		}
		forrige.neste = temp.neste;
		antall--;
		return true;
		
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tittelMatch = new Film[antall];
		int resultater = 0;
		LinearNode<Film> temp = start;
		for (int i = 0; i<=antall-1;i++) {
			if (temp.data.getTittel().contains(delstreng)) {
				tittelMatch[resultater] = temp.data;
				resultater++;
			}
			temp = temp.neste;
		}
		return tittelMatch;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsentMatch = new Film[antall];
		int resultater = 0;
		LinearNode<Film> temp = start;
		for (int i = 0; i<=antall-1;i++) {
			if (temp.data.getTittel().contains(delstreng)) {
				produsentMatch[resultater] = temp.data;
				resultater++;
			}
			temp = temp.neste;
		}
		return produsentMatch;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> temp = start;
		int resultater = 0;
		for (int i = 0; i <= antall-1; i++){
			if (temp.data.getSjanger() == sjanger) {
				resultater++;
			}
			temp = temp.neste;
		}
		return resultater;
	}

	@Override
	public int antall() {
		return antall;
	}

}
