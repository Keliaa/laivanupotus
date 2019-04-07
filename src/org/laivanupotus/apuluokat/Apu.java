package org.laivanupotus.apuluokat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.laivanupotus.Paaluokka;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.Ihmispelaaja;
import org.laivanupotus.pelaaja.Pelaaja;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;
import org.laivanupotus.tallennus.Lataus;
import org.laivanupotus.tallennus.Tallennus;

import java.util.Scanner;


public class Apu {
	
	Scanner scanner = new Scanner(System.in);
	
	//Kysyy onko pelaaja ihminen vai kone. Palauttaa true jos ihminen, false jos kone
	//Parametrina pelaajan numero
	public boolean kysyPelaaja(int pelaajaNumero) {
		while (true) {
			System.out.println("Pelaaja " + pelaajaNumero +  ", oletko ihmispelaaja vai tekoäly? \n1 - Ihmispelaaja \n2 - Tekoäly");
			String syote = scanner.nextLine();
			
			if (syote.equals("1")) {
				return true;
			}
			else if (syote.equals("2")) {
				return false;
			}		
			else {
				System.out.println("Vääränlainen syöte!");
			}
		}
	}
	
	//Asettaa tekoälyn vaikeusasteen
	public void asetaVaikeustaso(Pelaaja pelaaja1, Pelaaja pelaaja2) {
		if (pelaaja1 instanceof Tekoaly) ((Tekoaly)pelaaja1).asetaVaikeus(1);
		if (pelaaja2 instanceof Tekoaly) ((Tekoaly)pelaaja2).asetaVaikeus(2);
	}
	
	//Kysytään ladataanko peli
	public void ladataankoPeli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
		if (pelaaja1 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja1).kysyLadataankoPeli();
		else if (pelaaja2 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja2).kysyLadataankoPeli();
	}
	
	//Ylläpitää pelin logiikkaa
	public void aloitaPeli(Lauta lauta1, Lauta lauta2, Pelaaja pelaaja1, Pelaaja pelaaja2) {
		System.out.println("Voit kirjoittaa 'tallenna' tallentaaksesi pelin tästä eteenpäin.");
		System.out.println();
		//Pelataan!
		while(true) {
			if (pelaaja1 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja1).vuoro(lauta1, lauta2, pelaaja2);
				else ((Tekoaly)pelaaja1).vuoro(lauta1, lauta2, pelaaja2);
			if (lauta2.onkoHavinnyt(1)) break;
					
			if (pelaaja2 instanceof Ihmispelaaja) ((Ihmispelaaja)pelaaja2).vuoro(lauta2, lauta1, pelaaja1);
			else ((Tekoaly)pelaaja2).vuoro(lauta2, lauta1, pelaaja1);
			if (lauta1.onkoHavinnyt(2)) break;
					
			if(Paaluokka.tallenna) {
				tallennaPeli(pelaaja1, pelaaja2, lauta1, lauta2);
				Paaluokka.tallenna = false;
			}				
		}
	}
	
	//Tarkistaa onko syöte muotoa kirjainNumero, esim "A0"
	public boolean tarkistaSyote(String s){		
		String regex = "^[a-jA-J]+[0-9]";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);   
		
		if(matcher.find() && s.length() == 2) {
			return true;
		}
		return false;
	}
	
	//Tarkistaa että käyttäjän syöttämä laiva on oikean pituinen ja suora
	public boolean tarkistaPituus(int[] alku, int[] loppu, int pituus) {
		if (alku[0] != loppu[0] && alku[1] != loppu[1]) return false;
		
		if (Math.abs(loppu[0]-alku[0]+loppu[1]-alku[1]) + 1 != pituus) return false;
		
		return true;
	}
	
	//Muuttaa syöteruudun tyypistä String tyyppiin int[]. Esim "A0" -> {0,0}
	public int[] muunnaKoordinaateiksi(String s) {
		int[] palautus = new int[2];
		palautus[0] = muunnaNumeroksi(s.substring(0,1));
		try {
			palautus[1] = Integer.parseInt(s.substring(1, 2));
		} catch (NumberFormatException ex) {
			System.out.println("Väärän tyyppinen syöte. Anna ruudut muodossa 'A0'");
		}
		return palautus;
	}
	
	//Muuttaa kirjaimen a-j numeroksi 0-9
	//Syöte kirjain a-j tyyppiä String
	public int muunnaNumeroksi(String s) {
		int palautus = 0;
		if (s.toLowerCase().equals("a")) palautus = 0;
		else if (s.toLowerCase().equals("b")) palautus = 1;
		else if (s.toLowerCase().equals("c")) palautus = 2;
		else if (s.toLowerCase().equals("d")) palautus = 3;
		else if (s.toLowerCase().equals("e")) palautus = 4;
		else if (s.toLowerCase().equals("f")) palautus = 5;
		else if (s.toLowerCase().equals("g")) palautus = 6;
		else if (s.toLowerCase().equals("h")) palautus = 7;
		else if (s.toLowerCase().equals("i")) palautus = 8;
		else if (s.toLowerCase().equals("j")) palautus = 9;
		else System.out.println("mitäs mitäs?? Palautetaan 0");
		return palautus;
	}
	
	//Tallennetaan peli
	public void tallennaPeli(Pelaaja pelaaja1, Pelaaja pelaaja2, Lauta lauta1, Lauta lauta2) {
		Tallennus tallentaja = new Tallennus();
		
		tallentaja.tallennaLaivojenTila(pelaaja1.annaLaivaLista(), false);
		tallentaja.tallennaLaivojenTila(pelaaja2.annaLaivaLista(), true);
		tallentaja.tallennaLaudanTila(lauta1, false);
		tallentaja.tallennaLaudanTila(lauta2, true);
	}
	
	//Lataa laudan tai luo sellaisen riippuen siitä, onko lauta tallennettu
	public void lataaLauta(Lauta lauta1, Lauta lauta2, Pelaaja pelaaja1, Pelaaja pelaaja2) {
		//Lautojen asettelua
		if(Paaluokka.lataa) {
			Lataus lataaja = new Lataus();
					
			lauta1 = lataaja.lataaLaudanTila(false);
			lauta2 = lataaja.lataaLaudanTila(true);
					
			//Asetetaan laivat laudalle ja listoihin
			for (Laiva i : lataaja.lataaLaivojenTila(false)) {
				lauta1.asetaLaivaLaudalle(i);
				pelaaja1.annaLaivaLista().add(i);
				pelaaja1.asetaLaivaLista(lataaja.lataaLaivojenTila(false));
			}
			for (Laiva i : lataaja.lataaLaivojenTila(true)) {
				lauta2.asetaLaivaLaudalle(i);
				pelaaja2.annaLaivaLista().add(i);
				pelaaja2.asetaLaivaLista(lataaja.lataaLaivojenTila(true));
			}
				Paaluokka.lataa = false;
			} else {				
				//asetetaan laivat laudalle
				if (pelaaja1 instanceof Tekoaly) ((Tekoaly)pelaaja1).arvoLaivat(lauta1);
				else ((Ihmispelaaja)pelaaja1).asetaLaivat(lauta1);
				if (pelaaja2 instanceof Tekoaly) ((Tekoaly)pelaaja2).arvoLaivat(lauta2);
				else ((Ihmispelaaja)pelaaja2).asetaLaivat(lauta2);
			}
	}
	
	//Piirtää ascii laivan
		public void piirraLaiva() {
	    	System.out.println("              |    |    |                 ");
	    	System.out.println(" Laivan      )_)  )_)  )_)              ");
	    	System.out.println("  Upotus    )___))___))___)\\            ");
	    	System.out.println("    1.2    )____)____)_____)\\\\");
	    	System.out.println("         _____|____|____|____\\\\\\__");
	    	System.out.println("---------\\                   /---------");
	    	System.out.println("  ^^^^^ ^^^^^^^^^^^^^^^^^^^^^");
	    	System.out.println("");
	    	System.out.println("    ^^^^      ^^^^     ^^^    ^^");
	    	System.out.println("         ^^^^      ^^^");
	    }

}
