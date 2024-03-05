package co.edu.uniquindio.labCollections.persitence;

import java.util.UUID;

public class PruebaPersistencia {

	public static void main(String[] args) {
//		PersistenceService persistor = new PersistenceServiceBinary();
//		Persona persona = new Persona("Juan", 20, false);
//		Set<Persona> setsito = new HashSet<>();
//		setsito.add(persona);
//		
////		try {
////			persistor.serialize(setsito);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		try {
//			Set<Persona> setRetornado = persistor.deserialize("", HashSet.class);
//			System.out.println(setRetornado.toString());
////			Persona retornada = persistor.deserialize(Persona.class);
////			System.out.println(retornada);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String nit = UUID.randomUUID().toString();
		System.out.println(nit);
	}
}
