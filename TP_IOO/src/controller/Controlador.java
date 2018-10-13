package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.*;
import view.*;

public class Controlador {
	public List<Cliente> clientes;
	public List<Contrato> contratos;
	public List<Cochera> cocheras;

	public static final String COCHERA_DISPONIBLE = "Disponible";
	public static final String COCHERA_OCUPADA = "Ocupada";
	public static final String COCHERA_LIBRE = "Libre";
	public static final String CONTRATO_ACTIVO = "Activo";
	public static final String CLIENTE_ACTIVO = "Activo";
	public static final String CLIENTE_INACTIVO = "Inactivo";

	private Contrato contrato;
	private Cliente cliente;
	private Cochera cochera;

	/**
	 * @param clientes
	 * @param contratos
	 * @param cocheras
	 */
	public Controlador() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.contratos = new ArrayList<Contrato>();
		this.cocheras = new ArrayList<Cochera>();
	}

	/**
	 * 
	 * @param numero
	 * @return
	 */
	public Contrato BuscarContrato(int numero) {
		Contrato c = null;
		for (Contrato contrato : this.contratos) {
			if (contrato.getNumero() == numero) {
				c = contrato;
			}
		}
		return c;
	}

	/**
	 * 
	 * @param dni
	 * @return
	 */
	public Cliente BuscarCliente(int dni) {
		Cliente c = null;
		for (Cliente cliente : this.clientes) {
			if (cliente.getDni() == dni) {
				c = cliente;
			}
		}
		return c;
	}
	/**
	 * 
	 * @param dni
	 * @return
	 */
	public boolean ExisteCliente(int dni) {
		this.cliente = BuscarCliente(dni);
		if (this.cliente != null)
			return true;
		return false;
	}
	/**
	 * 
	 * @param tamanio
	 * @param precio
	 */
	public void CrearCochera(String tamanio, float precio) {
		int numero = cocheras.size() + 1;
		String estado = COCHERA_LIBRE;
		Cochera nuevaCochera = new Cochera(numero, estado, tamanio, precio, null);
		cocheras.add(nuevaCochera);
	}
	
	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param domicilio
	 * @param telefono
	 * @param mail
	 */
	public void AltaClienteNuevo(int dni, String nombre, String domicilio, int telefono, String mail) {
		String estado = CLIENTE_ACTIVO;
		Cliente nuevoCliente = new Cliente(dni, nombre, domicilio, telefono, mail, estado);
		clientes.add(nuevoCliente);
	}
	
	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param domicilio
	 * @param telefono
	 * @param mail
	 * @param estado
	 */
	public void ModificarCliente(int dni, String nombre, String domicilio, int telefono, String mail, String estado) {
		this.cliente.setDni(dni);
		this.cliente.setNombre(nombre);
		this.cliente.setDomicilio(domicilio);
		this.cliente.setTelefono(telefono);
		this.cliente.setMail(mail);
		this.cliente.setEstado(estado);
	}
	
	/**
	 * 
	 * @param numero
	 * @return
	 */
	public boolean ExisteContrato(int numero) {
		this.contrato = BuscarContrato(numero);
		if (this.contrato != null)
			return true;
		return false;
	}

	public void BajaContrato() {
		if (this.contrato != null) {
			this.contrato.BajaContrato();
		}
	}

	public Cochera BuscarCocheraDisponible(String tamanio) {
		Cochera c = null;
		int encontrado = 0;
		for (Cochera cochera : this.cocheras) {

			if (cochera.getTamanio().equalsIgnoreCase(tamanio)
					&& cochera.getEstado().equalsIgnoreCase(COCHERA_DISPONIBLE) && encontrado == 0) {
				c = cochera;
				encontrado = 1;
			}

		}
		return c;
	}

	/**
	 * 
	 * @param entidadEmisora
	 * @param numero
	 * @param fechaVencimiento
	 */
	public void AltaTarjeta(String entidadEmisora, int numero, Date fechaVencimiento) {
		this.contrato.AltaTarjeta(entidadEmisora, numero, fechaVencimiento);

	}


	public void AltaContrato(String tamanio, String patente, String modelo, String marca, Date fechaEntrada, Date fechaSalida) {
		int numero = contratos.size() + 1;
		Cochera cochera = BuscarCocheraDisponible(tamanio);
		cochera.setEstado(COCHERA_OCUPADA);
		cochera.CrearAuto(patente, marca, modelo);
		Contrato nuevocontrato = new Contrato(numero, CONTRATO_ACTIVO, fechaEntrada, fechaSalida, null, null, null, null, this.cliente, cochera);
		contratos.add(nuevocontrato);
	}
	
	/**
	 * 
	 * @param entidadBancaria
	 * @param CBU
	 */
	public void AltaCBU(String entidadBancaria, int CBU) {
		this.contrato.AltaCBU(entidadBancaria, CBU);
	}

	/**
	 * 
	 */
	public void AltaEfectivo() {
		this.contrato.AltaEfectivo();
	}

	/**
	 * 
	 * @param numeroTarjeta
	 */
	public void BajaTarjeta(int numeroTarjeta) {
		this.contrato.BajaTarjeta(numeroTarjeta);
	}

	/**
	 * 
	 * @param CBU
	 */
	public void BajaCBU(int CBU) {
		this.contrato.BajaCBU(CBU);
	}

	public void BajaEfectivo() {
		this.contrato.BajaEfectivo();
	}

	/**
	 * 
	 * @param fecha
	 * @param concepto
	 * @param monto
	 */
	public void ProcesarMovimiento(Date fecha, String concepto, float monto) {
		this.contrato.ProcesarMovimiento(fecha, concepto, monto);
	}

	public void ActualizarEstadoCochera() {
		for (Contrato cont : contratos) {
			cont.ActualizarEstadoCochera();
		}
	}

	/**
	 * 
	 * @param fecha
	 */
	public void ProcesarCuota(Date fecha) {
		for (Contrato cont : contratos) {
			cont.ProcesarCuota(fecha);
		}
	}

	
	
	public ClienteVista mostrarCliente() {
		return cliente.crearVista();
	}
	
	public void BajaCliente() {
		String estado = CLIENTE_INACTIVO;
		this.cliente.setEstado(estado);
		for (Contrato cont : contratos) {
			if (cont.getCliente() == this.cliente) {
				cont.BajaContrato();
			}
		}
	}

}
