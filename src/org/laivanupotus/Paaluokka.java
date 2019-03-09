package org.laivanupotus;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;

public class Paaluokka {
	
	//testi :D
	
	public static void main(String[] args) {
		//luodaan lauta
		Lauta lauta = new Lauta();
		
		//luodaan teko�lyn lauta. t�t� ei sitten printata, muuten voi menn� pelaaminen liian helpoksi.
		Lauta tekoLauta = new Lauta();
		
		//luodaan pelaaajat
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		
		//asetetaan laivat - pelaaja
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij�", "Risteilij�", "H�vitt�j�", "H�vitt�j�", "H�vitt�j�", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = ihmispelaaja.otaSyote(laivaPituudet[i], laivanNimet[i]);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1]);
			lauta.asetaLaivaLaudalle(laiva);
		}
		//asetetaan laivat - teko�ly
		tekoaly.arvoLaivat(tekoLauta);
		
		//tulostetaan VAIN pelaajan lauta
		lauta.tulostaLauta();
		
	}

}
