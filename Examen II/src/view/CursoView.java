package view;


public class CursoView {

	private int numeroCurso;
	private String materia;
	private String dia; 
	private String turno;
	
	public CursoView(int numeroCurso, String materia, String dia, String turno) {
		super();
		this.numeroCurso = numeroCurso;
		this.materia = materia;
		this.dia = dia;
		this.turno = turno;
	}
	
	public int getNumeroCurso() {
		return numeroCurso;
	}
	public String getMateria() {
		return materia;
	}
	
	public String getDia() {
		return dia;
	}
	
	public String getTurno() {
		return turno;
	}

	@Override
	public String toString()
	{
		return this.numeroCurso + " - " + this.materia + " - " + this.dia + " - " + this.turno;
	}
}
