package com.clearminds.damn.bdd.test;

import com.clearminds.dam.dtos.Estudiante;
import com.clearminds.damn.excepciones.BDDException;
import com.clearminds.damn.servicios.ServicioEstudiante;

public class TestServicio {
	public static void main(String[] args) {
		ServicioEstudiante srvEstudinate = new ServicioEstudiante();
		try {
			srvEstudinate.insertarEstudiante(new Estudiante("Danny", "Martinez"));
			srvEstudinate.insertarEstudiante(new Estudiante("Alexander", "Narvaez"));
		} catch (BDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}
}
