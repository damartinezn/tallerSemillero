package com.clearminds.damn.servicios;


import com.clearminds.dam.dtos.Estudiante;
import com.clearminds.damn.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("insertando estudiante :" + estudiante);
		cerrarConexion();
	}
}
