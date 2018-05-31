package com.cg.pay.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollUtility {
	private static Connection con=null;
	public static Connection getDBConnection() throws PayrollServicesDownException{
		try {
			if(con==null){
				Properties properties=new Properties();
				properties.load(new FileInputStream(new File(".//resource//Properties")));
				Class.forName(properties.getProperty("driver"));
				con=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user")
						,properties.getProperty("password"));
			}
			return con;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException("Services are down now",e);
		}
	}
}
