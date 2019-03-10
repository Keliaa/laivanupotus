package org.laivanupotus.pelaaja.tekoaly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;

public class Tekoaly extends Pelaaja {
	
	private int vaikeus;
	private ArrayList<Laiva> laivaLista; 

	public Tekoaly(String nimi) {
		super(nimi);
		laivaLista = new ArrayList<Laiva>();
		this.vaikeus = 1;
	}
	
	//tänne sitä tekoälyn toiminnallisuutta
	

	//arpoo laivat
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
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
			
			//Tarkastetaan onko syötetty laiva oikean pituinen ja suora
			if (!SyoteApu.tarkistaPituus(a, b, laivanPituus)){
			}
			
			//Tarkaseetaan tulisiko päällekkäisiä/vierekkäisiä laivoja
			else if (!l.tarkistaKoordinaatit(a, b)){
			}
			
			else{
				return new int[][] {a, b};
			}
			
			
			
			//Vanha keskeneränen tässä
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
				
				//Tarkastetaan onko jo ammuttu tähän ruutuun
				if(lauta.annaMerkki(kohderuutu).equals("X")) {
					continue;
				}
				
				else if(vaikeus == 2) {
					if(lauta.annaMerkki(kohderuutu).equals("~") && rand.nextInt(10)>2) {
						continue;
					}
					
					else break;
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
		
		//Tarkastaa osuttiinko yhteenkään laivaan, ja kommentoidaan asianmukaisesti
		public void tarkastaLaivat(int[] ruutu) {
			boolean huti = true;
			for (Laiva l : laivaLista) {
				if (l.tarkastaOsuma(ruutu)) {
					huti = false;
					if(l.onkoLaivaUponnut()) System.out.println("Osui ja upposi!");
					else System.out.println("Osuma!");
				}
			}
			if (huti)
				System.out.println("Huti!");
		}
		
		//palauttaa listan laivoista
		public ArrayList<Laiva> annaLaivaLista() {
			return laivaLista;
		}
		
		//Kysyy pelaajalta vaikeusasteen ja asettaa sen muuttujaan vaikeus
		public void asetaVaikeus() {
			while(true) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Valitse vaikeusaste syöttämällä numero");
				System.out.println("1 - Helppo");
				System.out.println("2 - Vaikea");
				
				String syote = scanner.nextLine();
				
				if (syote.equals("1")) {
					vaikeus = 1;
					break;
				}
				
				else if (syote.equals("2")) {
					vaikeus = 2;
					break;
				}
				
				else {
					System.out.println("Vääränlainen syöte!");
				}
			}
		}

}
