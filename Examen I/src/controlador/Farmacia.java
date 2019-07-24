package controlador;

import negocio.Medicamento;
import negocio.Venta;
import negocio.Laboratorio;
import negocio.Generico;

public class Farmacia {

	Medicamento[] medicamentos;
	Venta[] ventas;
	int contadorVentas = 0;
	int contadorMedicamentos = 0;
	
	public Farmacia() {
		medicamentos = new Medicamento[10];
		agregarMedicamentos();
		ventas = new Venta[10];
		
	}
	
	public void crearVenta(String fecha) {
		ventas[contadorVentas] = new Venta(fecha);
	}
	
	public void agregarItem(String codigo, float cantidad) {
		ventas[contadorVentas].agregaritem(buscarMedicamento(codigo), cantidad);
	}
	
	private Medicamento buscarMedicamento(String codigo) {
		Medicamento m = null;
		contadorMedicamentos = 0;
		while (contadorMedicamentos < 10) {
			if (medicamentos[contadorMedicamentos].soyMedicamento(codigo)) {
				m = medicamentos[contadorMedicamentos];
				System.out.print("agregue medicmanto");
			}
			contadorMedicamentos += 1;
		}
		return m;
	}
	
	public float cerrarVenta() {
		float total = ventas[contadorVentas].cerrarVenta();
		contadorVentas += 1;
		return total;
	}
	
	private void agregarMedicamentos() {
		String codigo;
		contadorMedicamentos = 0;
		while (contadorMedicamentos < 10) {
			codigo = Integer.toString(contadorMedicamentos);
			if (contadorMedicamentos % 2 == 0) {
				String nombre = "Laboratorio" + contadorMedicamentos;
				medicamentos[contadorMedicamentos] = new Laboratorio(nombre, "medicmento original", 10, codigo);
			} else {
				String nombre = "Generico" + contadorMedicamentos;
				medicamentos[contadorMedicamentos] = new Generico(nombre, "medicamento generico", 10, codigo);
			}
			contadorMedicamentos += 1;
		}
	}
}
