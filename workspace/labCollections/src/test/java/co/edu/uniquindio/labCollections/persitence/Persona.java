package co.edu.uniquindio.labCollections.persitence;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer edad;
	private Boolean esGay;
	public Persona(String nombre, Integer edad, Boolean esGay) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.esGay = esGay;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Boolean getEsGay() {
		return esGay;
	}
	public void setEsGay(Boolean esGay) {
		this.esGay = esGay;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", esGay=" + esGay + "]";
	}
}
