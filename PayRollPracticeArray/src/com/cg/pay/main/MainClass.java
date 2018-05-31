package com.cg.pay.main;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.daoservices.PayrollDAOServices;
import com.cg.pay.daoservices.PayrollDAOServicesImpl;
import com.cg.pay.services.PayrollServices;
import com.cg.pay.services.PayrollServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class MainClass {

	public static void main(String[] args) {	
		try{
	
		PayrollServices payrollServices = new PayrollServicesImpl();
		int associateID=payrollServices.acceptAssociateDetails("Deepak", "Muraree", "java", "software engg","PJH123", "deepak@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID1=payrollServices.acceptAssociateDetails("Rahul", "Muraree", "java", "software engg","PSH123", "rahul@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID2=payrollServices.acceptAssociateDetails("Raj", "Muraree", "java", "software engg","PQH123", "raj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID3=payrollServices.acceptAssociateDetails("Caj", "Muraree", "java", "software engg","PWH123", "caj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID4=payrollServices.acceptAssociateDetails("Kaj", "Muraree", "java", "software engg","PEH123", "kaj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID5=payrollServices.acceptAssociateDetails("Praj", "Muraree", "java", "software engg","RJH123", "praj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID6=payrollServices.acceptAssociateDetails("Laaj", "Muraree", "java", "software engg","PTH123", "laaj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID7=payrollServices.acceptAssociateDetails("Daaj", "Muraree", "java", "software engg","PYH123", "daaj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID8=payrollServices.acceptAssociateDetails("Maaj", "Muraree", "java", "software engg","PUH123", "maaj@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		int associateID9=payrollServices.acceptAssociateDetails("Naaj", "Muraree", "java", "software engg","PIH123", "naajk@gmail.com",55000, 35000, 500,600, 23457901,"HDFC", "HDFC1234");
		System.out.println(associateID);
		System.out.println(payrollServices.getAssociateDetails(associateID).getFirstName()); 
		System.out.println(associateID1);
		payrollServices.calculateNetSalary(associateID);
		payrollServices.deleteAssociateDetails(associateID5);
		payrollServices.deleteAssociateDetails(associateID6);
		payrollServices.deleteAssociateDetails(associateID8);
		payrollServices.deleteAssociateDetails(associateID7);
		System.out.println(payrollServices.getAssociateDetails(associateID7)); 
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getPersonalAllowance());
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getConveyenceAllowance());
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getOtherAllowance());
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getHra());
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getMonthlyTax());
		System.out.println(payrollServices.getAssociateDetails(associateID).getSalary().getNetSalary());	
		}
		catch(AssociateDetailsNotFoundException e){
			e.printStackTrace();
		}
		catch(PayrollServicesDownException e){
			e.printStackTrace();
		}
}
}

/*String searchFirstName="Deepak";
float searchBasicSalary=20000;
Associate associate = searchAssociate(searchFirstName,searchBasicSalary);
if(associate!=null)
System.out.println(associate.getFirstName()+" "+associate.getSalary().getBasicSalary());
else
	System.out.println("Associate details not found");
}
public static Associate searchAssociate(String firstName, float basicSalary){
	Associate [] associates=new Associate[3];
	associates[0] = new Associate(10003, 700000, "Satish", "Mahajan", "Training", "Sr Con", "100213", "abcd@gmail.com",new Salary(15000, 100, 100, 100, 100, 100, 100, 100, 100, 100, 10000),new BankDetails(1234, "Hdfc", "hdfc001"));
	associates[1] = new Associate(10032, 750000, "Deepak", "Muraree", "Developer", "Analyst", "100233", "abdsf@gmail.com",new Salary(45000, 100, 100, 100, 100, 100, 100, 100, 100, 100, 10000),new BankDetails(1234, "Hdfc", "hdfc001"));
	for(Associate associate:associates)
		if(associate!=null && associate.getFirstName()==firstName && associate.getYearlyInvestmentUnder80C()>50000 && associate.getSalary().getBasicSalary()>15000)
			return associate;
	return null;
}
}	
*/


/*	public static void main(String[] args) {
Associate associate = new Associate(100, 15000, "Deepak", "Muraree", "Training", "Analyst", "hgff111", "akash@gmail.com", new Salary(15000, 10, 10, 10, 10, 10, 10, 10, 10, 900, 1100), new BankDetails(111, "abc", "abc111"));
if(associate.getFirstName()=="Deepak" && associate.getSalary().getBasicSalary()>10000);
System.out.println(associate.getSalary().getBasicSalary());
}
}
*/
	