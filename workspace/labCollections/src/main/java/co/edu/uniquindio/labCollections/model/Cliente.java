package co.edu.uniquindio.labCollections.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
/**
 * Modela un cliente para facilitar su identificacion en el sistema de gestion, contiene un nombre, direccion, numero de identificacion y un carrito de comprar para almacenar los productos previos a su compra.
 */
public class Cliente {
    private String nombre;
    private String direccion;
    @EqualsAndHashCode.Include
    private String nIdentificacion;
    private CarritoCompras carritoCompras;
}
