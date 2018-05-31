package com.cg.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.cg.exception.InValidNoRangeException;
import com.cg.services.MathServices;
import com.cg.services.MathServicesImpl;

public class MainClass {

	public static void main(String[] args) throws IOException {
		FileInputStream src=new FileInputStream(new File("d:\\ProjectProperty.property"));
		Properties p=new Properties();
		p.load(src);
//		int x=Integer.parseInt(p.getProperty("x"));
		int y=Integer.parseInt(p.getProperty("y"));
		int x=Integer.valueOf(p.getProperty("x"));
		MathServices mathServices=new MathServicesImpl();
		try{
		System.out.println(mathServices.add(x, y));
		System.out.println(mathServices.subs(50, 30));
		System.out.println(mathServices.div(10, 6));
		}
		catch(InValidNoRangeException e){
			e.printStackTrace();
		}
	}
}