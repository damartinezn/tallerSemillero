package com.clearminds.damn.bdd.test;

import com.clearminds.dam.dtos.Estudiante;
import com.clearminds.damn.excepciones.BDDException;
import com.clearminds.damn.servicios.ServicioEstudiante;

public class TestActualizar {
	public static void main(String[] args) {
		ServicioEstudiante srvEstudinate = new ServicioEstudiante();
		try {
			srvEstudinate.actualizarEstudiante(new Estudiante(3,"Danny A", "Martinez N"));			
		} catch (BDDException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}
