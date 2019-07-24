package view;

public class MateriaView {

	private String codigo;
	private String nombre;
	
	public MateriaView(String codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString()
	{
		return this.codigo + " - " + this.nombre;
	}
}
