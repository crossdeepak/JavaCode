import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		try{
			File file=new File("d:\\Associate.txt");
			SerializationDemo.doSerializable(file);
			SerializationDemo.doDeDerialization(file);
	}
		catch(Exception e){
			e.printStackTrace();
		}

}
}
