package negocio;

import view.AlumnoView;

public class Alumno {

	private static int numerador;
	private int legajo;
	private String nombre;
	
	public Alumno(String nombre) {
		numerador++;
		legajo = numerador;
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public AlumnoView toView()
	{
		return new AlumnoView(legajo, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (legajo != other.legajo)
			return false;
		return true;
	}

	public boolean soyElAlumno(int legajo) {
		return this.legajo == legajo;
	}
}
