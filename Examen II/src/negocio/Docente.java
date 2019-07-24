package negocio;

import java.util.ArrayList;
import java.util.List;

import view.DocenteView;

public class Docente {

	private static int numerador;
	private int numero;
	private String nombre;
	private List<Curso> cursos;
	
	public Docente(String nombre) {
		this.nombre = nombre;
		numerador++;
		this.numero = numerador;
		cursos = new ArrayList<Curso>();
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void agregarCurso(Curso curso)
	{
		cursos.add(curso);
	}
	
	public float calcularSalario() {
		float salario = 0.0f;
		for(Curso curso : cursos)
			salario += curso.getRemuneracion();
		return salario;
	}
	
	public DocenteView toView()
	{
		return new DocenteView(numero, nombre);
	}

	public boolean soyElDocente(int numero) {
		return this.numero == numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
