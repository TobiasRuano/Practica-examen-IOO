package negocio;

import java.util.ArrayList;
import java.util.List;

public class Inscripto {

	private Alumno alumno;
	private boolean becado;
	private List<Examen> examenes;
	
	public Inscripto(Alumno alumno, boolean becado) {
		this.alumno = alumno;
		this.becado = becado;
		this.examenes = new ArrayList<Examen>();
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public boolean isBecado() {
		return becado;
	}

	public List<Examen> getExamenes() {
		return examenes;
	}
	
	public void agregarExamen(String tipo, int nota)
	{
		examenes.add(new Examen(tipo, nota));
	}
	
	public boolean estaAprobado(int legajo)
	{
		if(alumno.soyElAlumno(legajo))
			for(Examen e : examenes)
				if(e.apruebaMateria())
					return true;
		return false;
	}
}