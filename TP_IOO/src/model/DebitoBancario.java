package model;

public class DebitoBancario extends MediodePago {
	private String entidadBancaria;
	private int CBU;
	
	private static final String ACTIVO = "Activo";
	/**
	 * @param entidadBancaria
	 * @param cBU
	 */
	public DebitoBancario(String entidadBancaria, int cBU) {
		super(ACTIVO);
		this.entidadBancaria = entidadBancaria;
		CBU = cBU;
	}
	/**
	 * @return the entidadBancaria
	 */
	public String getEntidadBancaria() {
		return entidadBancaria;
	}
	/**
	 * @param entidadBancaria the entidadBancaria to set
	 */
	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}
	/**
	 * @return the cBU
	 */
	public int getCBU() {
		return CBU;
	}
	/**
	 * @param cBU the cBU to set
	 */
	public void setCBU(int cBU) {
		CBU = cBU;
	}
	
}
