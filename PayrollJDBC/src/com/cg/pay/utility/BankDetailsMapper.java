package com.cg.pay.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.pay.beans.BankDetails;

public class BankDetailsMapper implements RowMapper<BankDetails>{

	@Override
	public BankDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}

}
