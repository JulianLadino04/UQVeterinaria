package co.edu.uniquindio.labCollections.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Modela un producto y tiene un código único, un nombre, un precio y una
 * cantidad en inventario.
 */
public class Producto implements Comparable<Producto>, Serializable {

	private Integer cantidad;
	private Long codigo;
	private String nombre;
	private Double precio;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer cantidad, Long codigo, String nombre, Double precio) {
		super();
		this.cantidad = cantidad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [cantidad=" + cantidad + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio
				+ "]";
	}

	@Override
	public int compareTo(Producto o) {
		return cantidad.compareTo(o.getCantidad());
	}
}
