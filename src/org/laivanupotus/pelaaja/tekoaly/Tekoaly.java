package org.laivanupotus.pelaaja.tekoaly;

import java.util.Random;
import java.util.Scanner;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Pelaaja;

public class Tekoaly extends Pelaaja {
	
	private int vaikeus;

	public Tekoaly(String nimi) {
		super(nimi);
		this.vaikeus = 1;
	}
	
	//Ampuu satunnaiseen ruutuun
		public void vuoro(Lauta omaLauta, Lauta vastusLauta, Pelaaja ihmispelaaja) {
			
			Random rand = new Random();
			int[] kohderuutu = new int[2];
			
			while(true) {
				kohderuutu[0] = rand.nextInt(10);
				kohderuutu[1] = rand.nextInt(10);
				
				//Tarkastetaan onko jo ammuttu t�h�n ruutuun
				if(vastusLauta.annaMerkki(kohderuutu).equals("X")) {
					continue;
				}
				
				else if(vaikeus == 2) { //Jos vaikeusaste on vaikea, yritet��n todenn�k�isemmin ampua laivaan
					if(vastusLauta.annaMerkki(kohderuutu).equals("~") && rand.nextInt(10)>2) {
						continue;
					}
					
					else break;
				}
				
				else break;
			}
			
			ammu(kohderuutu, vastusLauta, ihmispelaaja);
		}
		
		//Asettaa ruudun merkiksi "X" ja tarkistaa oliko osuma
		public void ammu(int[] ruutu, Lauta lauta1, Pelaaja pelaaja1) {
			lauta1.asetaAmmuttuRuutu(ruutu);
			pelaaja1.tarkastaLaivat(ruutu, false);
		}
		
		//Kysyy pelaajalta vaikeusasteen ja asettaa sen muuttujaan vaikeus
		@SuppressWarnings("resource")
		public void asetaVaikeus(int pelaajaNumero) {
			while(true) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Valitse vaikeusaste pelaajalle " + pelaajaNumero + " sy�tt�m�ll� numero");
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
					System.out.println("V��r�nlainen sy�te!");
				}
			}
		}

}
