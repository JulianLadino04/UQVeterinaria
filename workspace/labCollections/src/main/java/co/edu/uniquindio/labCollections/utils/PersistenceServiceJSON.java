package co.edu.uniquindio.labCollections.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PersistenceServiceJSON implements PersistenceService{
	
	@Override
	public <T> T deserialize(Class<T> entity) throws Exception {
		var mapper = new ObjectMapper();
		var fileIn = new FileInputStream(PATH + entity.getSimpleName() + "_data.xml");
		return mapper.readValue(fileIn, entity);
	}

	@Override
	public void serialize(Object object) throws Exception {
		var mapper = new ObjectMapper();
		var fileOut = new FileOutputStream(PATH + object.getClass().getSimpleName() + "_data.xml");
		mapper.writeValue(fileOut, object);
	}

}
