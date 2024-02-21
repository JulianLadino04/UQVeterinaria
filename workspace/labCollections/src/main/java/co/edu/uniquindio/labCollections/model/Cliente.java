package co.edu.uniquindio.labCollections.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String direccion;
    private String nIdentificacion;
    private CarritoCompras carritoCompras;
    
    

}
