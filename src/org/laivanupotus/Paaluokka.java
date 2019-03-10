package org.laivanupotus;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Lataus;
import org.laivanupotus.tallennus.Tallennus;

public class Paaluokka {
	
	public static boolean tallenna;
	public static boolean lataa;
	
	public static void main(String[] args) {
		
		//luodaan pelaaajat
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		
		//Luodaan laudat
		Lauta tekoLauta = null;
		Lauta lauta = null;
		
		//Asetetaan tekoälyn vaikeusaste
		tekoaly.asetaVaikeus();
		ihmispelaaja.kysyLadataankoPeli();
		
		//Lautojen asettelua
		if(lataa) {
			tekoLauta = Lataus.lataaLaudanTila(true);
			lauta = Lataus.lataaLaudanTila(false);
			lataa = false;
		} else {
		
			lauta = new Lauta();
			
			//luodaan tekoälyn lauta. tätä ei sitten printata, muuten voi mennä pelaaminen liian helpoksi.
			tekoLauta = new Lauta();
			
			//asetetaan laivat - pelaaja
			ihmispelaaja.asetaLaivat(lauta);
			
			//asetetaan laivat - tekoäly
			tekoaly.arvoLaivat(tekoLauta);
		}
		System.out.println("Voit kirjoittaa 'tallenna' tallentaaksesi pelin tästä eteenpäin.");
		System.out.println();
		
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
			
			if(tallenna) {
				tallennaPeli(ihmispelaaja, tekoaly, lauta, tekoLauta);
				tallenna = false;
			}
			
		}
	}

	public static void tallennaPeli(Ihmispelaaja ihmispelaaja, Tekoaly tekoaly, Lauta lauta, Lauta tekolauta) {
		Tallennus.tallennaLaivojenTila(ihmispelaaja.annaLaivaLista(), false);
		Tallennus.tallennaLaivojenTila(tekoaly.annaLaivaLista(), true);
		Tallennus.tallennaLaudanTila(lauta, false);
		Tallennus.tallennaLaudanTila(tekolauta, true);
	}

}
