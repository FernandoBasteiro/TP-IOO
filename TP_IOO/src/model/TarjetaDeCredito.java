package model;
import java.util.*;




public class TarjetaDeCredito extends MediodePago {
	private String entidadEmisora;
	private int numeroTarjeta;
	private Date fechaVencimiento;
	
	private static final String ACTIVO = "Activo";
	/**
	 * @param entidadEmisora
	 * @param numeroTarjeta
	 * @param fechaVencimiento
	 */
	public TarjetaDeCredito(String entidadEmisora, int numeroTarjeta, Date fechaVencimiento) {
		super(ACTIVO);
		this.entidadEmisora = entidadEmisora;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	/**
	 * @return the entidadEmisora
	 */
	public String getEntidadEmisora() {
		return entidadEmisora;
	}
	/**
	 * @param entidadEmisora the entidadEmisora to set
	 */
	public void setEntidadEmisora(String entidadEmisora) {
		this.entidadEmisora = entidadEmisora;
	}
	/**
	 * @return the numeroTarjeta
	 */
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	/**
	 * @param numeroTarjeta the numeroTarjeta to set
	 */
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	

}
