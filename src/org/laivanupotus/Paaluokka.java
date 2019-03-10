package org.laivanupotus;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;

public class Paaluokka {
	
	//testi :D
	
	public static void main(String[] args) {
		//luodaan lauta
		Lauta lauta = new Lauta();
		
		//luodaan teko�lyn lauta. t�t� ei sitten printata, muuten voi menn� pelaaminen liian helpoksi.
		Lauta tekoLauta = new Lauta();
		
		//luodaan pelaaajat
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		
		//asetetaan laivat - pelaaja
		//ihmispelaaja.kysyLaivat(lauta);
		
		//arvotaan ihmispelaajan laivat
		ihmispelaaja.arvoLaivat(lauta);
		
		//asetetaan laivat - teko�ly
		tekoaly.arvoLaivat(tekoLauta);
		
		//tulostetaan VAIN pelaajan lauta
		lauta.tulostaLauta();
		
		//Loputon peli
		while(true) {
		ihmispelaaja.vuoro(lauta, tekoLauta, tekoaly);
		if (tekoLauta.onkoHavinnyt()) {
			System.out.println("Voitit pelin!");
			break;
		}
		
		tekoaly.vuoro(tekoLauta, lauta, ihmispelaaja);
		tekoLauta.tulostaPiiloLauta();
		lauta.tulostaLauta();
		
		if (lauta.onkoHavinnyt()) {
			System.out.println("H�visit pelin!");
			break;
		}
		}
	}

}
