import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void doSerializable(File file) throws FileNotFoundException, IOException{
		Associate associate=new Associate(1234, 20000, "Deepak", "Muraree");
		try(ObjectOutputStream dest=new ObjectOutputStream(new FileOutputStream(file))){
			dest.writeObject(associate);
		}
		System.out.println("Transferred Associate"+file.getAbsolutePath());
	}
	public static void doDeDerialization(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream src=new ObjectInputStream(new FileInputStream(file))){
			Associate associate=(Associate)src.readObject();
			System.out.println(associate);
		}
	}
}
