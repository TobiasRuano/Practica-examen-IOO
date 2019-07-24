package negocio;

public class ItemVenta {
	Medicamento medicamento;
	float cantidad;
	
	public ItemVenta(Medicamento m, float c) {
		this.medicamento = m;
		this.cantidad = c;
	}
	
	public float calcularSubTotal() {
		return this.medicamento.calcularPrecio() * this.cantidad;
	}
}
