package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Ihmispelaaja extends Pelaaja {

	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyyt�� k�ytt�j�� asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko sy�tt�m�t ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus, String laivanNimi, Lauta lauta) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydet��n sy�te
			if (laivanPituus == 1) {
				System.out.println("Laivan nimi: " + laivanNimi + " (Pituus: " + laivanPituus + ")");
				System.out.println("Anna ruutu");
				aloitusruutu = scanner.nextLine();
				lopetusruutu = aloitusruutu;
			}
			
			else {
				System.out.println("Laivan nimi: " + laivanNimi + " (Pituus: " + laivanPituus + ")");
				System.out.println("Anna aloitusruutu");
				aloitusruutu = scanner.nextLine();
				System.out.println("Anna lopetusruutu");
				lopetusruutu = scanner.nextLine();
			}
			
				
			//Tarkastetaan onko sy�te oikean tyyppinen
			if (!SyoteApu.tarkistaSyote(aloitusruutu) || !SyoteApu.tarkistaSyote(lopetusruutu)) {
				System.out.println("V��r�n tyyppinen sy�te. Anna ruudut muodossa 'A1'");
				System.out.println();
			} 
			
			//Tarkastetaan onko sy�tetty laiva oikean pituinen ja suora
			else if (!SyoteApu.tarkistaPituus(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("V��r�n pituinen tai ep�suora laiva!");
				System.out.println();
			}
			
			//Tarkaseetaan tulisiko p��llekk�isi�/vierekk�isi� laivoja
			else if (!lauta.tarkistaKoordinaatit(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu))){
				System.out.println("Laivat eiv�t saa koskettaa toisiaan!");
				System.out.println();
			}
				
			else break;
		}
			
		int[] alkuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(aloitusruutu);
		int[] loppuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(lopetusruutu);
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};
	}

	public void kysyLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij�", "Risteilij�", "H�vitt�j�", "H�vitt�j�", "H�vitt�j�", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			lauta.tulostaLauta();
			int[][] syote = otaSyote(laivaPituudet[i], laivanNimet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			lauta.asetaLaivaLaudalle(laiva);
		}
		
	}
	
}
