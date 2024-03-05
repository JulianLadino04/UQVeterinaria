package co.edu.uniquindio.labCollections.utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PersistenceServiceXML implements PersistenceService {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(String name, Class<T> entity) throws Exception {
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(PATH + name + "_data.xml"));
        Object objeto = decoder.readObject();
        decoder.close();
        
        return (T) objeto;
	}

	@Override
	public void serialize(String name, Object object) throws Exception {
//		var fileOut = new FileOutputStream(new File(PATH + object.getClass().getSimpleName() + "_data.xml"));
//		var encoder = new XMLEncoder(fileOut);
//		encoder.writeObject(object);
//		encoder.close();
		
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(PATH + name + "_data.xml"));
		System.out.println(PATH + object.getClass().getSimpleName() + "_data.xml");
        encoder.writeObject(object);
        encoder.close();
	}
}
