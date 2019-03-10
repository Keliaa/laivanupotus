package test;

import test.syotetestit.SyoteMuunnosTesti;
import test.syotetestit.SyotteenTarkistusTesti;

//import testi

public class TestinSuorittaja{

	// kun ohjelmoit uusia testiluokkia, lis‰‰ ne t‰h‰n.
	static Testi[] testit = { new SyotteenTarkistusTesti(), new SyoteMuunnosTesti()};

	/*
	 * Huom! T‰m‰ ohjelma on suoritettava antamalla virtuaalikoneelle seuraava vipu:
	 * -ea tai -enableassertions
	 * 
	 */
	public static void main(String[] args) {
		suoritaKaikkiTestit();
	}

	/**
	 * Suorittaa kaikki testit, jotka on m‰‰ritelty taulukossa "testit"
	 */
	public static void suoritaKaikkiTestit() {

		for (Testi t : testit) {
			String testinNimi = t.getClass().getSimpleName();
			System.out.println("Suoritetaan: " + testinNimi);

			t.suoritaTestit();

		}
		System.out.println("Kaikki testit suoritettu onnistuneesti!");
	}
}