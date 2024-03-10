package co.edu.uniquindio.labCollections.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersistenceServiceJSON implements PersistenceService{
	
	@Override
	public <T> T deserialize(String name, Class<T> entity) throws Exception {
		var mapper = new ObjectMapper();
		var fileIn = new FileInputStream(PATH + name + "_data.json");

		return mapper.readValue(fileIn, entity);
	}

	@Override
	public void serialize(String name, Object object) throws Exception {
		var mapper = new ObjectMapper();
		var fileOut = new FileOutputStream(PATH + name + "_data.json");
		mapper.writeValue(fileOut, object);
	}

}
