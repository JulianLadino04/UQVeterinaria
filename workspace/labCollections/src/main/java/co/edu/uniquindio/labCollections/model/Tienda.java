package co.edu.uniquindio.labCollections.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Data
@NoArgsConstructor
public class Tienda {

    private String nombre;
    private String direccion;
    private String nit;
    private Map<String, Producto> lstProducto;
    private Map<String, Cliente> lstClientes;
    private List<Venta> lstVentas;
    private Collection<CarritoCompras> lstCarritoCompras;
    private Set<Producto> lstInventario;

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


}
