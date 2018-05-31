package com.cg.services;

import com.cg.exception.InValidNoRangeException;

public class MathServicesImpl implements MathServices{

	@Override
	public int add(int n1, int n2)throws InValidNoRangeException {
		if(n1<0)
			throw new InValidNoRangeException("Sum greater than 0");
		return n1+n2;
	}

	@Override
	public int subs(int n1, int n2) throws InValidNoRangeException{
		if(n2<0||n1<0)
			throw new InValidNoRangeException("Output less than -20");
		return n1-n2;
	}

	@Override
	public int div(int n1, int n2) throws InValidNoRangeException{
		if(n2<1||n1<0)
			throw new InValidNoRangeException("Output is 1");
		return n1/n2;
	}

}
