package model;
import java.util.*;

public class Contrato {
	private int numero;
	private String estado;
	private Date fechaEntrada;
	private Date fechaFinal;
	private List<MediodePago> mediosdePago;
	private List<TarjetaDeCredito> tarjetasDeCredito;
	private List<DebitoBancario> debitosBancarios; 
	private CuentaCorriente cuentaCorriente;
	private Cliente cliente;
	private Cochera cochera;
	
	private static final String ACTIVO = "Activo";
	private static final String INACTIVO = "Inactivo";
	private static final String LIBRE = "Libre";
	private static final String BLOQUEADA = "Bloqueada";
	private static final String OCUPADA = "Ocupada";
	private static final String CUOTAMES = "Cuota del mes";
	


	/**
	 * @param numero
	 * @param estado
	 * @param fechaEntrada
	 * @param fechaFinal
	 * @param mediosdePago
	 * @param tarjetasDeCredito
	 * @param debitosBancarios
	 * @param cuentaCorriente
	 * @param cliente
	 * @param cochera
	 */
	public Contrato(int numero, String estado, Date fechaEntrada, Date fechaFinal, List<MediodePago> mediosdePago,
			List<TarjetaDeCredito> tarjetasDeCredito, List<DebitoBancario> debitosBancarios,
			CuentaCorriente cuentaCorriente, Cliente cliente, Cochera cochera) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.fechaEntrada = fechaEntrada;
		this.fechaFinal = fechaFinal;
		this.mediosdePago = mediosdePago;
		this.tarjetasDeCredito = tarjetasDeCredito;
		this.debitosBancarios = debitosBancarios;
		this.cuentaCorriente = cuentaCorriente;
		this.cliente = cliente;
		this.cochera = cochera;
	}


	public void AltaTarjeta(String entidadEmisora, int numeroTarjeta, Date fechaVencimiento) {
		TarjetaDeCredito tc = BuscarTarjeta(numeroTarjeta);
		if (tc == null) {
			tc = new TarjetaDeCredito(entidadEmisora, numeroTarjeta, fechaVencimiento);
			mediosdePago.add(tc);
		}
		tc.setEstado(ACTIVO);
	}
	
	
	public TarjetaDeCredito BuscarTarjeta(int numero) {
		TarjetaDeCredito tarjeta = null;
		for (TarjetaDeCredito tarjetaBuscada : this.tarjetasDeCredito) {
			if(tarjetaBuscada.getNumeroTarjeta() == numero){
				tarjeta = tarjetaBuscada;
			}
		}
		return tarjeta;
	}
	
	public DebitoBancario BuscarCBU(int CBU) {
		DebitoBancario debitoBancario = null;
		for (DebitoBancario debito : this.debitosBancarios) {
			if(debito.getCBU() == CBU){
				debitoBancario = debito;
			}
		}
		return debitoBancario;
	}
	
	public void AltaCBU(String entidadBancaria, int CBU) {
		DebitoBancario db = BuscarCBU(CBU);
		if (db == null) {
			db = new DebitoBancario(entidadBancaria, CBU);
			mediosdePago.add(db);
		}
		db.setEstado(ACTIVO);
	}
	
	
	public MediodePago BuscarEfectivo(){
		for (MediodePago mdp : this.mediosdePago) {
			if (mdp instanceof Efectivo) {
				return mdp;
			}
		}
		return null;
	}
	
	public void AltaEfectivo () {
		MediodePago ef = BuscarEfectivo();
		if (ef != null) {
			ef.setEstado(ACTIVO);
		}
		else {
			ef = new Efectivo();
			mediosdePago.add(ef);
		}
	}
	
	
	public void BajaTarjeta(int numeroTarjeta){
		TarjetaDeCredito tc = BuscarTarjeta(numeroTarjeta);
		if (tc != null) {
			tc.setEstado(INACTIVO);
		}
	}

	public void BajaCBU(int CBU) {
		DebitoBancario db = BuscarCBU(CBU);
		if (db != null) {
			db.setEstado(INACTIVO);
		}
	}
	
	
	public void BajaEfectivo () {
		MediodePago ef = BuscarEfectivo();
		if (ef != null) {
			ef.setEstado(INACTIVO);
		}
	}
	
	public void ProcesarMovimiento (Date fecha, String concepto, float monto) {
		this.cuentaCorriente.ProcesarMovimiento(fecha, concepto, monto);
		float saldo = this.cuentaCorriente.GetSaldo();
		if (saldo > 0) {
			this.cochera.setEstado(OCUPADA);
		}
	}
	
	public void BajaContrato() {
		this.SetEstado(INACTIVO);
		this.cochera.setEstado(LIBRE);
		this.cochera.setAuto(null);
	}
	
	public void ActualizarEstadoCochera() {
		if (this.estado == ACTIVO) {
			if (this.cuentaCorriente.GetSaldo() < 0) {
				this.cochera.setEstado(BLOQUEADA);
			}
		}
		else {
			this.cochera.setEstado(LIBRE);
		}
	}
	
	public void ProcesarCuota(Date fecha) {
		float monto = this.cochera.getPrecio();
		String concepto = CUOTAMES;
		this.cuentaCorriente.ProcesarMovimiento(fecha, concepto, monto);
	}

	public Cliente GetCliente() {
		return cliente;
	}

	public void SetEstado(String estado) {
		this.estado = estado;
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
	 * @return the fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}


	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}



	/**
	 * @return the mediosdePago
	 */
	public List<MediodePago> getMediosdePago() {
		return mediosdePago;
	}

	/**
	 * @return the cuentaCorriente
	 */
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}


	/**
	 * @param cuentaCorriente the cuentaCorriente to set
	 */
	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}


	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the cochera
	 */
	public Cochera getCochera() {
		return cochera;
	}


	/**
	 * @param cochera the cochera to set
	 */
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}


	/**
	 * @return the tarjetasDeCredito
	 */
	public List<TarjetaDeCredito> getTarjetasDeCredito() {
		return tarjetasDeCredito;
	}


	/**
	 * @param tarjetasDeCredito the tarjetasDeCredito to set
	 */
	public void setTarjetasDeCredito(List<TarjetaDeCredito> tarjetasDeCredito) {
		this.tarjetasDeCredito = tarjetasDeCredito;
	}


	/**
	 * @return the debitosBancarios
	 */
	public List<DebitoBancario> getDebitosBancarios() {
		return debitosBancarios;
	}


	/**
	 * @param debitosBancarios the debitosBancarios to set
	 */
	public void setDebitosBancarios(List<DebitoBancario> debitosBancarios) {
		this.debitosBancarios = debitosBancarios;
	}


	/**
	 * @param mediosdePago the mediosdePago to set
	 */
	public void setMediosdePago(List<MediodePago> mediosdePago) {
		this.mediosdePago = mediosdePago;
	}
	
	
	
}
