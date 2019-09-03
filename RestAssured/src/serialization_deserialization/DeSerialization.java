package serialization_deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * @author Vanshraj.Singh
 * @theory Deserialization process in Java, which is opposite of Serialization.
 *         In this process we will read the Serialized byte stream from the file
 *         and convert it back into the Class instance representation.
 */
public class DeSerialization {
	public static Object DeSerializeFromFileToObject(String fileName) {
		try {

			// Step 1: Create a file input stream to read the serialized content
			// of rectangle class from the file
			FileInputStream fileStream = new FileInputStream(new File(fileName));

			// Step 2: Create an object stream from the file stream. So that the content
			// of the file is converted to the Rectangle Object instance
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);

			// Step 3: Read the content of the stream and convert it into object
			Object deserializeObject = objectStream.readObject();

			// Step 4: Close all the resources
			objectStream.close();
			fileStream.close();

			// return the deserialized object
			return deserializeObject;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(18, 78);
		Serialization.serializeToFile(rect, "rectSerialized");

		Rectangle deSerializedRect = (Rectangle) DeSerializeFromFileToObject("rectSerialized");
		System.out.println("Rect area is " + deSerializedRect.Area());
	}
}
