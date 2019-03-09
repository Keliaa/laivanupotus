package org.laivanupotus;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Pelaaja;

public class Paaluokka {
	
	//testi :D
	
	public static void main(String[] args) {
		//luodaan lauta
		Lauta lauta = new Lauta();
		//luodaan pelaaajat
		Pelaaja pelaaja = new Pelaaja("Testipelaaja");
		
		//asetetaan laivat
		int[] laivapituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		for (int a : laivapituudet) {
			int[][] syote = pelaaja.otaSyote(a);
			Laiva laiva = new Laiva("Lentotukialus", 4, syote[0], syote[1]);
			lauta.asetaLaivaLaudalle(laiva);
		}
		lauta.tulostaLauta();
		
	}

}
