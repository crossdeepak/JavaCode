package com.cg.pay.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.pay.beans.Associate;

public class AssociateMapper implements RowMapper<Associate>{

	@Override
	public Associate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Associate associate=new Associate();
		associate.setAssociateID(rs.getInt(1));
		return associate;
	}

}
