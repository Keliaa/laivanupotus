package org.laivanupotus.logiikka;

public class Laiva {
	protected final int pituus;
	protected final String nimi;
	private int[] mista = new int[2];
	private int[] mihin = new int[2];
	private String[] koordinaatit;
	
	/*
	 * konstruktori
	 */
	public Laiva(String nimi, int pituus, int mista[], int mihin[]) {
		this.pituus=pituus;
		this.nimi=nimi;	
		this.mista = mista;
		this.mihin = mihin;
		koordinaatit= new String[pituus];
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
	 * metodi tallentaa koordinaatit[String]-listaan kaikki laivan koordinaatit Stringinä muodossa 34 (eka vaakarivi ja toka pystyrivi)
	 */
	
	public void laivanKaikkiKoordinaatit() {
		int a=0;
		if(mihin[0]>mista[0]) {//jos laiva on pystysuorassa (eli A3 ja A:n arvo muuttuu)
			int b= mista[1];
			for(int i=0; i<mihin[0]-mista[0];i ++) {
				a=mista[0]+i;
				koordinaatit[i]= a +""+ b;
			}
		}
		if(mihin[1]>mista[1]) { //Jos laiva on vaakasuorassa(eli 3A ja A:n arvo muuttuu)

			int c= mista[0];
			for(int i=0; i<=mihin[1]-mista[1];i++) {
				a=mista[1]+i;
				koordinaatit[i]= c+""+a;
			}
		}
	}
	
	/*
	 * metodi vertaa ammuttua koordinaattia laivan koordinaatteihin
	 * @return true, jos osuu
	 * @return false muuten
	 */
	public boolean tarkastaOsuma(String ammuttuRuutu) {
		for(int i=0; i<koordinaatit.length; i++) {
			if(koordinaatit[i].equals(ammuttuRuutu)) {
				koordinaatit[i]="-1";
				System.out.println("Osuma!");
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
			if(koordinaatit[i].equals("-1")) {
				continue;
			}else {
				kuolema = false;
				break;
			}
		}
		return kuolema;
	}
	
	
	
}
