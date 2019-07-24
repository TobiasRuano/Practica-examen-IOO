package negocio;

public class Venta {
	String fecha;
	ItemVenta[] items;
	float total;
	int contadorItems = 0;
	
	public Venta(String f) {
		this.fecha = f;
		this.items = new ItemVenta[10];
		this.total = 0;
	}
	
	public void agregaritem(Medicamento m, float cantidad) {
		items[contadorItems] = new ItemVenta(m, cantidad);
		this.total += items[contadorItems].calcularSubTotal();
		this.contadorItems += 1;
	}
	
	public float cerrarVenta() {
		return total;
	}
}
