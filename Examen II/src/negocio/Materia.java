package negocio;

import view.MateriaView;

public class Materia {
	
	private String codigo;
	private String nombre;
	private float importe;
	
	public Materia(String codigo, String nombre, float importe) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		if(importe > 0)
			this.importe = importe;
		else
			this.importe = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		if(importe >= this.importe)
			this.importe = importe;
	}
	
	public MateriaView toView()
	{
		return new MateriaView(codigo, nombre);
	}

	public boolean soyLaMateria(String codigo) {
		return this.codigo.equalsIgnoreCase(codigo);
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null)
			return false;
		if (getClass() != objeto.getClass())
			return false;
		Materia other = (Materia) objeto;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
