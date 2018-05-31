package com.cg.services;

import com.cg.exception.InValidNoRangeException;

public interface MathServices {
	public abstract int add(int n1,int n2) throws InValidNoRangeException;
	int subs(int n1, int n2)throws InValidNoRangeException;
	int div(int n1,int n2)throws InValidNoRangeException;
}
