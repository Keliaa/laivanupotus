package org.laivanupotus.logiikka;

public class Lauta {
	private String lauta[][];
	
	
/*
 * tehdään uusi 10x10 lauta ja täytetään se merellä "~"
*/
	public Lauta() {
		lauta = new String[10][10];
	
		for(int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				lauta[i][j]="~";
			}			
		}
	}

/*
 * asetetaan laiva annettuihin koordinaatteihin jos tarkistus metodissa tarkistaKoordinaaitit() onnistuu
 */
	
	public void asetaLaivaLaudalle(int[] mista, int[] mihin) {
		if(tarkistaKoordinaatit(mista, mihin)) {
			if(mihin[0]>mista[0]) {
				int a=mista[1];
				for(int i = mista[0]; i<=mihin[0]; i++) {
					lauta[i][a]="O";
				}
			}
			if(mihin[1]>mista[1]) {
				int a=mista[0];
				for(int i = mista[1]; i<=mihin[1]; i++) {
					lauta[a][i]="O";
				}
			}	
		}
	}
	
	public void asetaLaivaLaudalle(Laiva laiva) {
		if(tarkistaKoordinaatit(laiva.annaMista(), laiva.annaMihin())) {
			if(laiva.annaMihin()[0]<laiva.annaMista()[0] || laiva.annaMihin()[1]<laiva.annaMista()[1]) {
				int x = laiva.annaMihin()[0];
				laiva.annaMihin()[0] = laiva.annaMista()[0];
				laiva.annaMista()[0] = x;
				x = laiva.annaMihin()[1];
				laiva.annaMihin()[1] = laiva.annaMista()[1];
				laiva.annaMista()[1] = x;
			}
			
			if(laiva.annaMihin()[1]==laiva.annaMista()[1]) {
				int a=laiva.annaMista()[1];
				for(int i = laiva.annaMista()[0]; i<=laiva.annaMihin()[0]; i++) {
					lauta[i][a]="O";
				}
			}
			if(laiva.annaMihin()[0]==laiva.annaMista()[0]) {
				int a=laiva.annaMista()[0];
				for(int i = laiva.annaMista()[1]; i<=laiva.annaMihin()[1]; i++) {
					lauta[a][i]="O";
				}
			}	
		}
	}
	
	/*
	 * muuttaa laudan ruudun kohdalle merkin "X"
	 */
	public void asetaAmmuttuRuutu(int[] ruutu) {
		lauta[ruutu[0]][ruutu[1]]="X";
	}
	
	/*
	 * tarkastaa annetut koordinaatit ja niiden ympäristön laivojen varalta 
	 * @return true, jos ei ole entuudestaan laivoja 
	 * @return false muuten
	 */
	public boolean tarkistaKoordinaatit(int[] mista, int[] mihin) {
		boolean onkoLaiva = true;
		
		if(mihin[0]<mista[0] || mihin[1]<mista[1]) {
			int x = mihin[0];
			mihin[0] = mista[0];
			mista[0] = x;
			x = mihin[1];
			mihin[1] = mista[1];
			mista[1] = x;
		}
		
		for(int i = mista[0]-1; i<= mihin[0]+1; i++) {
	        if(onkoLaiva==false) {
	        	break;
	        }
			if(i >= 0 && i <= lauta.length-1){
                for(int j = mista[1]-1; j<= mihin[1]+1; j++) {
                    if(j >= 0 && j <= lauta[0].length-1) {
                    	if(this.lauta[i][j].equals("O") || this.lauta[i][j].equals("X")) {
                            onkoLaiva=false;
                            break;                           
                        }
                    }
                }
            }
        }
		return onkoLaiva;
	}
	
	/*
	 * tulostaa laudan sen nykyisessä tilassa
	 */
	public void tulostaLauta() {
		String[] taul = {"A","B","C","D","E","F","G","H","I","J"};
		System.out.println(" "+"|"  + '0' +"|" + '1' + "|"+ '2' + "|"+ '3' + "|"+ '4' + "|"+ '5' + "|"+ '6' + "|"+ '7' + "|"+ '8' + "|"+ '9' + "|");
		for(int i=0; i<10; i++) {
				System.out.println(taul[i]+"|" + lauta[i][0]+"|" +lauta[i][1]+"|" +lauta[i][2]+"|" +lauta[i][3]+"|" +lauta[i][4]+"|" +lauta[i][5]+"|" +lauta[i][6]+"|" +lauta[i][7]+"|" +lauta[i][8]+"|" +lauta[i][9]+"|");
				
		}
		System.out.println();
	}
	
	/*
	 * tulostaa laudan ilman laivoja
	 */
	public void tulostaPiiloLauta() {
		String[][] piiloLauta = new String[10][10]; //tekee piilolaudan, ja poistaa siitä laivat
		for	(int i = 0; i<lauta.length; i++) {
			for (int j = 0; j<lauta[0].length; j++) {
				piiloLauta[i][j] = lauta[i][j];
				if(lauta[i][j].equals("O")) {
					piiloLauta[i][j] = "~";
				}
			}
		}
		
		String[] taul = {"A","B","C","D","E","F","G","H","I","J"};	//tulostaa piilolaudan
		System.out.println(" "+"|"  + '0' +"|" + '1' + "|"+ '2' + "|"+ '3' + "|"+ '4' + "|"+ '5' + "|"+ '6' + "|"+ '7' + "|"+ '8' + "|"+ '9' + "|");
		for(int i=0; i<10; i++) {
				System.out.println(taul[i]+"|" + piiloLauta[i][0]+"|" + piiloLauta[i][1]+"|" + piiloLauta[i][2]+"|" + piiloLauta[i][3]+"|" + piiloLauta[i][4]+"|" + piiloLauta[i][5]+"|" + piiloLauta[i][6]+"|" + piiloLauta[i][7]+"|" + piiloLauta[i][8]+"|" + piiloLauta[i][9]+"|");
		}
		System.out.println();
	}
	
	//Palauttaa merkin koordinaattien kohdasta
	public String annaMerkki(int[] a) {
		return lauta[a[0]][a[1]];
	}
	
	
	//Tarkastaa onko laudan pelaaja hävinnyt pelin
	public boolean onkoHavinnyt() {
		boolean havitty = true;
		for (int i=0; i<lauta.length; i++) {
			for (int j=0; j<lauta.length; j++) {
				if (lauta[i][j] == "O")
					havitty = false;
			}
		}
		return havitty;
	}
}

		
		
		
