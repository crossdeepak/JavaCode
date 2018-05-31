package com.cg.pay.daoservices;

import java.sql.SQLException;
import java.util.List;

import com.cg.pay.beans.Associate;

public interface PayrollDAOServices {

	int insertAssociate(Associate associate) throws SQLException;

	boolean updateAssociate(Associate associate) throws SQLException;

	boolean deleteAssociate(int associateID);

	Associate getAssociate(int associateID) throws SQLException;

	List<Associate> getAssociates();

}