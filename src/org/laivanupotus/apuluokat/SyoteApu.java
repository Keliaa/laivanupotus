package org.laivanupotus.apuluokat;
import java.util.Scanner;

import org.laivanupotus.logiikka.Lauta;

public class SyoteApu {
	
	//Tarkistaa onko syöte muotoa kirjainNumero, esim "A0"
	//Vois tehdä paremmin regex?
	public static boolean tarkistaSyote(String s){
		if (s.length() != 2) return false;
		
		String[] numerot = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] kirjaimet = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		
		boolean onkoNumero = false;
		boolean onkoKirjain = false;
		
		for (String s1 : kirjaimet) {
			if (s1.equals(s.substring(0, 1).toLowerCase())) onkoKirjain = true;
		}
		
		for (String s1 : numerot) {
			if (s1.equals(s.substring(1, 2).toLowerCase())) onkoNumero = true;
		}
		
		if (onkoKirjain && onkoNumero) return true;
		else return false;
	}
	
	//Muuttaa syöteruudun tyypistä String tyyppiin int[]. Esim "A0" -> {0,0}
	public static int[] muunnaKoordinaateiksi(String s) {
		int[] palautus = new int[2];
		palautus[0] = muunnaNumeroksi(s.substring(0,1));
		palautus[1] = Integer.parseInt(s.substring(1, 2));
		return palautus;
	}
	
	//Muuttaa kirjaimen a-j numeroksi 0-9
	//Syöte kirjain a-j tyyppiä String
	public static int muunnaNumeroksi(String s) {
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
}
