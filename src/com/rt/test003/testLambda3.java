package com.rt.test003;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.rt.test.Node;

/**
 * һ���������ã���Lambda ���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ�á��������á�
 * (�������Ϊ����������Lambda���ʽ������һ�ֱ�����ʽ) 
 *
 * ��Ҫ�������﷨��ʽ��
 * ����::ʵ��������
 * 
 * ��::��̬������
 * 
 * ��::ʵ��������
 * 
 * ע�⣺
 * 	1��Lambda ���е��÷����Ĳ����б��뷵��ֵ���ͣ�
 *   Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ��
 *  
 *  2����Lambda �����б��еĵ�һ������ ʵ�������ĵ����ߣ����ڶ�������
 *   ��ʵ�������Ĳ���ʱ������ʹ�� ClassName::method
 *   
 * ��������������:
 * ��ʽ
 * ClassName::new
 * 
 * ע�⣺��Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��г��󷽷��Ĳ����б���һ��
 * 
 * �����������ã�
 *  
 *  Type::new;
 */
public class testLambda3 {
	//����::ʵ��������
	@Test
	public void test01(){
		Consumer<String> con = System.out::println;
		con.accept("abc");
	}
	
	@Test
	public void test02(){
		Node node = new Node(1,"a",111.11);
		Supplier<String> sup = node::getName;
		System.out.println(sup.get());
	}

	//��::��̬������
	@Test
	public void test03(){
		Comparator<Integer> com1 = Integer::compare;
	}
	
	//��::ʵ��������
	@Test
	public void test04(){
		BiPredicate<String,String> bp = (x,y)->x.equals(y);
		BiPredicate<String,String> bp1 = String::equals;
	}
	
	//����������
	@Test
	public void test05(){
		Supplier<Node> sup = ()->new Node(2,"b",222.22);
		Supplier<Node> sup1 = Node::new;
		Node n1 = sup1.get();
	}
	
	@Test
	public void test06(){
		BiFunction<Integer,Double,Node> fun1 = (x,y)->new Node(x,y);
		Node no = fun1.apply(6, 66.66);
		System.out.println(no.toString());
	}
	
	//��������  Type::new
	@Test
	public void test07(){
		Function<Integer, String[]> fun = (x)->new String[x];
		Function<Integer, String[]> fun1 = String[]::new;
		String[] strs = fun1.apply(10);
		System.out.println(strs.length);
	}

}
