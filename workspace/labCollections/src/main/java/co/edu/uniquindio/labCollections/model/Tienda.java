package co.edu.uniquindio.labCollections.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
/**
 * Es la clase que se encarga de administrar todas las demas, posee los CRUD de las diferentes entidades.
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
    public String agregarProducto(Producto producto) {
        String codigoProducto = generarCodigoProducto();
        lstProducto.put(codigoProducto, producto);
        return codigoProducto;
    }

    public void agregarCliente(String nit, Cliente cliente) {
        lstClientes.put(nit, cliente);
    }

    public void agregarVenta(Venta venta) {
        lstVentas.add(venta);
    }

    public String agregarCarritoCompras(CarritoCompras carrito) {
        String codigoCarrito = generarCodigoCarrito();
        lstCarritoCompras.add(new CarritoCompras(codigoCarrito));
        return codigoCarrito;
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
}
