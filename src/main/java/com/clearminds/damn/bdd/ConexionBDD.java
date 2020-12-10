package com.clearminds.damn.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.clearminds.damn.excepciones.BDDException;

public class ConexionBDD {

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static String leerPropiedad(String nombrePropiedad) {
		Properties p = new Properties();
		try {
			File f = new File("conexion.properties");
			System.out.println("ruta:" + f.getAbsoluteFile());

			p.load(new FileReader("conexion.properties"));
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

	public static Connection obtenerConexion() throws BDDException {
		String user = leerPropiedad("usuario");
		String pass = leerPropiedad("password");
		String url = leerPropiedad("urlConexion");
		Connection conn = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la base de datos");
		}

		return conn;
	}

}
