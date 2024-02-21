package co.edu.uniquindio.labCollections.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
/**
 * Funciona como una clase intermedia o conectora entre Venta y Producto. Contiene la cantidad del producto y un subTotal.
 */
public class DetalleVenta {
	private Integer cantidad;
	@EqualsAndHashCode.Include
	private Producto producto;
	private Double subTotal;

	public DetalleVenta(Integer cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
		calcularSubTotal();
	}

	/**
	 * Realiza los calculos necesarios para obtener el subtotal deacuerdo con la cantidad y el producto.
	 */
	private void calcularSubTotal(){
		subTotal = cantidad * producto.getPrecio();
	}

}
