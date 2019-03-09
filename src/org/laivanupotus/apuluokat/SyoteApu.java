package org.laivanupotus.apuluokat;
import java.util.Scanner;

import org.laivanupotus.logiikka.Lauta;

public class SyoteApu {
	
	//Tarkistaa onko syöte muotoa kirjainNumero kirjainNumero, esim "A1 A1"
	//Kantsii tehä uusiks sit ku ollaan päätetty missä muodossa syöte oikeesti on
	//Tä on aika sotku, regexillä parempi :D
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
		
		if (onkoNumero && onkoKirjain && onkoNumero2 && onkoKirjain2 && osa3.equals(" ")) return true;
		else return false;
	}
	
	//Muuttaa numerot a-j numeroiksi 0-9
	//Syöte yksi kirjain
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
