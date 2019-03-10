package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Ihmispelaaja extends Pelaaja {

	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyytää käyttäjää asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko syöttämät ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus, String laivanNimi, Lauta lauta) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydetään syöte
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
			
				
			//Tarkastetaan onko syöte oikean tyyppinen
			if (!SyoteApu.tarkistaSyote(aloitusruutu) || !SyoteApu.tarkistaSyote(lopetusruutu)) {
				System.out.println("Väärän tyyppinen syöte. Anna ruudut muodossa 'A1'");
				System.out.println();
			} 
			
			//Tarkastetaan onko syötetty laiva oikean pituinen ja suora
			else if (!SyoteApu.tarkistaPituus(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("Väärän pituinen tai epäsuora laiva!");
				System.out.println();
			}
			
			//Tarkaseetaan tulisiko päällekkäisiä/vierekkäisiä laivoja
			else if (!lauta.tarkistaKoordinaatit(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu))){
				System.out.println("Laivat eivät saa koskettaa toisiaan!");
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
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			lauta.tulostaLauta();
			int[][] syote = otaSyote(laivaPituudet[i], laivanNimet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			lauta.asetaLaivaLaudalle(laiva);
		}
		
	}
	
}
