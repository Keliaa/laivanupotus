package org.laivanupotus;

import org.laivanupotus.apuluokat.Apu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Lataus;

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
		Lauta lauta1 = new Lauta();
		Lauta lauta2 = new Lauta();
		
		apuri.asetaVaikeustaso(pelaaja1, pelaaja2);
		apuri.ladataankoPeli(pelaaja1, pelaaja2);	
		apuri.lataaLauta(lauta1, lauta2, pelaaja1, pelaaja2);
		
		apuri.aloitaPeli(lauta1, lauta2, pelaaja1, pelaaja2);
	}
}
