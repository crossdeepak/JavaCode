package com.cg.pay.daoservices;

import com.cg.pay.beans.Associate;

public interface PayrollDAOServices {

	int insertAssociate(Associate associate);

	boolean updateAssociate(Associate associate);

	boolean deleteAssociate(int associateID);

	Associate getAssociate(int associateID);

	Associate[] getAssociates();

}