package co.edu.uniquindio.labCollections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * Es la clase que se encarga de administrar todas las demas, posee los CRUD de
 * las diferentes entidades.
 */
public class Tienda {

	private String nombre;
	private String direccion;
	private String nit;
	private Map<String, Producto> lstProducto;
	private Map<String, Cliente> lstClientes;
	private List<Venta> lstVentas;
	private Collection<CarritoCompras> lstCarritoCompras;
	private Set<Producto> lstInventario;
	private int proximoCodigoCarrito = 1;
	private int proximoCodigoProducto = 1;

	public Tienda() {
		// TODO Auto-generated constructor stub
	}

	public Tienda(String nombre, String direccion, String nit) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nit = nit;
		this.lstProducto = new HashMap<>();
		this.lstClientes = new HashMap<>();
		this.lstVentas = new ArrayList<>();
		this.lstCarritoCompras = new HashSet<>();
		this.lstInventario = new TreeSet<>();

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

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Map<String, Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(Map<String, Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public Map<String, Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(Map<String, Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public List<Venta> getLstVentas() {
		return lstVentas;
	}

	public void setLstVentas(List<Venta> lstVentas) {
		this.lstVentas = lstVentas;
	}

	public Collection<CarritoCompras> getLstCarritoCompras() {
		return lstCarritoCompras;
	}

	public void setLstCarritoCompras(Collection<CarritoCompras> lstCarritoCompras) {
		this.lstCarritoCompras = lstCarritoCompras;
	}

	public Set<Producto> getLstInventario() {
		return lstInventario;
	}

	public void setLstInventario(Set<Producto> lstInventario) {
		this.lstInventario = lstInventario;
	}

	public int getProximoCodigoCarrito() {
		return proximoCodigoCarrito;
	}

	public void setProximoCodigoCarrito(int proximoCodigoCarrito) {
		this.proximoCodigoCarrito = proximoCodigoCarrito;
	}

	public int getProximoCodigoProducto() {
		return proximoCodigoProducto;
	}

	public void setProximoCodigoProducto(int proximoCodigoProducto) {
		this.proximoCodigoProducto = proximoCodigoProducto;
	}

	public void agregarCliente(String nit, Cliente cliente) {
		lstClientes.put(nit, cliente);
	}

	public void agregarVenta(Venta venta) {
		lstVentas.add(venta);
	}

	public void agregarProductoInventario(Producto producto) {
		lstInventario.add(producto);
	}

	public Producto obtenerProducto(String codigo) {
		return lstProducto.get(codigo);
	}

	public Cliente obtenerCliente(String nit) {
		return lstClientes.get(nit);
	}

	public void actualizarDireccion(String nuevaDireccion) {
		this.direccion = nuevaDireccion;
	}

	public void eliminarProducto(String codigo) {
		lstProducto.remove(codigo);
	}

	public void eliminarCliente(String nit) {
		lstClientes.remove(nit);
	}

	private String generarCodigoCarrito() {
		return "C" + proximoCodigoCarrito++;
	}

	private String generarCodigoProducto() {
		return "P" + proximoCodigoProducto++;
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", nit=" + nit + ", proximoCodigoCarrito="
				+ proximoCodigoCarrito + ", proximoCodigoProducto=" + proximoCodigoProducto + "]";
	}

	public String agregarProducto(Producto producto) {
		String codigoProducto = generarCodigoProducto();
		lstProducto.put(codigoProducto, producto);
		return codigoProducto;
	}

	public String agregarCarritoCompras(CarritoCompras carrito) {
		String codigoCarrito = generarCodigoCarrito();
		lstCarritoCompras.add(new CarritoCompras(codigoCarrito));
		return codigoCarrito;
	}

}
