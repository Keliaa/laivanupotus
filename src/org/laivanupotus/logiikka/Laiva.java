package org.laivanupotus.logiikka;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Laiva implements Serializable {
	protected final int pituus;
	protected final String nimi;
	private int[] mista = new int[2];
	private int[] mihin = new int[2];
	private int[][] koordinaatit;
	/*
	 * konstruktori
	 */
	public Laiva(String nimi, int pituus, int mista[], int mihin[], Lauta lauta) {
		this.pituus=pituus;
		this.nimi=nimi;	
		this.mista = mista;
		this.mihin = mihin;
		this.koordinaatit = laivanKaikkiKoordinaatit(mista, mihin, pituus);
		
		
	}

	/*
	 * getterit ja setterit
	 */
	
	public int[] annaMista() {
		return mista;
	}

	public void asetaMista(int[] mista) {
		this.mista = mista;
	}

	public int[] annaMihin() {
		return mihin;
	}

	public void asetaMihin(int[] mihin) {
		this.mihin = mihin;
	}

	public int annaPituus() {
		return pituus;
	}

	public String annaNimi() {

		return nimi;
	}
	
	/*
	 * metodi tallentaa int[][] matriisiin 'koordinaatit'  kaikki laivan koordinaatit 
	 */
	public int[][] laivanKaikkiKoordinaatit(int[] mista, int[] mihin, int pituus) {
		int[][] palautus = new int[pituus][2];
		
		if (mista[0] == mihin[0]) {
			if (mista[1] < mihin[1]) {
				for (int i = 0; i<=mihin[1] - mista[1]; i++) {
					palautus[i][1] = mista[1] + i;
					palautus[i][0] = mista[0];
				}
			}
			else {
				for (int i = 0; i<=mista[1] - mihin[1]; i++) {
					palautus[i][1] = mihin[1] + i;
					palautus[i][0] = mista[0];
				}
			}
		}
		
		else if (mista[1] == mihin[1]) {
			if (mista[0] < mihin[0]) {
				for (int i = 0; i<=mihin[0] - mista[0]; i++) {
					palautus[i][0] = mista[0] + i;
					palautus[i][1] = mista[1];
				}
			}
			else {
				for (int i = 0; i<=mista[0] - mihin[0]; i++) {
					palautus[i][0] = mihin[0] + i;
					palautus[i][1] = mista[1];
				}
			}
		}
		return palautus;
	}
	
	
	
	/*
	 * metodi vertaa ammuttua koordinaattia laivan koordinaatteihin
	 * asettaa osutut koordinaatit -1, jos osuu
	 * @return true, jos osuu
	 * @return false muuten
	 */
	public boolean tarkastaOsuma(int[] ammuttuRuutu) {
		for(int i=0; i<koordinaatit.length; i++) {
			if(koordinaatit[i][0] == ammuttuRuutu[0] && koordinaatit[i][1] == ammuttuRuutu[1]) {
				koordinaatit[i][0]=-1;
				koordinaatit[i][1]=-1;
				return true;
			}
		}
		return false;
	}
		
	/*
	 * tarkastaa onko laivan kaikkiin ruutuihin osunut, jos on, laiva pois pelistä
	 * @return true, jos laivan kaikkiin koordinaatteihin ammuttu ja laiva uppoaa eli koordinaatit[]-listassa kaikki alkiot "-1"
	 * @return false muuten
	 */
	public boolean onkoLaivaUponnut() {
		boolean kuolema=true;
		for(int i=0; i<koordinaatit.length; i++) {
			if(koordinaatit[i][0] == -1) {
				continue;
			}
			
			else {
				kuolema = false;
				break;
			}
		}
		return kuolema;
	}
	
	
	
}
