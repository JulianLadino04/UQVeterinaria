package co.edu.uniquindio.labCollections.model;

import lombok.Getter;

import java.util.Comparator;
import java.util.Objects;

@Getter
public class Producto implements Comparable<Producto> {

	private Integer cantidad;
	private Long codigo;
	private String nombre;
	private Double precio;

	@Override
	public int compareTo(Producto o) {
		return cantidad.compareTo(o.getCantidad());
	}
}
