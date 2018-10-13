package model;
import java.util.*;


public class Movimiento {
	private int numero;
	private Date fecha;
	private String concepto;
	private float monto;
	/**
	 * @param numero
	 * @param fecha
	 * @param concepto
	 * @param monto
	 */
	public Movimiento(int numero, Date fecha, String concepto, float monto) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.concepto = concepto;
		this.monto = monto;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}
	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	/**
	 * @return the monto
	 */
	public float getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
