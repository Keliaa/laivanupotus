package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Lauta;

public class Pelaaja {
	
	private String nimi;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
	}
	
	public String annaNimi() {
		return nimi;
	}

	public int[][] otaSyote() {
		
		//Paljon sotkusta koodia
		//Tässä siis syötteen pitää olla muotoa "A1 A1", eli kirjainNumero kirjainNumero
		//Tä oli vähän testailua tohon kirjain->numero muunnokseen, muutetaan selkeemmäks varsinaiseen peliin
		
		String koordinaatit = "";
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Anna koordinaatit: ");
			koordinaatit = scanner.nextLine();
			if (!SyoteApu.tarkistaSyote(koordinaatit)) {
				System.out.println("torun pahasti");
				System.out.println();
			}
			else break;
		}
		
		System.out.println();
		
		int[] alkuKoordinaatti = new int[2];
		int[] loppuKoordinaatti = new int[2];
			 
		alkuKoordinaatti[1] = Integer.parseInt(koordinaatit.substring(1, 2));
		loppuKoordinaatti[1] = Integer.parseInt(koordinaatit.substring(4, 5));
		alkuKoordinaatti[0] = SyoteApu.muunnaNumeroksi(koordinaatit.substring(0, 1));
		loppuKoordinaatti[0] = SyoteApu.muunnaNumeroksi(koordinaatit.substring(3, 4));
			 
		System.out.println("Alku: " + alkuKoordinaatti[0] + ", " + alkuKoordinaatti[1]);
		System.out.println("Loppu: " + loppuKoordinaatti[0] + ", " + loppuKoordinaatti[1]);
		
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};

	}
	
}
