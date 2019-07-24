package controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import negocio.Alumno;
import negocio.Curso;
import negocio.Docente;
import negocio.Materia;
import view.AlumnoView;
import view.CursoView;
import view.DocenteView;
import view.MateriaView;

public class Controlador {

	private static Controlador instancia;
	public static final int CANTIDAD_MAXIMA = 40;
	private List<Alumno> alumnos;
	private List<Curso> cursos;
	private List<Docente> docentes;
	private List<Materia> materias;
	private Date inicioClase, finalizacionClase;
	
	private Controlador()
	{
		alumnos = new ArrayList<Alumno>();
		cursos = new ArrayList<Curso>();
		docentes = new ArrayList<Docente>();
		materias = new ArrayList<Materia>();
		Calendar calendar = new GregorianCalendar(2016,3,01,0,0,0);
		inicioClase = calendar.getTime();
		calendar = new GregorianCalendar(2016,6,30,0,0,0);
		finalizacionClase = calendar.getTime();
		cargoDatos();
	}
	
	public static Controlador getInstancia()
	{
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void crearCurso(int numero, String codigo, String dia, String turno)
	{
		Materia materia = buscarMateria(codigo);
		if(materia != null){
			Docente docente = buscarDocente(numero);
			if(docente != null){
				Curso curso = new Curso(materia, docente, Controlador.CANTIDAD_MAXIMA, dia, turno, inicioClase, finalizacionClase); 
				cursos.add(curso);
				System.out.println("Curso creado");
			}
			else
				System.out.println("No existe el docente con n�mero " + numero);
		}
		else
			System.out.println("No existe la materia con c�digo " + codigo);
	}
	
	public void asignarAlumnoCurso(int numeroCurso, int legajo, boolean becado)
	{
		Curso curso = buscarCurso(numeroCurso);
		Alumno alumno = buscarAlumno(legajo);
		curso.agregarAlumno(alumno, becado);
		System.out.print("Alumno agregado");
	}

	public List<MateriaView> aprobadas(int legajo)
	{
		List<MateriaView> aprobadas = new ArrayList<MateriaView>();
		for(Curso c : cursos)
			if(c.aproboCurso(legajo))
				aprobadas.add(c.getMateria().toView());
		return aprobadas;
	}
	
	public float calculoSalario(int numero)
	{
		Docente docente = this.buscarDocente(numero);
		return docente.calcularSalario();
	}
	
	private Docente buscarDocente(int numero) {
		for(Docente d : docentes)
			if(d.soyElDocente(numero))
				return d;
		return null;
	}

	private Materia buscarMateria(String codigo) {
		for(Materia m : materias)
			if(m.soyLaMateria(codigo))
				return m;
		return null;
	}

	private Curso buscarCurso(int numeroCurso)
	{
		for(Curso c : cursos)
			if(c.soyElCurso(numeroCurso))
				return c;
		return null;
	}
	
	private Alumno buscarAlumno(int legajo)
	{
		for(Alumno a : alumnos)
			if(a.soyElAlumno(legajo))
				return a;
		return null;
	}
		
 	public List<DocenteView> docentesToView()
	{
		List<DocenteView> dv = new ArrayList<DocenteView>();
		for(Docente d : docentes)
			dv.add(d.toView());
		return dv;
	}
	
	public List<AlumnoView> alumnosToView()
	{
		List<AlumnoView> av = new ArrayList<AlumnoView>();
		for(Alumno a : alumnos)
			av.add(a.toView());
		return av;
	}
	
	/**
	 * Solo devuelve los cursos con vacantes.
	 * */
	public List<CursoView> cursosToView()
	{
		List<CursoView> cv = new ArrayList<CursoView>();
		for(Curso c : cursos)
			if(c.tieneVacantes())
				cv.add(c.toView());
		return cv;		
	}
	
	public List<MateriaView> materiasToView()
	{
		List<MateriaView> mv = new ArrayList<MateriaView>();
		for(Materia m : materias)
			mv.add(m.toView());
		return mv;		
	}
	
	/**
	 * Este metodo genera datos para poder utilizar la interfaz. NO lo incluya en el DC
	 * */
	private void cargoDatos()
	{
		for(int i= 1; i < 10; i++)
			docentes.add(new Docente("Docente_0" + i));
		docentes.add(new Docente("Docente_10"));
		
		for(int i= 10; i < 100; i++)
			alumnos.add(new Alumno("Alumno_"+i));
		
		Random r = new Random();
		for(int i= 100; i < 150; i++)
			materias.add(new Materia("Codigo_" + i, "Materia_" + i, ((float)Math.round((500.0 + i * r.nextFloat()) * 100)) / 100));
	}
}
