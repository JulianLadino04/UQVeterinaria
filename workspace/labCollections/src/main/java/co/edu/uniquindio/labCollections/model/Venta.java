package co.edu.uniquindio.labCollections.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Representa una venta/factura, cada uno tiene un codigo de identificacion
 * unico, una fecha de creacion, un precio total y una lista de detalles de
 * venta.
 */
public class Venta {
	private String codigo;
	private LocalDate fecha;
	private Double total;
	private Map<Producto, DetalleVenta> lstDetalles;

	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Venta(String codigo) {
		this.codigo = codigo;
		this.fecha = LocalDate.now();
		calcularTotal();
		this.lstDetalles = new HashMap<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Map<Producto, DetalleVenta> getLstDetalles() {
		return lstDetalles;
	}

	public void setLstDetalles(Map<Producto, DetalleVenta> lstDetalles) {
		this.lstDetalles = lstDetalles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + ", lstDetalles=" + lstDetalles
				+ "]";
	}

	/**
	 * Recolecta todos los subTotales de los detalles y los suma para obtener el
	 * total.
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
