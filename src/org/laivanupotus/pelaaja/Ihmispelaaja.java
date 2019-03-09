package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;

public class Ihmispelaaja extends Pelaaja {

	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyyt�� k�ytt�j�� asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko sy�tt�m�t ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus, String laivanNimi) {

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
				System.out.println("V��r�n tyyppinen sy�te. Anna ruudut muodossa 'A1'");
				System.out.println();
			} 
			
			else if (!SyoteApu.tarkistaPituus(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("V��r�n pituinen tai ep�suora laiva!");
				System.out.println();
			}
				
			else break;
		}
			
		int[] alkuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(aloitusruutu);
		int[] loppuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(lopetusruutu);
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};
	}
	
}
