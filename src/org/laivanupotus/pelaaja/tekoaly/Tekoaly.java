package org.laivanupotus.pelaaja.tekoaly;

import java.util.Random;
import java.util.Scanner;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;

public class Tekoaly extends Pelaaja {
	
	private int vaikeus;

	public Tekoaly(String nimi) {
		super(nimi);
		this.vaikeus = 1;
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
			for (Laiva l : annaLaivaLista()) {
				if (l.tarkastaOsuma(ruutu)) {
					huti = false;
					if(l.onkoLaivaUponnut()) System.out.println("Osui ja upposi!");
					else System.out.println("Osuma!");
				}
			}
			if (huti)
				System.out.println("Huti!");
		}
		
		//Kysyy pelaajalta vaikeusasteen ja asettaa sen muuttujaan vaikeus
		@SuppressWarnings("resource")
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
