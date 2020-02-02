package com.rt.test007;

import java.util.Optional;

import org.junit.Test;

import com.rt.test004.User;

public class TestOptional {
	
	/*
	 *  Optional 容器类常用方法如下：
	 * 	Optional.of(T t) : 创建一个Optional实例
	 * 	Optional.empty() : 创建一个空的Optional实例
	 * 	Optional.ofNullable(T t):若 t 不为null,创建Optional实例，否则创建空实例
	 * 	isPresent() : 判断是否包含值
	 * 	orElse(T t) : 如果调用对象包含值则返回该值，否则返回t
	 * 	orElseGet(Supplier s) :如果调用对象包含值则返回该值，否则返回s获取的值
	 * 	map(Function f): 如果有值对其处理，则返回处理后的Optional,否则返回Optional.empty
	 * 	flatMap(Function mapper):与map类似，要求返回值必须是Optional
	 */
	@Test
	public void test01(){
		Optional<User> op = Optional.of(null);
		User u = op.get();
		System.out.println(u);
	}
	
	@Test
	public void test02(){//java.util.NoSuchElementException: No value present
		Optional<User> op = Optional.empty();
		System.out.println(op.get()); //空的Optional
	}
	
	@Test
	public void test03(){
		Optional<User> op = Optional.ofNullable(new User());
		System.out.println(op.get());
//		System.out.println(op.isPresent());
	}
	
	@Test
	public void test04(){
		User u = new User();
		Optional<User> op = Optional.ofNullable(null);
		User user = op.orElse(new User(1,"a",12));
		System.out.println(user);
		
	}
	
	
	
	
	
	
}
