public class Lauta {
	private String lauta[][];
	
	
/*
 * tehd‰‰n uusi 10x10 lauta ja t‰ytet‰‰n se merell‰
*/
	public Lauta() {
		this.lauta = new String[10][10];
	
		for(int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				lauta[i][j]="~";
			}			
		}
	}

/*
 * asetetaan laiva annettuihin koordinaatteihin ja tarkistetaan
 */
	
	public void asetaLaiva(int[] mista, int[] mihin) {
		
		for(int i = mista[0]; i<= mihin[0]; i++) {
			for(int j = mista[1]; i<= mihin[1]; j++) {
				lauta[i][j] = "O";
			}
		}
	}
	
	/*
	 * tarkastaa annetut koordinaatit ja niiden ymp‰ristˆn laivojen varalta 
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
	 * tulostaa laudan sen nykyisess‰ tilassa
	 */
	public void tulostaLauta() {
		String[] taul = {"A","B","C","D","E","F","G","H","I","J"};
		System.out.println(" "+"|"  + '0' +"|" + '1' + "|"+ '2' + "|"+ '3' + "|"+ '4' + "|"+ '5' + "|"+ '6' + "|"+ '7' + "|"+ '8' + "|"+ '9' + "|");
		for(int i=0; i<10; i++) {
				System.out.println(taul[i]+"|" + lauta[i][0]+"|" +lauta[i][1]+"|" +lauta[i][2]+"|" +lauta[i][3]+"|" +lauta[i][4]+"|" +lauta[i][5]+"|" +lauta[i][6]+"|" +lauta[i][7]+"|" +lauta[i][8]+"|" +lauta[i][9]+"|");
				
		}
	}
}

		
		
		
