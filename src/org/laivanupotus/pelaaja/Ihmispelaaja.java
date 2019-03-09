package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;

public class Ihmispelaaja extends Pelaaja {

	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyytää käyttäjää asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko syöttämät ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
				
			System.out.println("Laivan pituus: " + laivanPituus);
			System.out.println("Anna aloitusruutu");
			aloitusruutu = scanner.nextLine();
			System.out.println("Anna lopetusruutu");
			lopetusruutu = scanner.nextLine();
				
			if (SyoteApu.tarkistaSyote(aloitusruutu) && SyoteApu.tarkistaSyote(lopetusruutu)) break;
					
			else {
				System.out.println("Väärän tyyppinen syöte. Anna ruudut muodossa 'A1'");
				System.out.println();
					
				//Tarkasta pituus?
			}
					
		}
			
		int[] alkuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(aloitusruutu);
		int[] loppuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(lopetusruutu);
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};
	}
	
}
