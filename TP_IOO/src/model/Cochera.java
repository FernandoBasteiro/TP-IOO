package model;

public class Cochera {
	private int numeroCochera;
	private String estado;
	private String tamanio;
	private float precio;
	private Auto auto;
	
	/**
	 * @param numeroCochera
	 * @param estado
	 * @param tamanio
	 * @param precio
	 * @param auto
	 */
	public Cochera(int numeroCochera, String estado, String tamanio, float precio, Auto auto) {
		super();
		this.numeroCochera = numeroCochera;
		this.estado = estado;
		this.tamanio = tamanio;
		this.precio = precio;
		this.auto = auto;
	}


	public void CrearAuto(String patente, String marca, String modelo) {
		Auto a = new Auto(patente, marca, modelo);
		this.auto = a;
	}

	/**
	 * @return the numeroCochera
	 */
	public int getNumeroCochera() {
		return numeroCochera;
	}

	/**
	 * @param numeroCochera the numeroCochera to set
	 */
	public void setNumeroCochera(int numeroCochera) {
		this.numeroCochera = numeroCochera;
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

	/**
	 * @return the tamanio
	 */
	public String getTamanio() {
		return tamanio;
	}

	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * @param auto the auto to set
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
}
