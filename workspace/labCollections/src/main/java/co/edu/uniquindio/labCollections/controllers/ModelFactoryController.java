package co.edu.uniquindio.labCollections.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

import co.edu.uniquindio.labCollections.model.Cliente;
import co.edu.uniquindio.labCollections.model.Producto;
import co.edu.uniquindio.labCollections.model.Tienda;
import co.edu.uniquindio.labCollections.utils.PersistenceService;
import co.edu.uniquindio.labCollections.utils.PersistenceServiceBinary;

public class ModelFactoryController {

	private static ModelFactoryController instance;
	private PersistenceService persistence;
	private Tienda tienda;

	private ModelFactoryController() {
		this.persistence = new PersistenceServiceBinary();
		this.tienda = new Tienda("La tiendita", "Diagonal a la Universidad del Quindio", UUID.randomUUID().toString());
		cargarDatosIncio();
	}
	
	public void guardarDatos(String nombre, Object object) {
		try {
			persistence.serialize(nombre, object);
		} catch (Exception e) {
			// TODO Se debe mejorar la exception, para esto es bueno revisar que exceptions puede lanzar.
			e.printStackTrace();
		}
	}
	
	private <T> T cargarDatos(String nombre, Class<T> entity) {
		try {
			return persistence.deserialize(nombre, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void cargarDatosIncio() {
		this.getTienda().setLstClientes(cargarDatos("clientes", HashMap.class));
		this.getTienda().setLstInventario(cargarDatos("inventario", TreeSet.class));
		this.getTienda().setLstProducto(cargarDatos("productos", HashMap.class));
		this.getTienda().setLstVentas(cargarDatos("ventas", ArrayList.class));
	}

	public static ModelFactoryController getIntance() {
		if (instance == null)
			instance = new ModelFactoryController();
		return instance;
	}

	public void setPersistence(PersistenceService persistence) {
		this.persistence = persistence;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public void agregarCliente(Cliente cliente) {
		System.out.println(this.getTienda());
		this.getTienda().agregarCliente(cliente);
		guardarDatos("clientes", this.getTienda().getLstClientes());
	}

	public List<Producto> getListProductos() {
		return this.getTienda().getLstProducto().values().stream().toList();
	}

	public List<Cliente> getListClientes(){
		return this.getTienda().getLstClientes().values().stream().toList();
	}
	
	public List<Producto> getListInventario(){
		return this.getTienda().getLstInventario().stream().toList();
	}
	
	public List<Producto> getCarritoCliente(String identificacion){
		return this.getTienda().getCarritoCliente(identificacion);
	}

	public void agregarProducto(Producto producto) {
		this.getTienda().agregarProducto(producto);
		//TODO Se debe revisar los metodos de agregacion de productos, recordar que se deben agregar al inventario.
		guardarDatos("productos", this.getTienda().getLstProducto());
		guardarDatos("inventario", this.getTienda().getLstInventario());
	}
	
	public List<Cliente> filtrarClientes(String identificacion) {
		return this.getTienda().filtrarClientesPorCedula(identificacion);
	}

	public List<Producto> filtrarInventario(Long codigo) {
		return this.getTienda().filtrarInventarioPorCodigo(codigo);
	}
	
	public List<Producto> filtrarProductos(Long codigo){
		return this.getTienda().filtrarProductosPorCodigo(codigo);
	}
	
	public List<Producto> buscarCarritoDelCliente(String identificacion){
		return this.getTienda().getCarritoCliente(identificacion);
	}
	
	public void eliminarProductoCarrito(String identificacion, Producto producto) {
		this.getTienda().eliminarProductoCarrito(identificacion, producto);
	}

	public void finalizarVenta(String identificacion) {
		this.getTienda().finalizarComprar(identificacion);
		
	}

	public Producto buscarProducto(Long codigo) {
		return this.getTienda().buscarProducto(codigo);
	}

	public void agregarAlCarrito(String identificacion, Producto producto) {
		this.getTienda().agregarAlCarrito(identificacion, producto);
	}

}
