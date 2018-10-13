package model;

public class Auto {
	private String patente;
	private String marca;
	private String modelo;

	/**
	 * @param patente
	 * @param marca
	 * @param modelo
	 */
	public Auto(String patente, String marca, String modelo) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
