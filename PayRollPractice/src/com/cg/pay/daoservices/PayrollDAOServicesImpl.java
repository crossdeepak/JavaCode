package com.cg.pay.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.pay.beans.Associate;


public class PayrollDAOServicesImpl implements PayrollDAOServices {

	private static int ASSOCIATE_ID_COUNTER=111;

	public static HashMap<Integer,Associate> associates=new HashMap<>();

	@Override
	public int insertAssociate(Associate associate){
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associates.put(associate.getAssociateID(),associate);
		return associate.getAssociateID();
	}

	@Override
	public boolean updateAssociate(Associate associate){
		if(associates.containsKey(associate.getAssociateID())==true){
			associates.put(associate.getAssociateID(),associate);
			associate.setAssociateID(associate.getAssociateID());
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAssociate(int associateID){
		associates.remove(associateID);
		return true;
	}

	@Override
	public Associate getAssociate(int associateID){
		return associates.get(associateID);
	}

	@Override
	public List<Associate>getAssociates(){
		List<Associate> associateList=new ArrayList<Associate>(associates.values());
		return associateList;
	}

}
