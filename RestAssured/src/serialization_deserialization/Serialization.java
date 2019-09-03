package serialization_deserialization;

import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Vanshraj.Singh
 * @theory Serialization is a process where you convert an Instance of a
 *              Class (Object of a class) into a Byte Stream. This Byte Stream
 *              can then be stored as a file on the disk or can also be sent to
 *              another computer via the network.
 * 
 *              Serializable interface is a marker interface. Which means that
 *              you does not have to implement any methods if your class derives
 *              from this interface.
 */
public class Serialization {

	public static void serializeToFile(Object classObject, String fileName) {
		try {

			// Step 1: Open a file output stream to create a file object on disk.
			// This file object will be used to write the serialized bytes of an object
			FileOutputStream fileStream = new FileOutputStream(fileName);

			// Step 2: Create a ObjectOutputStream, this class takes a files stream.
			// This class is responsible for converting the Object of any type into
			// a byte stream
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

			// Step 3: ObjectOutputStream.writeObject method takes an Object and
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.
			objectStream.writeObject(classObject);

			// Step 4: Gracefully close the streams
			objectStream.close();
			fileStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(18, 78);
		serializeToFile(rect, "rectSerialized");
	}
}
