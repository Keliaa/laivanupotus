package test.syotetestit;

import org.laivanupotus.apuluokat.Apu;

import test.Testi;

public class SyotteenTarkistusTesti extends Testi {
	
	Apu apuri = new Apu();

	public void testaaOikeaSyote() {
		String ruutu = "b1";
				
		boolean arvo = apuri.tarkistaSyote(ruutu);

		assert arvo == true : "oikea syöte ei mennyt läpi";

	}
	
	public void testaaVaaraKirjain() {
		String ruutu = "T1";
				
		boolean arvo = apuri.tarkistaSyote(ruutu);

		assert arvo == false : "väärä kirjain meni läpi";

	}
	
	public void testaaVaaraPituus() {
		String ruutu = "a33";
				
		boolean arvo = apuri.tarkistaSyote(ruutu);

		assert arvo == false : "väärä pituus meni läpi";

	}
	
	public void testaaVaarinpain() {
		String ruutu = "5c";
				
		boolean arvo = apuri.tarkistaSyote(ruutu);

		assert arvo == false : "väärin päin meni läpi";

	}
	
	public void testaaKirjaimet() {
		String ruutu = "ga";
				
		boolean arvo = apuri.tarkistaSyote(ruutu);

		assert arvo == false : "Kirjaimet meni läpi";

	}
	
	public void suoritaTestit() {
		testaaOikeaSyote();
		testaaVaaraKirjain();
		testaaVaaraPituus();
		testaaVaarinpain();
		testaaKirjaimet();
	}
}
