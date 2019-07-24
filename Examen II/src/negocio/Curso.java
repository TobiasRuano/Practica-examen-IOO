package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import view.CursoView;

public class Curso {
	
	private static int numerador;
	private int numeroCurso;
	private Materia materia;
	private Docente docente;
	private int cantidadMaxima;
	private String dia; 
	private String turno;
	private Date fechaInicio;
	private Date fechaFin;
	private List<Inscripto> alumnos;

	/**
	 * @param materia
	 * @param docente
	 * @param cantidadMaxima 
	 * 		maxima cantidad de alumnos que puede tener ese curso. Cuando se alcanza ese valor no se puede inscribir mas alumnos.
	 * @param dia 
	 * 		dia de las semana que se cursa. Puede ser Lunes, Martes, Miercoles, Jueves, Viernes
	 * @param turno
	 * 		horario en que se cursa. Puede ser Mañana, Tarde o Noche
	 * @param fechaInicio
	 * @param fechaFin  
	 * */
	public Curso(Materia materia, Docente docente, int cantidadMaxima, String dia, String turno, Date fechaInicio, Date fechaFin) 
	{
		numerador++;
		this.numeroCurso = numerador;
		this.materia = materia;
		this.docente = docente;
		this.cantidadMaxima = cantidadMaxima;
		this.dia = dia;
		this.turno = turno;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		alumnos = new ArrayList<Inscripto>();
		docente.agregarCurso(this);
	}

	public int getNumeroCurso() {
		return numeroCurso;
	}

	public Materia getMateria() {
		return materia;
	}

	public Docente getDocente() {
		return docente;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public String getDia() {
		return dia;
	}

	public String getTurno() {
		return turno;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public List<Inscripto> getAlumnos()
	{
		return alumnos;
	}
	
	public boolean aproboCurso(int legajo)
	{
		for(Inscripto i : alumnos)
			if(i.estaAprobado(legajo))
				return true;
		return false;
	}
	
	public void agregarAlumno(Alumno alumno, boolean becado)
	{
		this.alumnos.add(new Inscripto(alumno, becado));
	}
	
	public boolean tieneVacantes()
	{
		return cantidadMaxima > alumnos.size();
	}

	public float getRemuneracion() {
		return materia.getImporte() * this.cantidadAlumnosSinBeca();
	}
	
	private float cantidadAlumnosSinBeca() {
		float cantidad = 0.0f;
		for(Inscripto i : alumnos)
			if(!i.isBecado())
				cantidad++;
		return cantidad;
	}

	public boolean soyElCurso(int numeroCurso) {
		return this.numeroCurso == numeroCurso;
	}
	
	public CursoView toView()
	{
		return new CursoView(this.numeroCurso, materia.getNombre(), this.dia, this.turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (numeroCurso != other.numeroCurso)
			return false;
		return true;
	}
}
