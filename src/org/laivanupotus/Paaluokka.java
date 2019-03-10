package org.laivanupotus;

import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Lataus;
import org.laivanupotus.tallennus.Tallennus;

public class Paaluokka {
	
	//testi :D
	
	public static void main(String[] args) {
		lataaPeli();
		//luodaan lauta
		Lauta lauta = new Lauta();
		
		//luodaan teko‰lyn lauta. t‰t‰ ei sitten printata, muuten voi menn‰ pelaaminen liian helpoksi.
		Lauta tekoLauta = new Lauta();
		
		//luodaan pelaaajat
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		
		//Asetetaan teko‰lyn vaikeusaste
		tekoaly.asetaVaikeus();
		
		//asetetaan laivat - pelaaja
		ihmispelaaja.asetaLaivat(lauta);
		
		//asetetaan laivat - teko‰ly
		tekoaly.arvoLaivat(tekoLauta);
		
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
				System.out.println("H‰visit pelin!");
				break;
			}
		}
	}
	
	/*n‰in ladataan molemmat laudat
	 * metodia itsess‰‰n ei ole pakko k‰ytt‰‰ t‰‰ on esimerkki
	 */
	public static void lataaPeli() {
		Lauta tekolauta = Lataus.lataaLaudanTila(true);
		Lauta lauta = Lataus.lataaLaudanTila(false);
	}
	
	/*'
	 * t‰‰ on vaa esimerkki et mite ne ladataa
	 */
	public static void lataaLaivat() {
		Ihmispelaaja ihmispelaaja = new Ihmispelaaja("Testipelaaja");
		Tekoaly tekoaly = new Tekoaly("Tekoaly");
		ihmispelaaja.asetaLaivaLista(Lataus.lataaLaivojenTila(false));
		tekoaly.asetaLaivaLista(Lataus.lataaLaivojenTila(true));
	}

}
