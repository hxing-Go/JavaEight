package com.rt.test008;

public interface MyFun {

	default String getName(){
		return "������";
	}
	
	public static String fetN(){
		return "fetN";
	}
}
