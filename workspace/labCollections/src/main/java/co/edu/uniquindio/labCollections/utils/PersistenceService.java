package co.edu.uniquindio.labCollections.utils;

public interface PersistenceService {
	
	static final String PATH = "src/main/resources/META-INF/";

    <T> T deserialize(String name, Class<T> entity) throws Exception;

	void serialize(String name, Object object) throws Exception;
}
