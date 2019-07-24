package view;

import java.util.Iterator;

public class AlumnoView {

	private int legajo;
	private String nombre;
	
	public AlumnoView(int legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString()
	{
		return this.legajo + " - " + this.nombre;
	}
}
