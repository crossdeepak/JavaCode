package com.cg.pay.daoservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.utility.AssociateMapper;

@Component("payrollDAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Connection con=null;
	
	@Override
	public int insertAssociate(Associate associate) throws SQLException{
		jdbcTemplate.update("insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId) value(?,?,?,?,?,?,?)",associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId());
		int associateId=jdbcTemplate.queryForObject("select max(associateId) from associate", Integer.class);	
		jdbcTemplate.update("insert into Salary(associateId,basicSalary,epf,companyPf) value(?,?,?,?)",associateId,associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf());
		jdbcTemplate.update("insert into BankDetails(associateId,accountNumber,bankName,ifscCode) value(?,?,?,?)",associateId,associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode());
		return associateId;
		
		/*String sql = "insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId) value(?,?,?,?,?,?,?)";
			int associateId = jdbcTemplate.update(sql, new Object[] {associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId()});
			
			String sqlq="select max(associateId) from associate";
			List<Associate>jdbcq=jdbcTemplate.query(sqlq, new AssociateMapper());
			int id=jdbcq.get(0).getAssociateID();
			
			String sql1 = "insert into Salary(associateId,basicSalary,epf,companyPf) value(?,?,?,?)";
			jdbcTemplate.update(sql1, new Object[] {id,associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf()});
			String sql2 = "insert into BankDetails(associateId,accountNumber,bankName,ifscCode) value(?,?,?,?)";
			jdbcTemplate.update(sql2, new Object[] {id,associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode()});
			return associateId;*/
			
			
		}
		
		

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		jdbcTemplate.update("update Associate set yearlyInvestmentUnder80C=?,firstName=?,lastName=?,department=?,designation=?,pancard=?,emailId=? where associateId=?",associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId(),associate.getAssociateID());
		jdbcTemplate.update("update Salary set basicSalary=?, hra=?, conveyenceAllowance=?, otherAllowance=?,personalAllowance=?,monthlyTax=?,epf=?, companyPf=?,gratuity=?,grossSalary=?,netSalary=? where associateID=?",associate.getSalary().getBasicSalary(),associate.getSalary().getHra(),associate.getSalary().getConveyenceAllowance(),associate.getSalary().getOtherAllowance(),associate.getSalary().getPersonalAllowance(),associate.getSalary().getMonthlyTax(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf(),associate.getSalary().getGratuity(),associate.getSalary().getGrossSalary(),associate.getSalary().getNetSalary(),associate.getAssociateID());
		jdbcTemplate.update("update BankDetails set accountNumber=?,bankName=?,ifscCode=? where associateId=?",associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode(),associate.getAssociateID());
		return true;
		
		/*String sql = "update Associate set yearlyInvestmentUnder80C=?,firstName=?,lastName=?,department=?,designation=?,pancard=?,emailId=? where associateId=?";
		jdbcTemplate.update(sql, new Object[] {associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId(),associate.getAssociateID()});
		String sql1 = "update Salary set basicSalary=?,epf=?,companyPf=? where associateId=?";
		jdbcTemplate.update(sql1, new Object[] {associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf(),associate.getAssociateID()});
		String sql2 = "update BankDetails set accountNumber=?,bankName=?,ifscCode=? where associateId=?";
		jdbcTemplate.update(sql2, new Object[] {associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode(),associate.getAssociateID()});
		return true;*/
	}
	@Override
	public Associate getAssociate(int associateId) throws SQLException {
		PreparedStatement pstmt=con.prepareStatement("select a.associateID,a.yearlyInvestmentUnder80C,a.firstName,a.lastName,a.department,a.designation,a.pancard,a.emailId,b.accountNumber,b.bankName,b.ifscCode,s.basicSalary, s.hra, s.conveyenceAllowance, s.otherAllowance,s.personalAllowance,s.monthlyTax,s.epf,s.companyPf,s.gratuity,s.grossSalary,s.netSalary\r\n" + 
				"from Associate a inner join BankDetails b inner join Salary s \r\n" + 
				"on a.associateId=b.associateId and a.associateID=s.associateID\r\n" + 
				"where a.associateID=? ");
		pstmt.setInt(1, associateId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			try {
				return new Associate(associateId,rs.getInt("yearlyInvestmentUnder80C"), rs.getString("firstName"),rs.getString("lastName"), rs.getString("department"), rs.getString("designation"),rs.getString("pancard"),rs.getString("emailId"),new Salary(rs.getInt("basicSalary"),rs.getInt("hra"), rs.getInt("conveyenceAllowance"), rs.getInt("otherAllowance"), rs.getInt("personalAllowance"), rs.getInt("monthlyTax"), rs.getInt("epf"), rs.getInt("companyPf"), rs.getInt("gratuity"), rs.getInt("grossSalary"), rs.getInt("netSalary")), new BankDetails(rs.getInt("accountNumber"), rs.getString("bankName"), rs.getString("ifscCode")));
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return null;
	}
	@Override
	public List<Associate> getAssociates() {
		try {
			PreparedStatement pstmt=con.prepareStatement("select a.associateID,a.yearlyInvestmentUnder80C,a.firstName,a.lastName,a.department,a.designation,a.pancard,a.emailId,b.accountNumber,b.bankName,b.ifscCode,s.basicSalary, s.hra, s.conveyenceAllowance, s.otherAllowance,s.personalAllowance,s.monthlyTax,s.epf,s.companyPf,s.gratuity,s.grossSalary,s.netSalary\r\n" + 
					"from Associate a inner join BankDetails b inner join Salary s \r\n" + 
					"on a.associateId=b.associateId and a.associateID=s.associateID ");
			ResultSet rs=pstmt.executeQuery();
			List<Associate> associates=new ArrayList<>();
			while(rs.next()) {
				associates.add(new Associate(rs.getInt("associateID"),rs.getInt("yearlyInvestmentUnder80C"), rs.getString("firstName"),rs.getString("lastName"), rs.getString("department"), rs.getString("designation"),rs.getString("pancard"),rs.getString("emailId"),new Salary(rs.getInt("basicSalary"),rs.getInt("hra"), rs.getInt("conveyenceAllowance"), rs.getInt("otherAllowance"), rs.getInt("personalAllowance"), rs.getInt("monthlyTax"), rs.getInt("epf"), rs.getInt("companyPf"), rs.getInt("gratuity"), rs.getInt("grossSalary"), rs.getInt("netSalary")), new BankDetails(rs.getInt("accountNumber"), rs.getString("bankName"), rs.getString("ifscCode"))));
			}
			return associates;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	return null;
	}

	@Override
		public boolean deleteAssociate(int associateID) {
		jdbcTemplate.update("delete from Associate where associateID=?",associateID);
		return true;
		
		/*String sql = "delete from Associate where associateID=?";
		jdbcTemplate.update(sql, new Object[] {associateID});
		return true;*/
	}

}
