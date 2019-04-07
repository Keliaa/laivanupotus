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
		public void vuoro(Lauta tekoLauta, Lauta lauta, Pelaaja ihmispelaaja) {
			
			Random rand = new Random();
			int[] kohderuutu = new int[2];
			
			while(true) {
				kohderuutu[0] = rand.nextInt(10);
				kohderuutu[1] = rand.nextInt(10);
				
				//Tarkastetaan onko jo ammuttu tähän ruutuun
				if(lauta.annaMerkki(kohderuutu).equals("X")) {
					continue;
				}
				
				else if(vaikeus == 2) { //Jos vaikeusaste on vaikea, yritetään todennäköisemmin ampua laivaan
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
		public void ammu(int[] ruutu, Lauta lauta, Pelaaja pelaaja1) {
			lauta.asetaAmmuttuRuutu(ruutu);
			pelaaja1.tarkastaLaivat(ruutu, false);
		}
		
		//Kysyy pelaajalta vaikeusasteen ja asettaa sen muuttujaan vaikeus
		@SuppressWarnings("resource")
		public void asetaVaikeus(int pelaajaNumero) {
			while(true) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Valitse vaikeusaste pelaajalle " + pelaajaNumero + " syöttämällä numero");
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
