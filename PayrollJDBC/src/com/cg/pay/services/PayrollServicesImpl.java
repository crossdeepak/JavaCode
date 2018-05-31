package com.cg.pay.services;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

@Component("payrollServices")
public class PayrollServicesImpl implements PayrollServices {

	
	@Autowired
	private PayrollDAOServices daoServices;

	@Override
	public int acceptAssociateDetails(String firstName,String lastName,String emailId,String department,
			String designation,String pancard,int yearlyInvestmentUnder80C,
			float basicSalary,float epf,float companyPf,int accountNumber,String bankName,String ifscCode)
					throws PayrollServicesDownException{
		try {
			return daoServices.insertAssociate(new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode)));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException("Services are down now",e);
		}
	}
	
	@Override
	public float calculateNetSalary(int associateID)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException{
		return 0;
	}
	
	@Override
	public boolean deleteAssociateDetails(int associateID)throws PayrollServicesDownException{
		return daoServices.deleteAssociate(associateID);
	}
	
	public Associate getAssociateDetails(int associateID)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException{
		Associate associate;
		try {
			associate = daoServices.getAssociate(associateID);
			if(associate==null){
				AssociateDetailsNotFoundException ex=
						new AssociateDetailsNotFoundException("Associate details not found for "+associateID);
			throw ex;
			}
				return associate;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Associate> getAllAssociateDetails()throws PayrollServicesDownException{
		return daoServices.getAssociates();
	}
	
	@Override
	public boolean updateAssociateDetails(Associate associate) throws PayrollServicesDownException {
		try {
			return daoServices.updateAssociate(associate);
		} catch (SQLException e) {
			throw new PayrollServicesDownException("Services are down now",e);
		}
	}
	
}
