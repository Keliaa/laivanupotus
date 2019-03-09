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
			if(laiva.annaMihin()[0]>laiva.annaMista()[0]) {
				int a=laiva.annaMista()[1];
				for(int i = laiva.annaMista()[0]; i<=laiva.annaMihin()[0]; i++) {
					lauta[i][a]="O";
				}
			}
			if(laiva.annaMihin()[1]>laiva.annaMista()[1]) {
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
		for(int i = mista[0]-1; i<= mihin[0]+1; i++) {
	        if(onkoLaiva==false) {
	        	break;
	        }
			if(mista[0]-1 >= 0 && mihin[0]+1 <= lauta.length-1){
                for(int j = mista[1]-1; j<= mihin[1]+1; j++) {                	
                
                    if(mista[1]-1 >= 0 && mihin[1]+1 <= lauta[0].length-1) {

                    	if(lauta[i][j].equals("~")) {
                            onkoLaiva=true;
                        }
                    	if(lauta[i][j].equals("O") || lauta[i][j].equals("X")) {
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
	}
}

		
		
		
