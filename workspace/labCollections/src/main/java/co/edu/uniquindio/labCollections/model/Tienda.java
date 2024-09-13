package co.edu.uniquindio.labCollections.model;

import java.util.ArrayList;
import java.util.HashMap;
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
	private Map<Long, Producto> lstProducto;
	private Map<String, Cliente> lstClientes;
	private List<Venta> lstVentas;
	private Set<CarritoCompras> lstCarritoCompras;
	private Set<Producto> lstInventario;
	private int proximoCodigoVenta = 1;
	private int proximoCodigoProducto = 1;

	public Tienda() {
	}

	public Tienda(String nombre, String direccion, String nit) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nit = nit;
		this.lstProducto = new HashMap<>();
		this.lstClientes = new HashMap<>();
		this.lstVentas = new ArrayList<>();
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

	public Map<Long, Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(Map<Long, Producto> lstProducto) {
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

	public Set<CarritoCompras> getLstCarritoCompras() {
		return lstCarritoCompras;
	}

	public void setLstCarritoCompras(Set<CarritoCompras> lstCarritoCompras) {
		this.lstCarritoCompras = lstCarritoCompras;
	}

	public Set<Producto> getLstInventario() {
		return lstInventario;
	}

	public void setLstInventario(Set<Producto> lstInventario) {
		this.lstInventario = lstInventario;
	}

	public int getProximoCodigoCarrito() {
		return proximoCodigoVenta;
	}

	public void setProximoCodigoCarrito(int proximoCodigoVenta) {
		this.proximoCodigoVenta = proximoCodigoVenta;
	}

	public int getProximoCodigoProducto() {
		return proximoCodigoProducto;
	}

	public void setProximoCodigoProducto(int proximoCodigoProducto) {
		this.proximoCodigoProducto = proximoCodigoProducto;
	}

	
	/**
	 * Agrega un <code>cliente<code> a la lista de clientes.
	 *
	 * @param cliente 
	 */
	public void agregarCliente(Cliente cliente) {
		lstClientes.put(cliente.getnIdentificacion(), cliente);
	}
	
	/**
	 * Agrega una <code>venta<code> a la lista de ventas.
	 *
	 * @param venta 
	 */
	public void agregarVenta(Venta venta) {
		lstVentas.add(venta);
	}

	/**
	 * Agrega un <code>producto<code> a la lista inventario.
	 *
	 * @param producto
	 */
	public void agregarProductoInventario(Producto producto) {
		lstInventario.add(producto);
	}

	/**
	 * Obtiene un <code>producto<code> de la lista de productos basado en su <code>codigo<code>.
	 *
	 * @param codigo
	 * @return El producto correspondiente al código proporcionado, o null si no se encuentra.
	 */
	public Producto obtenerProducto(String codigo) {
		return lstProducto.get(codigo);
	}

	/**
	 * Obtiene un <code>cliente<code> de la lista de clientes basado en su <code>nit<code>.
	 *
	 * @param nit
	 * @return El cliente correspondiente al NIT proporcionado, o null si no se encuentra.
	 */
	public Cliente obtenerCliente(String nit) {
		return lstClientes.get(nit);
	}

	/**
	 * Actualiza la <code>dirección<code> del <code>Cliente<code> actual con la nueva <code>dirección<code> proporcionada.
	 *
	 * @param nuevaDireccion 
	 */
	public void actualizarDireccion(String nuevaDireccion) {
		this.direccion = nuevaDireccion;
	}

	/**
	 * Elimina un <code>producto<code> de la lista de productos basado en su <code>código<code>.
	 *
	 * @param codigo
	 */
	public void eliminarProducto(String codigo) {
		lstProducto.remove(codigo);
	}

	/**
	 * Elimina un <code>Cliente<code> de la lista de clientes basado en su <code>nit<code>.
	 *
	 * @param nit
	 */
	public void eliminarCliente(String nit) {
		lstClientes.remove(nit);
	}

	/**
	 * Genera un <code>código<code> único para un carrito de compras.
	 *
	 * @return El código único generado para un carrito de compras.
	 */
	private String generarCodigoVenta() {
		return "C" + proximoCodigoVenta++;
	}

	/**
	 * Genera un <code>código<code> único para un producto.
	 *
	 * @return El código único generado para un producto.
	 */
	private Long generarCodigoProducto() {
		proximoCodigoProducto+= 1;
		return Long.valueOf(proximoCodigoProducto);
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", nit=" + nit + ", proximoCodigoCarrito="
				+ proximoCodigoVenta + ", proximoCodigoProducto=" + proximoCodigoProducto + "]";
	}
	
	/**
	 * Agrega un <code>producto<code> a la lista de productos y asigna un <code>codigoProducto<code> único al producto.
	 * 
	 * @param producto
	 * @return codigoProducto
	 * @author Breyner
	 */
	public Long agregarProducto(Producto producto) {
		Long codigoProducto = generarCodigoProducto();
		producto.setCodigo(codigoProducto);
		lstProducto.put(producto.getCodigo(), producto);
		actualizarInventario();
		return codigoProducto;
	}
	
	public void actualizarInventario() {
		lstInventario = new TreeSet<Producto>(lstProducto.values());
	}

	/**
	 * Agrega un <code>carrito<code> a la lista de carritos de compras y asigna un <code>codigoCarrito<code> único al carrito.
	 * 
	 * @param carrito
	 * @return codigoCarrito
	 * @author Breyner
	 */
	public String agregarCarritoCompras(CarritoCompras carrito) {
		String codigoCarrito = generarCodigoVenta();
		lstCarritoCompras.add(new CarritoCompras(codigoCarrito));
		return codigoCarrito;
	}
	
	/**
	 * Filtra los clientes por su número de <code>identificación<code>.
	 * 
	 * @param identificacion
	 * @return
	 */
	public List<Cliente> filtrarClientesPorCedula(String identificacion) {
		return lstClientes.values().stream().filter(c -> c.getnIdentificacion().equals(identificacion)).toList();
	}

	/**
	 * Filtra los productos en inventario por su <code>codigo<code>.
	 * 
	 * @param codigo
	 * @return
	 */
	public List<Producto> filtrarInventarioPorCodigo(Long codigo) {
		return lstInventario.stream().filter(p -> p.getCodigo().equals(codigo)).toList();
	}

	/**
	 * Filtra los productos por su <code>codigo<code>.
	 * 
	 * @param codigo
	 * @return
	 */
	public List<Producto> filtrarProductosPorCodigo(Long codigo) {
		return lstProducto.values().stream().filter(p -> p.getCodigo().equals(codigo)).toList();
	}

	public List<Producto> getCarritoCliente(String identificacion) {
		return lstClientes.get(identificacion).getLstCarrito();
	}
	
	public void agregarAlCarrito(String identificacion, Producto producto) {
		lstClientes.forEach((k, v) -> {
			if(k.equals(identificacion)) v.agregarAlCarrito(producto);
		});
	}

	public void eliminarProductoCarrito(String identificacion, Producto producto) {
		lstClientes.get(identificacion).sacarDelCarrito(producto);
	}

	public void finalizarComprar(String identificacion) {
		List<Producto> carrito = lstClientes.get(identificacion).vaciarCarrito();
		lstProducto.forEach((c, p) -> {
			for(Producto producto : carrito) {
				if(p.equals(producto)) p.setCantidad(p.getCantidad().intValue() - producto.getCantidad().intValue());
			}
		});
		actualizarInventario();
		List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
		for(Producto producto : carrito) {
			detalles.add(new DetalleVenta(producto.getCantidad(), producto));
		}
		Venta venta = new Venta(generarCodigoVenta(), detalles);
		lstVentas.add(venta);
	}

	public Producto buscarProducto(Long codigo) {
		return lstProducto.get(codigo);
	}
	
}
