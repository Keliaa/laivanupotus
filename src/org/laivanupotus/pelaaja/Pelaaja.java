package org.laivanupotus.pelaaja;

import java.util.ArrayList;
import java.util.Random;

import org.laivanupotus.apuluokat.Apu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Pelaaja {
	
	Apu apuri = new Apu();
	
	private String nimi;
	private ArrayList<Laiva> laivaLista; 
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
		laivaLista = new ArrayList<Laiva>();
	}
	
	public String annaNimi() {
		return nimi;
	}
	
	//arpoo laivat laudalle
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij‰", "Risteilij‰", "H‰vitt‰j‰", "H‰vitt‰j‰", "H‰vitt‰j‰", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = arvoSijainnit(laivaPituudet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			annaLaivaLista().add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
	}
	
	//Arpoo sijainnin laivalle
	public int[][] arvoSijainnit(int laivanPituus, Lauta l) {
		
		Random rand = new Random();
		
		while(true) {
			int[] a = new int[] {rand.nextInt(10), rand.nextInt(10)};
			int[] b = new int[] {rand.nextInt(10), rand.nextInt(10)};
			
			//Tarkastetaan onko syˆtetty laiva oikean pituinen ja suora
			if (!apuri.tarkistaPituus(a, b, laivanPituus)){
			}
			
			//Tarkaseetaan tulisiko p‰‰llekk‰isi‰/vierekk‰isi‰ laivoja
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
	
	//Tarkastaa osuttiinko yhteenk‰‰n laivaan, ja kommentoidaan asianmukaisesti
			public void tarkastaLaivat(int[] ruutu, boolean kommentoidaanko) {
				boolean huti = true;
				for (Laiva l : annaLaivaLista()) {
					if (l.tarkastaOsuma(ruutu)) {
						huti = false;
						if(l.onkoLaivaUponnut() && kommentoidaanko) System.out.println("Osui ja upposi!");
						else if (kommentoidaanko) System.out.println("Osuma!");
					}
				}
				if (huti && kommentoidaanko)
					System.out.println("Huti!");
			}
}
