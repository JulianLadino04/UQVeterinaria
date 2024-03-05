package co.edu.uniquindio.labCollections.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenceServiceBinary implements PersistenceService{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(String name, Class<T> entity) throws Exception {
		try (ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(PATH + name + "_data.dat"))) {
			return (T)obIn.readObject();
		}
	}

	@Override
	public void serialize(String name, Object object) throws Exception {
		try (ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(PATH + name + "_data.dat"))) {
			obOut.writeObject(object);
		}
	}
}
