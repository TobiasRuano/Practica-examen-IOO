package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import view.MateriaView;
import view.DocenteView;

public class VentanaCrearCurso extends JFrame {

	JComboBox<MateriaView> lista1;
	JComboBox<DocenteView> lista2;
	JComboBox<String> lista3;
	JButton aceptar;
	JButton salir;
	JButton mañana;
	JButton tarde;
	JButton noche;
	
	Controlador controlador;
	
	public VentanaCrearCurso() {
		configurar();
		eventos();
	}
	
	private void configurar() {
		Container container = this.getContentPane();
		container.setLayout(null);
		
		controlador = Controlador.getInstancia();
		
		this.setSize(600, 400);
		this.setResizable(false);
		
		lista1 = new JComboBox<MateriaView>();
		lista2 = new JComboBox<DocenteView>();
		lista3 = new JComboBox<String>();
		aceptar = new JButton("Aceptar");
		salir = new JButton("Salir");
		mañana = new JButton("Mañana");
		tarde = new JButton("Tarde");
		noche = new JButton("Noche");
		
		configurarListas();
		
		
		lista1.setBounds(110, 40, 190, 40);
		lista2.setBounds(300, 40, 160, 40);
		lista3.setBounds(400, 100, 110, 40);
		aceptar.setBounds(146, 340, 110, 40);
		salir.setBounds(245, 340, 110, 40);
		mañana.setBounds(100, 100, 110, 40);
		tarde.setBounds(200, 100, 110, 40);
		noche.setBounds(300, 100, 110, 40);
		
		container.add(lista1);
		container.add(lista2);
		container.add(lista3);
		container.add(aceptar);
		container.add(salir);
		container.add(mañana);
		container.add(tarde);
		container.add(noche);
	}

	private void configurarListas() {
		Object[] materias = controlador.materiasToView().toArray();
		lista1.removeAllItems();
		for (Object c : materias)
			lista1.addItem((MateriaView) c);
		
		Object[] docentes = controlador.docentesToView().toArray();
		lista2.removeAllItems();
		for (Object c : docentes)
			lista2.addItem((DocenteView) c);
		
		lista3.addItem("Lunes");
		lista3.addItem("Martes");
		lista3.addItem("Miercoles");
		lista3.addItem("Jueves");
		lista3.addItem("Viernes");
	}

	private void eventos() {
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int numero = ((DocenteView) lista2.getSelectedItem()).getNumero();
				String codigo = ((MateriaView) lista1.getSelectedItem()).getCodigo();
				String dia = (String) lista3.getSelectedItem();
				String turno = "";
				if (mañana.isSelected()) {
					turno = mañana.getText();
				} else if (tarde.isSelected()) {
					turno = tarde.getText();
				} else if (noche.isSelected()) {
					turno = noche.getText();
				} else {
					turno = mañana.getText();
				}
				controlador.crearCurso(numero, codigo, dia, turno);
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
