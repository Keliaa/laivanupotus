package test.syotetestit;

import org.laivanupotus.apuluokat.Apu;

import test.Testi;

public class SyoteMuunnosTesti extends Testi{
	Apu apuri = new Apu();
	
	public void testaaMuunnos() {
		String ruutu = "A0";
				
		int[] arvo = apuri.muunnaKoordinaateiksi(ruutu);
		int[] odotettu = new int[] {0, 0};

		assert java.util.Arrays.equals(arvo, odotettu) : "Muunnos epäonnistui";

	}
	
	public void testaaMuunnos2() {
		String ruutu = "d6";
				
		int[] arvo = apuri.muunnaKoordinaateiksi(ruutu);
		int[] odotettu = new int[] {3, 6};

		assert java.util.Arrays.equals(arvo, odotettu) : "Muunnos epäonnistui";

	}
	
	public void suoritaTestit() {
		testaaMuunnos();
		testaaMuunnos2();
	}
}
