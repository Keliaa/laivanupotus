package org.laivanupotus.pelaaja;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.laivanupotus.apuluokat.SyoteApu;
import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;
import org.laivanupotus.pelaaja.tekoaly.Tekoaly;

public class Ihmispelaaja extends Pelaaja {
	private ArrayList<Laiva> laivaLista; 
	
	public Ihmispelaaja(String nimi) {
		super(nimi);
		laivaLista = new ArrayList<Laiva>();
	}

	//Pyytää käyttäjää asettamaan x pituisen laivan laudalle.
	//Tarkistaa onko syöttämät ruudut oikeassa muodossa ja muuntaa ne numerokoordinaateiksi
	//Palauttaa int[][] koordinaatit 
	public int[][] otaSyote(int laivanPituus, String laivanNimi, Lauta lauta) {

		String aloitusruutu = "";
		String lopetusruutu = "";
			
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydetään syöte
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
			
				
			//Tarkastetaan onko syöte oikean tyyppinen
			if (!SyoteApu.tarkistaSyote(aloitusruutu) || !SyoteApu.tarkistaSyote(lopetusruutu)) {
				System.out.println("Väärän tyyppinen syöte. Anna ruudut muodossa 'A0'");
				System.out.println();
			} 
			
			//Tarkastetaan onko syötetty laiva oikean pituinen ja suora
			else if (!SyoteApu.tarkistaPituus(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu), laivanPituus)){
				System.out.println("Väärän pituinen tai epäsuora laiva!");
				System.out.println();
			}
			
			//Tarkaseetaan tulisiko päällekkäisiä/vierekkäisiä laivoja
			else if (!lauta.tarkistaKoordinaatit(SyoteApu.muunnaKoordinaateiksi(aloitusruutu), SyoteApu.muunnaKoordinaateiksi(lopetusruutu))){
				System.out.println("Laivat eivät saa koskettaa toisiaan!");
				System.out.println();
			}
				
			else break;
		}
			
		int[] alkuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(aloitusruutu);
		int[] loppuKoordinaatti = SyoteApu.muunnaKoordinaateiksi(lopetusruutu);
		return new int[][] {alkuKoordinaatti, loppuKoordinaatti};
	}

	public void kysyLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			lauta.tulostaLauta();
			int[][] syote = otaSyote(laivaPituudet[i], laivanNimet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			laivaLista.add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
		
	}
	
	//arpoo laivat
	public void arvoLaivat(Lauta lauta) {
		int[] laivaPituudet = new int[] {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
		String[] laivanNimet = new String[] {"Lentotukialus", "Risteilijä", "Risteilijä", "Hävittäjä", "Hävittäjä", "Hävittäjä", "Sukellusvene", "Sukellusvene", "Sukellusvene", "Sukellusvene"};
		for (int i=0; i<laivaPituudet.length; i++) {
			int[][] syote = arvoSijainnit(laivaPituudet[i], lauta);
			Laiva laiva = new Laiva(laivanNimet[i], laivaPituudet[i], syote[0], syote[1], lauta);
			laivaLista.add(laiva);
			lauta.asetaLaivaLaudalle(laiva);
		}
	}
	
public int[][] arvoSijainnit(int laivanPituus, Lauta l) {
		
		Random rand = new Random();
		
		while(true) {
			int[] a = new int[] {rand.nextInt(10), rand.nextInt(10)};
			int[] b = new int[] {rand.nextInt(10), rand.nextInt(10)};
			
			//Tarkastetaan onko syötetty laiva oikean pituinen ja suora
			if (!SyoteApu.tarkistaPituus(a, b, laivanPituus)){
			}
			
			//Tarkaseetaan tulisiko päällekkäisiä/vierekkäisiä laivoja
			else if (!l.tarkistaKoordinaatit(a, b)){
			}
			
			else{
				return new int[][] {a, b};
			}
		}
	}
	
	//Pyytää ruudun, tarkastaa voiko ruutuun ampua, jos voi niin ampuu
	public void vuoro(Lauta lauta, Lauta tekoLauta, Tekoaly tekoaly) {
		String kohderuutu = "";
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			//Pyydetään syöte
			System.out.println("Anna ruutu, johon haluat ampua");
			kohderuutu = scanner.nextLine();
			
			//Tarkastetaan onko syöte oikean tyyppinen
			if (!SyoteApu.tarkistaSyote(kohderuutu)) {
				System.out.println("Väärän tyyppinen syöte. Anna ruutu muodossa 'A0'");
				System.out.println();
			}
			
			//Tarkastetaan onko jo ammuttu tähän ruutuun
			else if(tekoLauta.annaMerkki(SyoteApu.muunnaKoordinaateiksi(kohderuutu)).equals("X")) {
				System.out.println("Tähän ruutuun on jo ammuttu!");
				System.out.println();
			}
			
			else break;
		}
		
		ammu(SyoteApu.muunnaKoordinaateiksi(kohderuutu), tekoLauta, tekoaly);
	}
	
	//Asettaa ruudun merkiksi "X"
	//Tsekkaa osumat ja uponneet ja kommentoi asianmukaisesti
	public void ammu(int[] ruutu, Lauta tekoLauta, Tekoaly tekoaly) {
		tekoLauta.asetaAmmuttuRuutu(ruutu);
		tekoaly.tarkastaLaivat(ruutu);
	}
	
	//Tarkastaa osuiko tekoäly yhteenkään laivaan. Jos osui, asetetaan laivaan osuma
	public void tarkastaLaivat(int[] ruutu) {
		for (Laiva l : laivaLista) {
			l.tarkastaOsuma(ruutu);
		}
	}
	
}
