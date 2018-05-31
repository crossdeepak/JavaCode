package com.cg.pay.services;

import com.cg.pay.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public interface PayrollServices {

	int acceptAssociateDetails(String firstName, String lastName, String emailId, String department, String designation,
			String pancard, int yearlyInvestmentUnder80C, float basicSalary, float epf, float companyPf,
			int accountNumber, String bankName, String ifscCode)throws PayrollServicesDownException;

	float calculateNetSalary(int associateID)throws AssociateDetailsNotFoundException,PayrollServicesDownException;
	
	boolean deleteAssociateDetails(int associateID)throws PayrollServicesDownException;

	Associate getAssociateDetails(int associateID)throws AssociateDetailsNotFoundException, PayrollServicesDownException;

	Associate[] getAllAssociateDetails()throws PayrollServicesDownException;

}