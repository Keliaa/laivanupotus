package org.laivanupotus;

import org.laivanupotus.apuluokat.Apu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Lataus;
import org.laivanupotus.tallennus.Tallennus;

public class Paaluokka {
	
	public static boolean tallenna;
	public static boolean lataa;
	
	public static void main(String[] args) {
		
		Apu apuri = new Apu();
		
		//piirret‰‰n laiva
		apuri.piirraLaiva();
		
		//luodaan pelaaajat
		Pelaaja pelaaja1;
		if (apuri.kysyPelaaja(1)) pelaaja1 = new Ihmispelaaja("Pelaaja 1");
		else pelaaja1 = new Tekoaly("Teko‰ly 1");
		Pelaaja pelaaja2;
		if (apuri.kysyPelaaja(2)) pelaaja2 = new Ihmispelaaja("Pelaaja 2");
		else pelaaja2 = new Tekoaly("Teko‰ly 2");
		
		//Luodaan laudat
		Lauta lauta1 = null;
		Lauta lauta2 = null;
		
		//Asetetaan teko‰lyn vaikeusaste
		if (pelaaja1 instanceof Tekoaly) ((Tekoaly)pelaaja1).asetaVaikeus(1);
		if (pelaaja2 instanceof Tekoaly) ((Tekoaly)pelaaja2).asetaVaikeus(2);
		
		//Kysyt‰‰n ladataanko peli
		if (pelaaja1 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja1).kysyLadataankoPeli();
		else if (pelaaja2 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja2).kysyLadataankoPeli();
		
		//Lautojen asettelua
		if(lataa) {
			lauta1 = Lataus.lataaLaudanTila(true);
			lauta2 = Lataus.lataaLaudanTila(false);
			
			//Asetetaan laivat laudalle ja listoihin
			for (Laiva i : Lataus.lataaLaivojenTila(false)) {
				lauta1.asetaLaivaLaudalle(i);
				pelaaja1.annaLaivaLista().add(i);
				pelaaja1.asetaLaivaLista(Lataus.lataaLaivojenTila(false));
			}
			for (Laiva i : Lataus.lataaLaivojenTila(true)) {
				lauta2.asetaLaivaLaudalle(i);
				pelaaja2.annaLaivaLista().add(i);
				pelaaja2.asetaLaivaLista(Lataus.lataaLaivojenTila(true));
			}
			lataa = false;
		} else {
			
			//luodaan laudat
			lauta1 = new Lauta();
			lauta2 = new Lauta();
			
			//asetetaan laivat laudalle
			if (pelaaja1 instanceof Tekoaly) ((Tekoaly)pelaaja1).arvoLaivat(lauta1);
			else ((Ihmispelaaja)pelaaja1).asetaLaivat(lauta1);
			if (pelaaja2 instanceof Tekoaly) ((Tekoaly)pelaaja2).arvoLaivat(lauta2);
			else ((Ihmispelaaja)pelaaja2).asetaLaivat(lauta2);
		}
		System.out.println("Voit kirjoittaa 'tallenna' tallentaaksesi pelin t‰st‰ eteenp‰in.");
		System.out.println();
		
		//Pelataan!
		while(true) {
			if (pelaaja1 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja1).vuoro(lauta1, lauta2, pelaaja2);
			else ((Tekoaly)pelaaja1).vuoro(lauta1, lauta2, pelaaja2);
			
			if (lauta2.onkoHavinnyt()) {
				System.out.println("Pelaaja 1 voitti pelin!");
				break;
			}
			
			if (pelaaja2 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja2).vuoro(lauta2, lauta1, pelaaja1);
			else ((Tekoaly)pelaaja2).vuoro(lauta2, lauta1, pelaaja1);
			if (lauta1.onkoHavinnyt()) {
				System.out.println("Pelaaja 2 voitti pelin!");
				break;
			}
			
			if(tallenna) {
				tallennaPeli(pelaaja1, pelaaja2, lauta1, lauta2);
				tallenna = false;
			}
			
		}
	}

	//Tallennetaan peli
	public static void tallennaPeli(Pelaaja ihmispelaaja, Pelaaja tekoaly, Lauta lauta, Lauta tekolauta) {
		Tallennus.tallennaLaivojenTila(ihmispelaaja.annaLaivaLista(), false);
		Tallennus.tallennaLaivojenTila(tekoaly.annaLaivaLista(), true);
		Tallennus.tallennaLaudanTila(lauta, false);
		Tallennus.tallennaLaudanTila(tekolauta, true);
	}
}
