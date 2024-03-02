package co.edu.uniquindio.labCollections.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Modela un cliente para facilitar su identificacion en el sistema de gestion,
 * contiene un nombre, direccion, numero de identificacion y un carrito de
 * comprar para almacenar los productos previos a su compra.
 */
public class Cliente implements Serializable {
	private String nombre;
	private String direccion;
	private String nIdentificacion;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String direccion, String nIdentificacion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nIdentificacion = nIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getnIdentificacion() {
		return nIdentificacion;
	}

	public void setnIdentificacion(String nIdentificacion) {
		this.nIdentificacion = nIdentificacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nIdentificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nIdentificacion, other.nIdentificacion);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", nIdentificacion=" + nIdentificacion + "]";
	}
	
	

}
