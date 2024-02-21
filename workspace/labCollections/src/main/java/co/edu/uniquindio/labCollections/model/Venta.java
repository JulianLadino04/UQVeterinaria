package co.edu.uniquindio.labCollections.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Venta {
	private String codigo;
	private LocalDate fecha;
	private Double total;
	private Set<DetalleVenta> detalles;
	
}
