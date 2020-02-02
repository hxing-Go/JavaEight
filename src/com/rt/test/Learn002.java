package com.rt.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 左右遇一括号省
 * 左侧推断类型省 
 *
 */
public class Learn002 {
	@Test
	public void test02(){
		
		Consumer<String> con = x -> System.out.println(x);
		con.accept("hello ");
	}
	
	
	@Test
	public void test03(){
		Map<String,Object> map1 = new HashMap<>();
		map1.put("1", "abc");
		map1.put("2", "vfc");
		map1.put("3", "asd");
		
//		for(Map.Entry<String, Object> mm:map1.entrySet()){
//			System.out.println(mm.getKey());
//			System.out.println(mm.getValue());
//		}
		
		
	}
	
	
	
	
	
	
}
