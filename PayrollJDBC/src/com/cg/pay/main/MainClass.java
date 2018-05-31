package com.cg.pay.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.services.PayrollServices;
import com.cg.pay.services.PayrollServicesImpl;
import com.cg.pay.utility.PayrollUtility;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class MainClass {

	public static void main(String[] args) throws PayrollServicesDownException, AssociateDetailsNotFoundException {			

		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		PayrollServices payrollServices=(PayrollServices) applicationContext.getBean("payrollServices");
	//	payrollServices.acceptAssociateDetails("SK", "Fallen", "abc@gmail.com", "Trainee", "A4", "ABNH144", 10000, 30000, 2000, 1000, 200001, "CITI", "CITI005");
	//	payrollServices.updateAssociateDetails(new Associate(11, 80000, "VP", "TaZ", "qw", "yt", "gsd", "ewrw@da.com", new Salary(20000, 1000, 1000, 1000, 2000, 3000, 1500, 1600, 500, 20000, 60000), new BankDetails(1231412, "CITI", "citi")));		
		payrollServices.deleteAssociateDetails(9);
}}
	



/*try{
	PayrollServices services=new PayrollServicesImpl();
	PayrollUtility.getDBConnection();
	System.out.println("Connection Open");
//	services.acceptAssociateDetails("Rahul", "Muraree", "abc@gmail.com", "Trainee", "A4", "ABNH144", 10000, 30000, 2000, 1000, 200001, "CITI", "CITI005");
//	services.updateAssociateDetails(new Associate(3, 100000, "Rahul", "Muraree", "AB", "PT", "ASD123", "day@gmail.com", new Salary(20000, 2000, 1000), new BankDetails(12344, "CITI", "CITI006")));
	services.deleteAssociateDetails(2);
//	System.out.println(services.getAssociateDetails(1));
//	System.out.println(services.getAllAssociateDetails());
	System.out.println("Success");
}
catch(PayrollServicesDownException e){
	e.printStackTrace();
}*/








/*	try{
PayrollServices payrollServices = new PayrollServicesImpl();
int associateId;
int key=0;
Scanner sc=new Scanner(System.in);
while(key!=7){
	System.out.println("Enter\n1 : Insert New employee"+"\n"+"2 : Update Associate Details"+"\n"+
			"3 : To get Associate Details of employee"+"\n"+
			"4 : To get  All Associate Details of employee"+"\n"+"5 : To Calculate salary of employee"+"\n"+
			"6 : To delete an employee"+"\n"+"7 : Exit");
	key=sc.nextInt();
	switch(key){
	case 1: System.out.println("Enter First Name : ");
	String firstName=sc.next();
	System.out.println("Enter Last Name");
	String lastName=sc.next();
	System.out.println("Enter Designation");
	String designation=sc.next();
	System.out.println("Enter Department");
	String department=sc.next();
	System.out.println("Enter Pancard Number");
	String pancard=sc.next();
	System.out.println("Enter EmailId");
	String emailId=sc.next();
	System.out.println("Enter YearlyInvestment");
	int yearlyInvestmentUnder80C=sc.nextInt();
	System.out.println("Enter Basic Salary");
	float basicSalary=sc.nextFloat();
	System.out.println("Enter epf");
	float epf=sc.nextFloat();
	System.out.println("Enter cpf");
	float companyPf=sc.nextFloat();
	System.out.println("Enter Account number");
	int accountNumber=sc.nextInt();
	System.out.println("Enter Bank Name");
	String bankName=sc.next();
	System.out.println("Enter IFSC Code");
	String ifscCode=sc.next();
	associateId=payrollServices.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder80C, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);
	System.out.println(associateId);
	break;
	case 2: System.out.println("Enter the Details to be Updated");
	System.out.println("Enter Associate ID : ");
	int id=sc.nextInt();
	System.out.println("Enter First Name : ");
	String firstName1=sc.next();
	System.out.println("Enter Last Name");
	String lastName1=sc.next();
	System.out.println("Enter Designation");
	String designation1=sc.next();
	System.out.println("Enter Department");
	String department1=sc.next();
	System.out.println("Enter Pancard Number");
	String pancard1=sc.next();
	System.out.println("Enter EmailId");
	String emailId1=sc.next();
	System.out.println("Enter YearlyInvestment");
	int yearlyInvestmentUnder80C1=sc.nextInt();
	System.out.println("Enter Basic Salary");
	float basicSalary1=sc.nextFloat();
	System.out.println("Enter epf");
	float epf1=sc.nextFloat();
	System.out.println("Enter cpf");
	float companyPf1=sc.nextFloat();
	System.out.println("Enter Account number");
	int accountNumber1=sc.nextInt();
	System.out.println("Enter Bank Name");
	String bankName1=sc.next();
	System.out.println("Enter IFSC Code");
	String ifscCode1=sc.next();
	payrollServices.updateAssociateDetails(new Associate(id, yearlyInvestmentUnder80C1, firstName1, lastName1, department1, designation1, pancard1, emailId1, new Salary(basicSalary1, epf1, companyPf1), new BankDetails(accountNumber1, bankName1, ifscCode1)));
	System.out.println("Updated Values");
	System.out.println(payrollServices.getAssociateDetails(id).toString());
	break;
	case 3: System.out.println("Enter the AssociateId of employee to get the Details");
	associateId=sc.nextInt();
	System.out.println(payrollServices.getAssociateDetails(associateId).toString());
	break;
	case 4: System.out.println("Following are the Employee details of Entire Array");
	List<Associate> associate=payrollServices.getAllAssociateDetails();
	for(Associate associate1:associate)
	System.out.println(associate1);
	break;
	case 5: System.out.println("Enter the AssociateId of employee to calculate the salary");
	associateId=sc.nextInt();
	System.out.println(payrollServices.calculateNetSalary(associateId));
	break;
	case 6: System.out.println("Enter the AssociateId of employee to be deleted");
	associateId=sc.nextInt();
	System.out.println(payrollServices.deleteAssociateDetails(associateId));
	case 7: System.out.println("Exit");
	break;
	default:
	break;
	}
}
}
}
catch(AssociateDetailsNotFoundException e){
	e.printStackTrace();
}
catch(PayrollServicesDownException e){
	e.printStackTrace();
}
catch(Exception e){
	e.printStackTrace();
}
}
*/