package com.clearminds.damn.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConexionBDD {

	
	public static String leerPropiedad(String nombrePropiedad){
		Properties p = new Properties();		
		try {
			p.load(new FileReader("./conexion.properties"));
			return p.getProperty(nombrePropiedad);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			System.out.println("No se encontro el archivo");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problemas al leer el archivo");
			return null;
		}
	}
	
}
