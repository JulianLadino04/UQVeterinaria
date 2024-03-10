package co.edu.uniquindio.labCollections.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Modela un cliente para facilitar su identificacion en el sistema de gestion,
 * contiene un nombre, direccion, numero de identificacion y un carrito de
 * comprar para almacenar los productos previos a su compra.
 */
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String direccion;
	private String nIdentificacion;
	private CarritoCompras carritoCompras;

	public Cliente() {
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

	public CarritoCompras getCarritoCompras() {
		return carritoCompras;
	}

	public void setCarritoCompras(CarritoCompras carritoCompras) {
		this.carritoCompras = carritoCompras;
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
	
	public void agregarAlCarrito(Producto producto) {
		carritoCompras.agregarProducto(producto);
	}
	
	public void sacarDelCarrito(Producto producto) {
		carritoCompras.eliminarProducto(producto);
	}
	
	public List<Producto> getLstCarrito(){
		return carritoCompras.getLstProductos().stream().toList();
	}
	
	public List<Producto> vaciarCarrito(){
		List<Producto> carrito = getLstCarrito();
		var nuevoCarro = new CarritoCompras();
		nuevoCarro.setCodigo(nIdentificacion);
		setCarritoCompras(nuevoCarro);
		return carrito;
	}
	
	

}
