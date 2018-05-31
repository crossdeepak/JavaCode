package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;

public class MainClass {

	public static void main(String[] args) {
    String searchFirstName="Satish";
    Associate associate = searchAssociate(searchFirstName);
    if(associate!=null)
	System.out.println(associate.getFirstName()+" "+associate.getLastName());
    else
    	System.out.println("Associate details not found");
	}
	public static Associate searchAssociate(String firstName){
		Associate [] associates=new Associate[3];
		associates[0] = new Associate(10003, 700000, "Satish", "Mahajan", "Training", "Sr Con", "100213", "abcd@gmail.com");
		associates[1] = new Associate(10032, 750000, "Deepak", "Muraree", "Developer", "Analyst", "100233", "abdsf@gmail.com");
		for(Associate associate:associates)
			if(associate!=null && associate.getFirstName()==firstName && associate.getYearlyInvestmentUnder80C()>50000)
				return associate;
		return null;
	}
}