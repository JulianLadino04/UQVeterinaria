package co.edu.uniquindio.labCollections.model;

import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/**
 * Representa una venta/factura, cada uno tiene un codigo de identificacion unico, una fecha de creacion, un precio total y una lista de detalles de venta.
 */
public class Venta {
    @EqualsAndHashCode.Include
    private String codigo;
    private LocalDate fecha;
    private Double total;
    private Map<Producto, DetalleVenta> lstDetalles;

    public Venta(String codigo) {
        this.codigo = codigo;
        this.fecha = LocalDate.now();
        calcularTotal();
        this.lstDetalles = new HashMap<>();
    }

    /**
     * Recolecta todos los subTotales de los detalles y los suma para obtener el total.
     */
    private void calcularTotal() {
        for (DetalleVenta v : lstDetalles.values()) {
            total += v.getSubTotal();
        }
    }

    /**
     * Agrega un nuevo detalle de venta en la lista de Venta.
     *
     * @param detalleVenta a ser agregado.
     * @return detalleVenta post-agregado.
     */
    public DetalleVenta agregarDetalle(DetalleVenta detalleVenta) {
        return lstDetalles.put(detalleVenta.getProducto(), detalleVenta);
    }

    /**
     * Remueve un detalle de la lista.
     *
     * @param producto perteneciente al detalle que se desea eliminar.
     * @return el detalle eliminado de la lista o null si no pertenecia a ella.
     */
    public DetalleVenta eliminarDetalle(Producto producto) {
        return lstDetalles.remove(producto);
    }
}
