package co.edu.uniquindio.labCollections.utils;

public interface PersistenceService {
	
	static final String PATH = "src/main/resources/META-INF/";

    <T> T deserialize(Class<T> entity) throws Exception;

	void serialize(Object object) throws Exception;
}
