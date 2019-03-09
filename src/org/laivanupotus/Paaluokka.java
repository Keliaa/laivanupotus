package org.laivanupotus;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Pelaaja;

public class Paaluokka {
	
	public static void main(String[] args) {
		//luodaan lauta
		Lauta lauta = new Lauta();
		//luodaan pelaaajat
		Pelaaja pelaaja = new Pelaaja("Testipelaaja");
		int[][] syote = pelaaja.otaSyote();
		lauta.asetaLaivaLaudalle(syote[0], syote[1]);
		lauta.tulostaLauta();
		
	}

}
