package negocio;

public class Generico extends Medicamento {

	float descuento = (float) 0.80;
	
	public Generico(String n, String d, float p, String c) {
		super(n, d, p, c);
	}
	
//	public Generico(String n, String d, float p, String c) {
//		super.nombre = n;
//		super.descripcion = d;
//		super.precioBase = p;
//		super.codigo = c;
//	}

	@Override
	public float calcularPrecio() {
		float total = super.precioBase * this.descuento;
		return total;
	}
}
