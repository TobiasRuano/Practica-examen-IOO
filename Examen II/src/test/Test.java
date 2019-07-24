package test;

import java.util.List;

import gui.VentanaInicio;

import view.AlumnoView;
import view.CursoView;
import view.DocenteView;
import view.MateriaView;
import controlador.Controlador;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<DocenteView> ld = Controlador.getInstancia().docentesToView();
		System.out.println(ld);
		List<AlumnoView> la = Controlador.getInstancia().alumnosToView();
		System.out.println(la);
		List<MateriaView> lm = Controlador.getInstancia().materiasToView();
		System.out.println(lm);
		Controlador.getInstancia().crearCurso(1, "Codigo_100", "Lunes", "Ma�ana");
		Controlador.getInstancia().crearCurso(1, "Codigo_101", "Martes", "Ma�ana");
		Controlador.getInstancia().crearCurso(1, "Codigo_102", "Jueves", "Ma�ana");
		Controlador.getInstancia().crearCurso(1, "Codigo_101", "Jueves", "Tarde");
		Controlador.getInstancia().crearCurso(1, "Codigo_100", "Lunes", "Ma�ana");
		List<CursoView> lc= Controlador.getInstancia().cursosToView();
		System.out.println(lc);
		
		VentanaInicio ventana = new VentanaInicio();
		ventana.setVisible(true);
	}

}
