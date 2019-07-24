package negocio;

public class Laboratorio extends Medicamento {

	float recargo = (float) 1.20;
	
	public Laboratorio(String n, String d, float p, String c) {
		super(n, d, p, c);
	}
	
//	public Laboratorio(String n, String d, float p, String c) {
//		super.nombre = n;
//		super.descripcion = d;
//		super.precioBase = p;
//		super.codigo = c;
//	}

	@Override
	public float calcularPrecio() {
		float total = super.precioBase * this.recargo;
		return total;
	}

}
