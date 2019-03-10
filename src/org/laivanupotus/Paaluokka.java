package org.laivanupotus;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Tallennus;

public class Paaluokka {
	
	//testi :D
	
	public static void main(String[] args) {
		//luodaan lauta
		Lauta lauta = new Lauta();
		
		//luodaan tekoälyn lauta. tätä ei sitten printata, muuten voi mennä pelaaminen liian helpoksi.
		Lauta tekoLauta = new Lauta();
		
		//luodaan pelaaajat
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		
		//Asetetaan tekoälyn vaikeusaste
		tekoaly.asetaVaikeus();
		
		//asetetaan laivat - pelaaja
		ihmispelaaja.asetaLaivat(lauta);
		
		//asetetaan laivat - tekoäly
		tekoaly.arvoLaivat(tekoLauta);
		
		//tulostetaan VAIN pelaajan lauta
		//lauta.tulostaLauta();
		
		//Tallennus.tallennaLaudanTila(lauta);
		//Tallennus.tallennaLaivojenTila(ihmispelaaja.annaLaivaLista());
		
		//Loputon peli
		while(true) {
			lauta.tulostaLauta();
			ihmispelaaja.vuoro(lauta, tekoLauta, tekoaly);
			if (tekoLauta.onkoHavinnyt()) {
				System.out.println("Voitit pelin!");
				break;
			}
			
			tekoaly.vuoro(tekoLauta, lauta, ihmispelaaja);
			tekoLauta.tulostaPiiloLauta();
			
			if (lauta.onkoHavinnyt()) {
				System.out.println("Hävisit pelin!");
				break;
			}
		}
	}

}
