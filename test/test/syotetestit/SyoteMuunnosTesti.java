package test.syotetestit;

import org.laivanupotus.apuluokat.SyoteApu;

import test.Testi;

public class SyoteMuunnosTesti extends Testi{
	public void testaaMuunnos() {
		String ruutu = "A0";
				
		int[] arvo = SyoteApu.muunnaKoordinaateiksi(ruutu);
		int[] odotettu = new int[] {0, 0};

		assert java.util.Arrays.equals(arvo, odotettu) : "Muunnos epäonnistui";

	}
	
	public void testaaMuunnos2() {
		String ruutu = "d6";
				
		int[] arvo = SyoteApu.muunnaKoordinaateiksi(ruutu);
		int[] odotettu = new int[] {3, 6};

		assert java.util.Arrays.equals(arvo, odotettu) : "Muunnos epäonnistui";

	}
	
	public void suoritaTestit() {
		testaaMuunnos();
		testaaMuunnos2();
	}
}
