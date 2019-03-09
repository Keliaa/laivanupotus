package org.laivanupotus.pelaaja.tekoaly;

import java.util.Random;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Pelaaja;

public class Tekoaly extends Pelaaja {

	public Tekoaly(String nimi) {
		super(nimi);
	}
	
	//tänne sitä tekoälyn toiminnallisuutta
	

	//arpoo laivat
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			//Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1]);
			//lauta.asetaLaivaLaudalle(laiva);
		}
	}
	
	//arpoo laivojen sijainnit
	/*public int[] arvoSijainnit(int laivanPituus) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		
		int temp = (Math.random() <= 0.5) ? 1 : 2;
		boolean plusVaiMiinus;
		if(temp == 1)
			plusVaiMiinus = true;
		
		
		return new int[] {n, n2};
	}*/

}
