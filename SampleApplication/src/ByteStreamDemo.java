import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo {
	public static void byteReadWriteWork(File fromFile, File toFile) throws IOException{
		FileInputStream src=new FileInputStream(fromFile);
		
		int a=0;
		while((a=src.read())!=-1){
			System.out.println((char)a);
		}
		
	}
}
