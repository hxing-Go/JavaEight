package com.rt.test008;

public class SubClass /*extends MyClass*/ implements MyFun,MyInterface{

	@Override
	public String getName() {
		return MyFun.super.getName();
	}

}
