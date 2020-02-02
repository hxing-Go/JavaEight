package com.rt.test001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.rt.test.Node;

public class testLambda {
	
	List<Node> listNode = Arrays.asList(
			new Node(1,"aa",111.11),
			new Node(4,"dd",444.44),
			new Node(1,"cc",333.33),
			new Node(2,"bb",222.22),
			new Node(5,"ee",555.55));
	@Test
	public void test01(){
		Collections.sort(listNode, (n1,n2)->{
			if(n1.getId() == n2.getId()){
				return n1.getName().compareTo(n2.getName());
			}else{
				return Double.compare(n1.getId(), n2.getId());
			}
		});
		
		
		for (Node node : listNode) {
			System.out.println(node.toString());
		}
	}
	
	
	@Test
	public void test02(){
		String resultStr = strHandler("   À²À²testb",(str)->str.trim());
		System.out.println(resultStr);
	}
	
	public String strHandler(String str,MyFunction01 fun){
		return fun.getValue(str);
	}
	
	
	@Test
	public void test03(){
		testNum(100l,200l,(x,y) -> x+y);
	}
	
	public void testNum(Long l1,Long l2,MyFunction02<Long,Long> fun){
		System.out.println(fun.getValue(l1, l2));
	}
	
	
	
	
	
	
	
	
}
