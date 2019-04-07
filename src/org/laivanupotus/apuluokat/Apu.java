package org.laivanupotus.apuluokat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Apu {
	
	Scanner scanner = new Scanner(System.in);
	
	//Kysyy onko pelaaja ihminen vai kone. Palauttaa true jos ihminen, false jos kone
	//Parametrina pelaajan numero
	public boolean kysyPelaaja(int pelaajaNumero) {
		while (true) {
			System.out.println("Pelaaja " + pelaajaNumero +  ", oletko ihmispelaaja vai teko�ly? \n1 - Ihmispelaaja \n2 - Teko�ly");
			String syote = scanner.nextLine();
			
			if (syote.equals("1")) {
				return true;
			}
			else if (syote.equals("2")) {
				return false;
			}		
			else {
				System.out.println("V��r�nlainen sy�te!");
			}
		}
	}
	
	//Tarkistaa onko sy�te muotoa kirjainNumero, esim "A0"
	public boolean tarkistaSyote(String s){		
		String regex = "^[a-jA-J]+[0-9]";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);   
		
		if(matcher.find() && s.length() == 2) {
			return true;
		}
		return false;
	}
	
	//Tarkistaa ett� k�ytt�j�n sy�tt�m� laiva on oikean pituinen ja suora
	public boolean tarkistaPituus(int[] alku, int[] loppu, int pituus) {
		if (alku[0] != loppu[0] && alku[1] != loppu[1]) return false;
		
		if (Math.abs(loppu[0]-alku[0]+loppu[1]-alku[1]) + 1 != pituus) return false;
		
		return true;
	}
	
	//Muuttaa sy�teruudun tyypist� String tyyppiin int[]. Esim "A0" -> {0,0}
	public int[] muunnaKoordinaateiksi(String s) {
		int[] palautus = new int[2];
		palautus[0] = muunnaNumeroksi(s.substring(0,1));
		try {
			palautus[1] = Integer.parseInt(s.substring(1, 2));
		} catch (NumberFormatException ex) {
			System.out.println("V��r�n tyyppinen sy�te. Anna ruudut muodossa 'A0'");
		}
		return palautus;
	}
	
	//Muuttaa kirjaimen a-j numeroksi 0-9
	//Sy�te kirjain a-j tyyppi� String
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
		else System.out.println("mit�s mit�s?? Palautetaan 0");
		return palautus;
	}
	
	//Piirt�� ascii laivan
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