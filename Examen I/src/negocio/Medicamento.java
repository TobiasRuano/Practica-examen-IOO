package negocio;

public class Medicamento {
	
	String nombre;
	String descripcion;
	float precioBase;
	String codigo;
	
	public Medicamento(String n, String d, float p, String c) {
		this.nombre = n;
		this.descripcion = d;
		this.precioBase = p;
		this.codigo = c;
	}

	public float calcularPrecio() {
		return this.precioBase;
	}
	public boolean soyMedicamento(String codigo) {
		return (this.codigo.equals(codigo));
	}
}
