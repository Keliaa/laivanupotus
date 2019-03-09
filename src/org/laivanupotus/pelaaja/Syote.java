package org.laivanupotus.pelaaja;
import java.util.Scanner;

import org.laivanupotus.logiikka.Lauta;

public class Syote {
	public static void otaSyote() {
		
		//Paljon sotkusta koodia
		
		String koordinaatit = "";
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Anna koordinaatit: ");
			koordinaatit = scanner.nextLine();
			if (!tarkistaSyote(koordinaatit)) {
				System.out.println("torun pahasti");
				System.out.println();
			}
			else break;
		}
		
		System.out.println();
		
		int[] alkuKoordinaatti = new int[2];
		int[] loppuKoordinaatti = new int[2];
			 
		alkuKoordinaatti[1] = Integer.parseInt(koordinaatit.substring(1, 2));
		loppuKoordinaatti[1] = Integer.parseInt(koordinaatit.substring(4, 5));
		alkuKoordinaatti[0] = muunnaNumeroksi(koordinaatit.substring(0, 1));
		loppuKoordinaatti[0] = muunnaNumeroksi(koordinaatit.substring(3, 4));
			 
		System.out.println("Alku: " + alkuKoordinaatti[0] + ", " + alkuKoordinaatti[1]);
		System.out.println("Loppu: " + loppuKoordinaatti[0] + ", " + loppuKoordinaatti[1]);
		
		Lauta lauta = new Lauta();
		lauta.asetaLaivaLaudalle(alkuKoordinaatti, loppuKoordinaatti);
		lauta.tulostaLauta();
	}
	
	public static boolean tarkistaSyote(String s){
		String osa1 = s.substring(0, 1).toLowerCase();
		String osa2 = s.substring(1, 2).toLowerCase();
		String osa3 = s.substring(2, 3).toLowerCase();
		String osa4 = s.substring(3, 4).toLowerCase();
		String osa5 = s.substring(4, 5).toLowerCase();
		
		String[] numerot = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] kirjaimet = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		
		boolean onkoNumero = false;
		boolean onkoKirjain = false;
		boolean onkoNumero2 = false;
		boolean onkoKirjain2 = false;
		
		for (String s1 : kirjaimet) {
			if (s1.equals(osa1)) onkoKirjain = true;
			if (s1.equals(osa4)) onkoKirjain2 = true;
		}
		
		for (String s1 : numerot) {
			if (s1.equals(osa2)) onkoNumero = true;
			if (s1.equals(osa5)) onkoNumero2 = true;
		}
		
		if (onkoNumero && onkoKirjain && osa3.equals(" ")) return true;
		else return false;
	}
	
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
