package negocio;

public class Examen {
	
	private String tipo;
	private int nota;
	/**
	 * @param tipo cadena de caracteres que determina el tipo de examen. Puede ser Parcial, Recuperatorio, Final, Previo
	 * @param nota valor numerico entero comprendido entre 0 y 10
	 * 
	 * */
	public Examen(String tipo, int nota)
	{
		this.tipo = tipo;
		if(nota >= 0 && nota <= 10)
			this.nota = nota;
		else
			this.nota = 0;
	}

	public String getTipo() {
		return tipo;
	}

	public int getNota() {
		return nota;
	}
	
	public boolean aprobado()
	{
		return nota >= 4;
	}
	
	public boolean apruebaMateria()
	{
		return (tipo == "Final" || tipo == "Previo") && nota >= 4;
	}
}
