package model;

public abstract class MediodePago {
	protected static int numero = 0;
	protected String estado;
	
	
	/**
	 * @param estado
	 */
	public MediodePago(String estado) {
		super();
		MediodePago.numero++;
		this.estado = estado;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
