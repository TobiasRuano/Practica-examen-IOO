package gui;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador;

public class VentanaInicio extends JFrame {

	JMenuBar menu;
	JMenu menuAltas;
	JMenu menuAcciones;
	JMenu menuSalir;
	JMenuItem itemAlumnos;
	JMenuItem itemMaterias;
	JMenuItem itemDocentes;
	JMenuItem itemInscribirAlumnos;
	JMenuItem itemCrearCurso;
	JMenuItem itemReasignarDocentes;
	JMenuItem itemSalir;
	
	Controlador controlador;
	
	public VentanaInicio() {
		configurar();
		eventos();
	}
	
	private void configurar() {
		//controlador = Controlador.getInstancia();
		Container contenedor = this.getContentPane(); 
		contenedor.setLayout(null);
		
		this.setSize(600, 400);
		this.setResizable(false);
		
		menu = new JMenuBar();
		menuAltas = new JMenu("Altas");
		menuAcciones = new JMenu("Acciones");
		menuSalir = new JMenu("Salir");
		
		itemAlumnos = new JMenuItem("Alumnos");
		itemMaterias = new JMenuItem("Materias");
		itemDocentes = new JMenuItem("Docentes");
		itemInscribirAlumnos = new JMenuItem("Inscribir Alumno");
		itemCrearCurso = new JMenuItem("Crear Curso");
		itemReasignarDocentes = new JMenuItem("Reasignar Docente");
		itemSalir = new JMenuItem("Salir");
		
		menuAltas.add(itemAlumnos);
		menuAltas.add(itemMaterias);
		menuAltas.add(itemDocentes);
		menuAcciones.add(itemInscribirAlumnos);
		menuAcciones.add(itemCrearCurso);
		menuAcciones.add(itemReasignarDocentes);
		menuSalir.add(itemSalir);
		
		menu.add(menuAltas);
		menu.add(menuAcciones);
		menu.add(menuSalir);
		
		setJMenuBar(menu);
	}
	
	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		itemSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		itemAlumnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		itemInscribirAlumnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInscribirAlumno ventana = new VentanaInscribirAlumno();
				ventana.setVisible(true);
				VentanaInicio.this.setVisible(false);
			}
		});
		itemCrearCurso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCrearCurso ventana = new VentanaCrearCurso();
				ventana.setVisible(true);
				VentanaInicio.this.setVisible(false);
			}
		});
		itemReasignarDocentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaReAsignarDocente ventana = new VentanaReAsignarDocente();
				ventana.setVisible(true);
				VentanaInicio.this.setVisible(false);
			}
		});
	}
	
}
