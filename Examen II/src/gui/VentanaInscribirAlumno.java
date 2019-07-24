package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import controlador.Controlador;
import view.*;

public class VentanaInscribirAlumno extends JFrame {
	
	JComboBox<AlumnoView> lista1;
	JComboBox<CursoView> lista2;
	JButton aceptar;
	JButton salir;
	
	Controlador controlador;
	
	public VentanaInscribirAlumno() {
		configurar();
		eventos();
	}
	
	private void configurar() {
		Container container = this.getContentPane();
		container.setLayout(null);
		
		controlador = Controlador.getInstancia();
		
		this.setSize(600, 400);
		this.setResizable(false);
		
		lista1 = new JComboBox<AlumnoView>();
		lista2 = new JComboBox<CursoView>();
		aceptar = new JButton("Aceptar");
		salir = new JButton("Salir");
		
		configurarListas();
		
		lista1.setBounds(110, 40, 190, 40);
		lista2.setBounds(300, 40, 160, 40);
		aceptar.setBounds(146, 180, 110, 40);
		salir.setBounds(245, 340, 110, 40);
		
		container.add(lista1);
		container.add(lista2);
		container.add(aceptar);
		container.add(salir);
	}

	private void configurarListas() {
		Object[] alumnos = controlador.alumnosToView().toArray();
		System.out.print("hola");
		lista1.removeAllItems();
		for (Object c : alumnos)
			lista1.addItem((AlumnoView) c);

		Object[] cursos = controlador.cursosToView().toArray();
		System.out.print("hola");
		lista2.removeAllItems();
		for (Object c : cursos)
			lista2.addItem((CursoView) c);
	}

	private void eventos() {
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int curso = ((CursoView) lista2.getSelectedItem()).getNumeroCurso();
				int legajo = ((AlumnoView) lista1.getSelectedItem()).getLegajo();
				controlador.asignarAlumnoCurso(curso, legajo, false);
			}
		});
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
	}
}
