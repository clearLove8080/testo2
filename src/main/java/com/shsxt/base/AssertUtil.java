package com.shsxt.base;

public class AssertUtil {
	
	
	public static void  isTrue(Boolean flag,String msg) {
		if(flag){
			throw new ParamsException(msg);
		}
	}


}
