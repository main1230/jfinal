package com.jfinal.zzl.utils;

public class StringUitls {
	
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.equals(""))
			return true;
		else 
			return false;
	}

}
