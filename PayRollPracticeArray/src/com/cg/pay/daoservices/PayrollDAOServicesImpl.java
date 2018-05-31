package com.cg.pay.daoservices;

import java.util.Arrays;

import com.cg.pay.beans.Associate;


public class PayrollDAOServicesImpl implements PayrollDAOServices {

	private static Associate [] associateList=new Associate[10];
	private static int ASSOCIATE_ID_COUNTER=111;
	private static int ASSOCIATE_IDX_COUNTER=0;

	/* (non-Javadoc)
	 * @see com.cg.pay.daoservices.PayrollDAOServices#insertAssociate(com.cg.pay.beans.Associate)
	 */
	@Override
	public int insertAssociate(Associate associate){
		if(ASSOCIATE_IDX_COUNTER>70*associateList.length/100){
			Associate[]tempList;
			tempList=Arrays.copyOf(associateList, 10+associateList.length);
			associateList=tempList;
		}
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associateList [ASSOCIATE_IDX_COUNTER++]=associate;
		System.out.println(ASSOCIATE_IDX_COUNTER);
		return associate.getAssociateID();
	}
	/* (non-Javadoc)
	 * @see com.cg.pay.daoservices.PayrollDAOServices#updateAssociate(com.cg.pay.beans.Associate)
	 */
	@Override
	public boolean updateAssociate(Associate associate){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i].getAssociateID()==associate.getAssociateID()){
				associateList[i]=associate;
				return true;
			}
		return false;
	}
	/* (non-Javadoc)
	 * @see com.cg.pay.daoservices.PayrollDAOServices#deleteAssociate(int)
	 */
	@Override
	public boolean deleteAssociate(int associateID){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null && associateID==associateList[i].getAssociateID()){
				associateList[i]=null;	
				for(int j=i;j<associateList.length-1;j++){
					associateList[j]=associateList[j+1];
					associateList[j+1]=null;
				}
					ASSOCIATE_IDX_COUNTER--;
					System.out.println(ASSOCIATE_IDX_COUNTER);
				return true;
			}
		return false;
	}
	/* (non-Javadoc)
	 * @see com.cg.pay.daoservices.PayrollDAOServices#getAssociate(int)
	 */
	@Override
	public Associate getAssociate(int associateID){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null && associateList[i].getAssociateID()==associateID){
				return associateList[i];
			}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.cg.pay.daoservices.PayrollDAOServices#getAssociates()
	 */
	@Override
	public Associate [] getAssociates(){
		return associateList;
	}
	
}
