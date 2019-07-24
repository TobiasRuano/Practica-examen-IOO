package view;

public class DocenteView {

	private int numero;
	private String nombre;
	
	public DocenteView(int numero, String nombre) {
		this.nombre = nombre;
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String toString()
	{
		return this.numero + " - " + this.nombre;
	}
}
