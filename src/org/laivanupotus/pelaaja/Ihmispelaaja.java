package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
<<<<<<< HEAD
import org.laivanupotus.logiikka.Laiva;
=======
>>>>>>> branch 'master' of https://github.com/Keliaa/laivanupotus.git
import org.laivanupotus.logiikka.Lauta;

public class Ihmispelaaja extends Pelaaja {

	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyyt‰‰ k‰ytt‰j‰‰ asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko syˆtt‰m‰t ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus, String laivanNimi, Lauta lauta) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
				
			System.out.println("Laivan nimi: " + laivanNimi + " (Pituus: " + laivanPituus + ")");
			System.out.println("Anna aloitusruutu");
			aloitusruutu = scanner.nextLine();
			System.out.println("Anna lopetusruutu");
			lopetusruutu = scanner.nextLine();
				
			if (!SyoteApu.tarkistaSyote(aloitusruutu) || !SyoteApu.tarkistaSyote(lopetusruutu)) {
				System.out.println("V‰‰r‰n tyyppinen syˆte. Anna ruudut muodossa 'A1'");
				System.out.println();
			} 
			
			else if (!SyoteApu.tarkistaPituus(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("V‰‰r‰n pituinen tai ep‰suora laiva!");
				System.out.println();
			}
			
			else if (!lauta.tarkistaKoordinaatit(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu))){
				System.out.println("Ei p‰‰llekk‰isi‰ laivoja!");
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
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij‰", "Risteilij‰", "H‰vitt‰j‰", "H‰vitt‰j‰", "H‰vitt‰j‰", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = otaSyote(laivaPituudet[i], laivanNimet[i]);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1]);
			lauta.asetaLaivaLaudalle(laiva);
		}
		
	}
	
}
