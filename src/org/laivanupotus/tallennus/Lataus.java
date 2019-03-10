package org.laivanupotus.tallennus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.laivanupotus.logiikka.Laiva;
import org.laivanupotus.logiikka.Lauta;

public class Lataus {
	
	private static final String filepath=".\\tallennukset\\";
	 
    public static Lauta lataaLaudanTila(boolean tekoaly) {
 
    	Lataus lataus = new Lataus();
    	Lauta lauta = null;
        //Lukee tiedon
    	if (tekoaly)
    		lauta = (Lauta) lataus.ReadObjectFromFile(filepath+ "LautaTeko");
    	else
    		lauta = (Lauta) lataus.ReadObjectFromFile(filepath+ "Lauta");
        return lauta;
    }
    
    public static ArrayList<Laiva> lataaLaivojenTila(boolean tekoaly) {
    	 
    	Lataus lataus = new Lataus();
    	ArrayList<Laiva> laiva = null;
        //Lukee tiedon
    	if (tekoaly)
    		laiva = (ArrayList<Laiva>) lataus.ReadObjectFromFile(filepath+ "LaivaTeko");
    	else
    		laiva = (ArrayList<Laiva>) lataus.ReadObjectFromFile(filepath+ "Laiva");
        return laiva;
    }
 
    /**
     * netistä tämäkin :D
     * @param filepath
     * @return
     */
    public Object ReadObjectFromFile(String filepath) {
 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("Lataus onnistui kansioon: " + filepath);
            objectIn.close();
            return obj;
 
        } catch (FileNotFoundException ex) {
        	System.out.println("Tallennuksia ei löydetty.");
        	System.exit(-1);
            return null;
        } catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
            return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
            return null;
		}
    }

}
