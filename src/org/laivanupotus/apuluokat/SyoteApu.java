package org.laivanupotus.apuluokat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyoteApu {
	
	//Tarkistaa onko syöte muotoa kirjainNumero, esim "A0"
	public static boolean tarkistaSyote(String s){		
		String regex = "^[a-jA-J]+[0-9]";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);   
		
		if(matcher.find() && s.length() == 2) {
			return true;
		}
		return false;
	}
	
	//Tarkistaa että käyttäjän syöttämä laiva on oikean pituinen ja suora
	public static boolean tarkistaPituus(int[] alku, int[] loppu, int pituus) {
		if (alku[0] != loppu[0] && alku[1] != loppu[1]) return false;
		
		if (Math.abs(loppu[0]-alku[0]+loppu[1]-alku[1]) + 1 != pituus) return false;
		
		return true;
	}
	
	//Muuttaa syöteruudun tyypistä String tyyppiin int[]. Esim "A0" -> {0,0}
	public static int[] muunnaKoordinaateiksi(String s) {
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
