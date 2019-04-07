package test.syotetestit;

import org.laivanupotus.apuluokat.Apu;

import test.Testi;

public class PituusTarkistusTesti extends Testi{
	Apu apuri = new Apu();
	
	public void testaaOikeaPituus() {
		int pituus = 4;
		int[] alku = new int[] {1,4};	
		int[] loppu = new int[] {4,4};		
		boolean arvo = apuri.tarkistaPituus(alku, loppu, pituus);

		assert arvo == true : "Oikea Pituus ei l‰pi";

	}
	
	public void testaaOikeaPituusPysty() {
		int pituus = 3;
		int[] alku = new int[] {2,8};	
		int[] loppu = new int[] {2,6};		
		boolean arvo = apuri.tarkistaPituus(alku, loppu, pituus);

		assert arvo == true : "Oikea Pituus ei l‰pi";

	}
	
	public void testaaVaaraPituus() {
		int pituus = 4;
		int[] alku = new int[] {2,8};	
		int[] loppu = new int[] {2,6};		
		boolean arvo = apuri.tarkistaPituus(alku, loppu, pituus);

		assert arvo == false : "V‰‰r‰ pituus l‰pi";

	}
	
	public void testaaVino() {
		int pituus = 2;
		int[] alku = new int[] {2,2};	
		int[] loppu = new int[] {3,3};		
		boolean arvo = apuri.tarkistaPituus(alku, loppu, pituus);

		assert arvo == false : "Vino l‰pi";

	}
	
	public void suoritaTestit() {
		testaaOikeaPituus();
		testaaOikeaPituusPysty();
		testaaVaaraPituus();
		testaaVino();
	}
}
