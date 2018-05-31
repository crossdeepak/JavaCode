package com.cg.pay.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.pay.beans.Salary;

public class SalaryMapper implements RowMapper<Salary>{

	@Override
	public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}

}
