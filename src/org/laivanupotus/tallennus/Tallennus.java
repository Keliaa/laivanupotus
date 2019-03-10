package org.laivanupotus.tallennus;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Tallennus {
	
	private static final String filepath=".\\tallennukset\\";
	
	//tallentaa laudan
	public static void tallennaLaudanTila(Lauta lauta, boolean tekoaly) {
		if (tekoaly)
			WriteObjectToFile(lauta, "LautaTeko");
		else
			WriteObjectToFile(lauta, "Lauta");
	}
	
	//tallentaa laivat
	public static void tallennaLaivojenTila(ArrayList<Laiva> laiva, boolean tekoaly) {
		if(tekoaly)
			WriteObjectToFile(laiva, "LaivaTeko");
		else
			WriteObjectToFile(laiva, "Laiva");
	}
	
	/**
	 * Löysin tämmösen netistä :D
	 * Ja muokkasin vähän
	 * @param serObj
	 */
	public static void WriteObjectToFile(Object serObj, String nimi) {
		 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath + nimi);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("Peli tallentui onnistuneesti.");
 
        } catch (Exception ex) {
        	System.out.println("Tallennuksessa meni jokin pieleen.");
            ex.printStackTrace();
        }
    }

}
