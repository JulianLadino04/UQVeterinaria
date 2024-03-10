package co.edu.uniquindio.labCollections.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Esta representacion sirve para gestionar los productos que un cliente desea
 * comprar antes de realizar la compra, contiene un codigo y una lista de
 * productos.
 */
public class CarritoCompras implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private Set<Producto> lstProductos;

	public CarritoCompras() {
		this.lstProductos = new HashSet<>();
	}

	public CarritoCompras(String codigo) {
		this.codigo = codigo;
		this.lstProductos = new HashSet<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Set<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(Set<Producto> lstProductos) {
		this.lstProductos = lstProductos;
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
		CarritoCompras other = (CarritoCompras) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "CarritoCompras [codigo=" + codigo.toString() + ", lstProductos=" + lstProductos + "]";
	}

	/**
	 * Agrega un producto a la lista (Al ser un Set no permite duplicados).
	 * 
	 * @param codProducto que se desea agregar.
	 * @return un valor booleano que depende de si ya existe o no el codigo en la
	 *         lista.
	 */
	public boolean agregarProducto(Producto codProducto) {
		return lstProductos.add(codProducto);
	}

	/**
	 * Elimina un codigo de la lista.
	 * 
	 * @param codProducto
	 * @return un valor booleano que depende de si existe o no el codigo en la
	 *         lista.
	 */
	public boolean eliminarProducto(Producto codProducto) {
		return lstProductos.remove(codProducto);
	}

}
