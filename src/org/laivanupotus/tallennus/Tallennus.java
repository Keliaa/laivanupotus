package org.laivanupotus.tallennus;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Tallennus {
	
	private final String filepath=".\\tallennukset\\";
	
	//tallentaa laudan
    //eri polut riippuen onko teko�ly vai ei
	public void tallennaLaudanTila(Lauta lauta, boolean tekoaly) {
		if (tekoaly)
			WriteObjectToFile(lauta, "LautaTeko");
		else
			WriteObjectToFile(lauta, "Lauta");
	}
	
	//tallentaa laivat
    //eri polut riippuen onko teko�ly vai ei
	public void tallennaLaivojenTila(ArrayList<Laiva> laiva, boolean tekoaly) {
		if(tekoaly)
			WriteObjectToFile(laiva, "LaivaTeko");
		else
			WriteObjectToFile(laiva, "Laiva");
	}
	
	/**
	 * L�ysin t�mm�sen netist� :D
	 * Ja muokkasin v�h�n
	 * @param serObj
	 */
	public void WriteObjectToFile(Object serObj, String nimi) {
		 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath + nimi);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("Peli tallentui onnistuneesti kansioon: " + filepath + nimi);
 
        } catch (Exception ex) {
        	System.out.println("Tallennuksessa meni jokin pieleen.");
            ex.printStackTrace();
        }
    }

}
