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
 * 一、方法引用：若Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 * (可以理解为方法引用是Lambda表达式的另外一种变现形式) 
 *
 * 主要有三种语法形式：
 * 对象::实例方法名
 * 
 * 类::静态方法名
 * 
 * 类::实例方法名
 * 
 * 注意：
 * 	1、Lambda 体中调用方法的参数列表与返回值类型，
 *   要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *  
 *  2、若Lambda 参数列表中的第一参数是 实例方法的调用者，而第二个参数
 *   是实例方法的参数时，可以使用 ClassName::method
 *   
 * 二、构造器引用:
 * 格式
 * ClassName::new
 * 
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * 
 * 三、数组引用：
 *  
 *  Type::new;
 */
public class testLambda3 {
	//对象::实例方法名
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

	//类::静态方法名
	@Test
	public void test03(){
		Comparator<Integer> com1 = Integer::compare;
	}
	
	//类::实例方法名
	@Test
	public void test04(){
		BiPredicate<String,String> bp = (x,y)->x.equals(y);
		BiPredicate<String,String> bp1 = String::equals;
	}
	
	//构造器引用
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
	
	//数组引用  Type::new
	@Test
	public void test07(){
		Function<Integer, String[]> fun = (x)->new String[x];
		Function<Integer, String[]> fun1 = String[]::new;
		String[] strs = fun1.apply(10);
		System.out.println(strs.length);
	}

}
