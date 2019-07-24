package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Farmacia;

public class VentanaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton agregar;
	JButton crearVenta;
	JButton cerrarVenta;
	JLabel labelItem;
	JTextField codigo;
	
	Farmacia controlador;

	public VentanaPrincipal() {
		configurar();
		eventos();
	}

	private void configurar() {
		Container contenedor = this.getContentPane();
		contenedor.setLayout(null);
		
		this.setSize(600, 400);
		this.setResizable(false);
		
		this.controlador = new Farmacia();
		
		agregar = new JButton("Agregar");
		crearVenta = new JButton("Crear Venta");
		cerrarVenta = new JButton("Cerrar Venta");
		labelItem = new JLabel("Ingrese el codigo del item: ");
		codigo = new JTextField();
		
		agregar.setBounds(500, 100, 70, 40);
		crearVenta.setBounds(500, 300, 70, 40);
		cerrarVenta.setBounds(300, 300, 70, 40);
		labelItem.setBounds(100, 100, 120, 40);
		codigo.setBounds(300, 100, 70, 40);
		
		contenedor.add(agregar);
		contenedor.add(crearVenta);
		contenedor.add(cerrarVenta);
		contenedor.add(labelItem);
		contenedor.add(codigo);
		
		cerrarVenta.setEnabled(false);
		agregar.setEnabled(false);
	}

	private void eventos() {
		
		crearVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.crearVenta("12/12/2019");
				cerrarVenta.setEnabled(true);
				agregar.setEnabled(true);
				crearVenta.setEnabled(false);
			}
		});
		cerrarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float total = controlador.cerrarVenta();
				System.out.print("Se cerro la ultima venta con un total de: " + total);
				cerrarVenta.setEnabled(false);
				agregar.setEnabled(false);
				crearVenta.setEnabled(true);
			}
		});
		agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cod = codigo.getText();
				controlador.agregarItem(cod, 1);
			}
		});
	}
}
