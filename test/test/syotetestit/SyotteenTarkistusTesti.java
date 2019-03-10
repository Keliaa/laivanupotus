package test.syotetestit;

import org.laivanupotus.apuluokat.SyoteApu;

import test.Testi;

public class SyotteenTarkistusTesti extends Testi {

	public void testaaOikeaSyote() {
		String ruutu = "b1";
				
		boolean arvo = SyoteApu.tarkistaSyote(ruutu);

		assert arvo == true : "oikea syˆte ei mennyt l‰pi";

	}
	
	public void testaaVaaraKirjain() {
		String ruutu = "T1";
				
		boolean arvo = SyoteApu.tarkistaSyote(ruutu);

		assert arvo == false : "v‰‰r‰ kirjain meni l‰pi";

	}
	
	public void testaaVaaraPituus() {
		String ruutu = "a33";
				
		boolean arvo = SyoteApu.tarkistaSyote(ruutu);

		assert arvo == false : "v‰‰r‰ pituus meni l‰pi";

	}
	
	public void testaaVaarinpain() {
		String ruutu = "5c";
				
		boolean arvo = SyoteApu.tarkistaSyote(ruutu);

		assert arvo == false : "v‰‰rin p‰in meni l‰pi";

	}
	
	public void testaaKirjaimet() {
		String ruutu = "ga";
				
		boolean arvo = SyoteApu.tarkistaSyote(ruutu);

		assert arvo == false : "Kirjaimet meni l‰pi";

	}
	
	public void suoritaTestit() {
		testaaOikeaSyote();
		testaaVaaraKirjain();
		testaaVaaraPituus();
		testaaVaarinpain();
		testaaKirjaimet();
	}
}
