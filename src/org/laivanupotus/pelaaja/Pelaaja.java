package org.laivanupotus.pelaaja;

import java.util.ArrayList;
import java.util.Random;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Pelaaja {
	
	private String nimi;
	private ArrayList<Laiva> laivaLista; 
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
		laivaLista = new ArrayList<Laiva>();
	}
	
	public String annaNimi() {
		return nimi;
	}
	
	//arpoo laivat
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = arvoSijainnit(laivaPituudet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			annaLaivaLista().add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
	}
	
	public int[][] arvoSijainnit(int laivanPituus, Lauta l) {
		
		Random rand = new Random();
		
		while(true) {
			int[] a = new int[] {rand.nextInt(10), rand.nextInt(10)};
			int[] b = new int[] {rand.nextInt(10), rand.nextInt(10)};
			
			//Tarkastetaan onko syötetty laiva oikean pituinen ja suora
			if (!SyoteApu.tarkistaPituus(a, b, laivanPituus)){
			}
			
			//Tarkaseetaan tulisiko päällekkäisiä/vierekkäisiä laivoja
			else if (!l.tarkistaKoordinaatit(a, b)){
			}
			
			else{
				return new int[][] {a, b};
			}
		}
	}
	
	//palauttaa listan laivoista
	public ArrayList<Laiva> annaLaivaLista() {
		return laivaLista;
	}
	
	//asettaa listan laivoista
	public void asetaLaivaLista(ArrayList<Laiva> laivaLista) {
		this.laivaLista = laivaLista;
	}
	
}
