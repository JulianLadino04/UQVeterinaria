package co.edu.uniquindio.labCollections.persitence;

import co.edu.uniquindio.labCollections.utils.PersistenceService;
import co.edu.uniquindio.labCollections.utils.PersistenceServiceJSON;

public class PruebaPersistencia {

	public static void main(String[] args) {
		PersistenceService persistor = new PersistenceServiceJSON();
		Persona persona = new Persona("Juan", 20, false);
		try {
			persistor.serialize(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
