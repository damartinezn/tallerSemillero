package com.clearminds.damn.servicios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.clearminds.dam.dtos.Estudiante;
import com.clearminds.damn.excepciones.BDDException;
import com.clearminds.damn.util.DateUtil;

public class ServicioEstudiante extends ServicioBase {
	
	private static final Date FECHA_ACTUAL = new Date();

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("insertando estudiante :" + estudiante);
		Statement stmt = null;
		
		try {
			stmt = getConexion().createStatement();
			String sql = "";			
			sql = "insert into estudiantes(nombre,apellido,edad,fecha_modificacion ) values('" + estudiante.getNombre() + "','"
					+ estudiante.getApellido() + "'," + ((estudiante.getEdad() > 0)? estudiante.getEdad():null) + ",'"+DateUtil.convertirFecha(FECHA_ACTUAL)+"')";

			System.out.println("Script : " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}

	}

	public void actualizarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("actualizando estudiante :" + estudiante);
		Statement stmt = null;
		
		try {
			stmt = getConexion().createStatement();
			String sql = "update estudiantes set  nombre = '" + estudiante.getNombre() + "', apellido = '"
					+ estudiante.getApellido() + "', edad = "+ ((estudiante.getEdad() > 0)? estudiante.getEdad():null)+", fecha_modificacion  = '"+DateUtil.convertirFecha(FECHA_ACTUAL)+"' where id = " + estudiante.getId();
			System.out.println("Script : " + sql);
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar estudiante");
		}

	}
}
