package model;

public class ClienteVista {
	private int dni;
	private String nombre;
	private String domicilio;
	private int telefono;
	private String mail;
	private String estado;
	
	public ClienteVista(int dni, String nombre, String domicilio, int telefono,	String mail, String estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.estado = estado;
	}

	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public String getEstado() {
		return estado;
	}
	
}
