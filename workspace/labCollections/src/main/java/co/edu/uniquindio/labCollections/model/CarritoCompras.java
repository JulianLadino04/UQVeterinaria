package co.edu.uniquindio.labCollections.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
/**
 * Esta representacion sirve para gestionar los productos que un cliente desea comprar antes de realizar la compra, contiene un codigo y una lista de productos.
 */
public class CarritoCompras {

    @EqualsAndHashCode.Include
    private String codigo;
    private Set<String> lstProductos;

    public CarritoCompras(String codigo) {
        this.codigo = codigo;
        this.lstProductos = new HashSet<>();
    }

    /**
     * Agrega un producto a la lista (Al ser un Set no permite duplicados).
     * @param codProducto que se desea agregar.
     * @return un valor booleano que depende de si ya existe o no el codigo en la lista.
     */
    public boolean agregarProducto(String codProducto){
        return lstProductos.add(codProducto);
    }

    /**
     * Elimina un codigo de la lista.
     * @param codProducto
     * @return un valor booleano que depende de si existe o no el codigo en la lista.
     */
    public boolean elimarProducto(String codProducto){
        return lstProductos.remove(codProducto);
    }

}
