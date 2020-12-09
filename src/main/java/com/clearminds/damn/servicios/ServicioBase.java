package com.clearminds.damn.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.damn.bdd.ConexionBDD;
import com.clearminds.damn.excepciones.BDDException;

public class ServicioBase {
	Connection conexion = null;

	public void abrirConexion() throws BDDException {
		conexion = ConexionBDD.obtenerConexion();
	}

	public void cerrarConexion() {

		try {
			if (conexion != null) {
				conexion.close();
				System.out.println("Conexión cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar la conexion");
		}

	}

}
