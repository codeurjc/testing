package es.codeurjc.test.gestor;

import java.util.List;

import es.codeurjc.test.alumno.DBAlumno;

public class GestorNotas {

	private DBAlumno alumnos;
	
	public GestorNotas(DBAlumno alumnos) {
		this.alumnos = alumnos;
	}
	
	public float calculaNotaMedia(long idAlumno) {
		List<Float> notas = alumnos.getNotasAlumno(idAlumno);
		float suma = 0.0f;
		for(float nota : notas) {
			suma += nota;
		}
		return suma / notas.size();
	}
	
}
