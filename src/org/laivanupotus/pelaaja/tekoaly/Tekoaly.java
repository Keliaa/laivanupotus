package org.laivanupotus.pelaaja.tekoaly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;

public class Tekoaly extends Pelaaja {
	
	private ArrayList<Laiva> laivaLista; 

	public Tekoaly(String nimi) {
		super(nimi);
		laivaLista = new ArrayList<Laiva>();
	}
	
	//t�nne sit� teko�lyn toiminnallisuutta
	

	//arpoo laivat
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij�", "Risteilij�", "H�vitt�j�", "H�vitt�j�", "H�vitt�j�", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = arvoSijainnit(laivaPituudet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			laivaLista.add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
	}
	
	//arpoo laivojen sijainnit
	public int[][] arvoSijainnit(int laivanPituus, Lauta l) {
		
		Random rand = new Random();
		
		while(true) {
			int[] a = new int[] {rand.nextInt(10), rand.nextInt(10)};
			int[] b = new int[] {rand.nextInt(10), rand.nextInt(10)};
			
			//Tarkastetaan onko sy�tetty laiva oikean pituinen ja suora
			if (!SyoteApu.tarkistaPituus(a, b, laivanPituus)){
			}
			
			//Tarkaseetaan tulisiko p��llekk�isi�/vierekk�isi� laivoja
			else if (!l.tarkistaKoordinaatit(a, b)){
			}
			
			else{
				return new int[][] {a, b};
			}
			
			
			
			//Vanha keskener�nen t�ss�
			/*Random rand = new Random();
			int n = rand.nextInt(10);
			
			int temp = (Math.random() <= 0.5) ? 1 : 2;
			boolean plusVaiMiinus;
			if(temp == 1)
				plusVaiMiinus = true;
			
			
			return new int[] {n, n2};*/
			
		}
	}
	
	//Ampuu satunnaiseen ruutuun
		public void vuoro(Lauta tekoLauta, Lauta lauta, Ihmispelaaja ihmispelaaja) {
			
			Random rand = new Random();
			int[] kohderuutu = new int[2];
			
			while(true) {
				kohderuutu[0] = rand.nextInt(10);
				kohderuutu[1] = rand.nextInt(10);
				
				//Tarkastetaan onko jo ammuttu t�h�n ruutuun
				if(lauta.annaMerkki(kohderuutu).equals("X")) {
					System.out.println("T�h�n ruutuun on jo ammuttu!");
					System.out.println();
				}
				
				else break;
			}
			
			ammu(kohderuutu, lauta, ihmispelaaja);
		}
		
		//Asettaa ruudun merkiksi "X" ja tarkistaa oliko osuma
		public void ammu(int[] ruutu, Lauta lauta, Ihmispelaaja ihmispelaaja) {
			lauta.asetaAmmuttuRuutu(ruutu);
			ihmispelaaja.tarkastaLaivat(ruutu);
		}
		
		//Tarkastaa osuttiinko yhteenk��n laivaan, ja kommentoidaan asianmukaisesti
		public void tarkastaLaivat(int[] ruutu) {
			for (Laiva l : laivaLista) {
				if (l.tarkastaOsuma(ruutu)) {
					if(l.onkoLaivaUponnut()) System.out.println("Osui ja upposi!");
					else System.out.println("Osuma!");
				}
			}
		}

}
