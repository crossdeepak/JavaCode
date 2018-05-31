package com.cg.simple.main;

import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		try{
			File file=new File("d:\\FLPDataFile.txt");
			File outFile=new File("d:\\FPLCSData.txt");
			if(!file.exists())
				file.createNewFile();
			ByteStreamDemo.byteReadWriteWork(file, outFile);
			
			
			
			
			
			/*			System.out.println(file.length());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.canExecute());
			System.out.println(file.isHidden());
			System.out.println(file.lastModified());
			System.out.println(file.isFile());
			System.out.println(file.setReadable(false));
			System.out.println(file.canRead());*/
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
