package org.laivanupotus;

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
			lauta.asetaLaivaLaudalle(syote[0], syote[1]);
		}
		
		
		lauta.tulostaLauta();
		
	}

}
