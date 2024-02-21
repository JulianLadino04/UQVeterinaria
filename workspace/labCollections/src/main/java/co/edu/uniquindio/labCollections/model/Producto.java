package co.edu.uniquindio.labCollections.model;

import lombok.*;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
/**
 * Modela un producto y tiene un código único, un nombre, un precio y una cantidad en inventario.
 */
public class Producto implements Comparable<Producto> {

	private Integer cantidad;
	@EqualsAndHashCode.Include
	private Long codigo;
	private String nombre;
	private Double precio;

	@Override
	public int compareTo(Producto o) {
		return cantidad.compareTo(o.getCantidad());
	}
}
