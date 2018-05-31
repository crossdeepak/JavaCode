package com.cg.simple.main;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	public static void byteReadWriteWork(File fromFile, File toFile) throws IOException{
/*		FileInputStream src=new FileInputStream(fromFile);
		FileOutputStream dest=new FileOutputStream(toFile);
		int a=0;
		while((a=src.read())!=-1){
//			System.out.print((char)a);
		dest.write(a);
			
		byte [] dataBuffer=new byte[(int)fromFile.length()];
		src.read(dataBuffer);
		dest.write(dataBuffer);
//		System.out.println(new String(dataBuffer));
		
		}
*/
		
		try(BufferedInputStream src=new BufferedInputStream(new FileInputStream(fromFile))){
			try(BufferedOutputStream dest=new BufferedOutputStream(new FileOutputStream(toFile))){
//				int a=0;
//				while((a=src.read())!=-1){
//					System.out.print((char)a);
//				dest.write(a);
					
				byte [] dataBuffer=new byte[(int)fromFile.length()];
				src.read(dataBuffer);
				dest.write(dataBuffer);
				String abc=new String(dataBuffer);
				System.out.println(abc);
		}
	}
}
}
