package org.laivanupotus.pelaaja;

import java.util.Scanner;

import org.laivanupotus.Paaluokka;
import org.laivanupotus.apuluokat.Apu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Ihmispelaaja extends Pelaaja {
	
	Apu apuri = new Apu();
	
	public Ihmispelaaja(String nimi) {
		super(nimi);
	}

	//Pyyt�� k�ytt�j�� asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko sy�tt�m�t ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	@SuppressWarnings("resource")
	public int[][] otaSyote(int laivanPituus, String laivanNimi, Lauta lauta) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydet��n sy�te
			if (laivanPituus == 1) {
				System.out.println("Laivan nimi: " + laivanNimi + " (Pituus: " + laivanPituus + ")");
				System.out.println("Anna ruutu");
				aloitusruutu = scanner.nextLine();
				lopetusruutu = aloitusruutu;
			}
			
			else {
				System.out.println("Laivan nimi: " + laivanNimi + " (Pituus: " + laivanPituus + ")");
				System.out.println("Anna aloitusruutu");
				aloitusruutu = scanner.nextLine();
				System.out.println("Anna lopetusruutu");
				lopetusruutu = scanner.nextLine();
			}
			
				
			//Tarkastetaan onko sy�te oikean tyyppinen
			if (!apuri.tarkistaSyote(aloitusruutu) || !apuri.tarkistaSyote(lopetusruutu)) {
				System.out.println("V��r�n tyyppinen sy�te. Anna ruudut muodossa 'A0'");
				System.out.println();
			} 
			
			//Tarkastetaan onko sy�tetty laiva oikean pituinen ja suora
			else if (!apuri.tarkistaPituus(apuri.muunnaKoordinaateiksi(aloitusruutu), apuri.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("V��r�n pituinen tai ep�suora laiva!");
				System.out.println();
			}
			
			//Tarkaseetaan tulisiko p��llekk�isi�/vierekk�isi� laivoja
			else if (!lauta.tarkistaKoordinaatit(apuri.muunnaKoordinaateiksi(aloitusruutu), apuri.muunnaKoordinaateiksi(lopetusruutu))){
				System.out.println("Laivat eiv�t saa koskettaa toisiaan!");
				System.out.println();
			}
				
			else break;
		}
			
		int[] alkuKoordinaatti = apuri.muunnaKoordinaateiksi(aloitusruutu);
		int[] loppuKoordinaatti = apuri.muunnaKoordinaateiksi(lopetusruutu);
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};
	}

	//Kysyy miten pelaaja haluaa asettaa laudalle, ja kutsuu sen mukaista asetusmetodia
	@SuppressWarnings("resource")
	public void asetaLaivat(Lauta lauta) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println(this.annaNimi() + ":");
			System.out.println("Sy�t� '1' asettaaksesi laivat laudalle manuaalisesti.");
			System.out.println("Sy�t� '2' arpoaksesi laivojen sijainnit.");
			String syote = scanner.nextLine();
			
			if (syote.equals("1")) {
				kysyLaivat(lauta);
				break;
			}
			
			else if (syote.equals("2")) {
				arvoLaivat(lauta);
				break;
			}
			
			else {
				System.out.println("V��r�nlainen sy�te!");
			}
		}
	}
	
	//Kysyy ladataanko peli
	@SuppressWarnings("resource")
	public void kysyLadataankoPeli() {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Haluatko ladata pelin? (K/E)");
			String syote = scanner.nextLine();
			
			if (syote.equalsIgnoreCase("K")) {
				Paaluokka.lataa = true;
				break;
			}
			
			else if (syote.equalsIgnoreCase("E")) {
				Paaluokka.lataa = false;
				break;
			}
			
			else {
				System.out.println("V��r�nlainen sy�te!");
			}
		}
	}
	
	//Aseta laivat kysym�ll� k�ytt�j�lt� niiden sijainnit
	public void kysyLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilij�", "Risteilij�", "H�vitt�j�", "H�vitt�j�", "H�vitt�j�", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			lauta.tulostaLauta();
			int[][] syote = otaSyote(laivaPituudet[i], laivanNimet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			annaLaivaLista().add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
		
	}
	
	//Pyyt�� ruudun, tarkastaa voiko ruutuun ampua, jos voi niin ampuu
	@SuppressWarnings("resource")
	public void vuoro(Lauta lauta1, Lauta lauta2, Pelaaja pelaaja2) {
		String kohderuutu = "";
		
		lauta2.tulostaPiiloLauta();
		lauta1.tulostaLauta();
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydet��n sy�te
			System.out.println(this.annaNimi() + ": Anna ruutu, johon haluat ampua");
			kohderuutu = scanner.nextLine();
			
			if (kohderuutu.equalsIgnoreCase("tallenna")) {
				Paaluokka.tallenna = true;
				System.out.println("Peli tallennetaan seuraavan siirtosi j�lkeen.");
				continue;
			}
			
			//Tarkastetaan onko sy�te oikean tyyppinen
			if (!apuri.tarkistaSyote(kohderuutu)) {
				System.out.println("V��r�n tyyppinen sy�te. Anna ruutu muodossa 'A0'");
				System.out.println();
			}
			
			//Tarkastetaan onko jo ammuttu t�h�n ruutuun
			else if(lauta2.annaMerkki(apuri.muunnaKoordinaateiksi(kohderuutu)).equals("X")) {
				System.out.println("T�h�n ruutuun on jo ammuttu!");
				System.out.println();
			}
			
			else break;
		}
		
		ammu(apuri.muunnaKoordinaateiksi(kohderuutu), lauta2, pelaaja2);
	}
	
	//Asettaa ruudun merkiksi "X"
	//Tsekkaa osumat ja uponneet ja kommentoi asianmukaisesti
	public void ammu(int[] ruutu, Lauta lauta2, Pelaaja pelaaja2) {
		lauta2.asetaAmmuttuRuutu(ruutu);
		pelaaja2.tarkastaLaivat(ruutu, true);
	}
	
}
