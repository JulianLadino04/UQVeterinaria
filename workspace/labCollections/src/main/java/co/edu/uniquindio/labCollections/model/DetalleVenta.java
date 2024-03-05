package co.edu.uniquindio.labCollections.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Funciona como una clase intermedia o conectora entre Venta y Producto.
 * Contiene la cantidad del producto y un subTotal.
 */
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cantidad;
	private Producto producto;
	private Double subTotal;

	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}

	public DetalleVenta(Integer cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
		calcularSubTotal();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVenta other = (DetalleVenta) obj;
		return Objects.equals(producto, other.producto);
	}

	public String toString() {
		return "DetalleVenta [cantidad=" + cantidad + ", producto=" + producto + ", subTotal=" + subTotal + "]";
	}

	/**
	 * Realiza los calculos necesarios para obtener el subtotal deacuerdo con la
	 * cantidad y el producto.
	 */
	private void calcularSubTotal() {
		subTotal = cantidad * producto.getPrecio();
	}

}
