package com.rt.test002;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 *  
 * Java8内置的四大核心函数式接口
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * Supplier<T> : 供给型接口
 * 		T get();
 * Function<T, R> :函数型接口
 * 		R apply(T t);
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 * BiFunction<T, U, R> :
 * 		R apply(T t,U u);
 * UnaryOperator<T> :
 * 		T apply(T t);
 * BinaryOperator<T> :
 * 		T apply(T t1, T t2);
 * BiConsumer<T, U>
 * 		void accept(T t, U u);
 * ToIntFunction<T>,ToLongFunction<T>,ToDoubleFunction<T>：
 * 参数类型T
 * 返回类型int,long,double...分别计算int,long,double值得函数
 * IntFunction<R>,LongFunction<R>,DoubleFunction<R>
 * 参数类型int,long,double
 * 返回类型R
 */
public class testLambda2 {

//	Consumer<T> : 消费型接口
//	  		void accept(T t);
	@Test
	public void test01(){
		happy(100d,(x) -> System.out.println("消费"+x+"元"));
	}
	public void happy(Double money,Consumer<Double> con){
		con.accept(money);
	}
	
//	Supplier<T> : 供给型接口
//			T get();
	@Test
	public void test02(){
		getNumList(5,()->  (int)(Math.random()*100));
	}
	public List<Integer> getNumList(int num,Supplier<Integer> sup){
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int num01 = sup.get();
			numList.add(num01);
		}
		return numList;
	}
	
//	Function<T, R> :函数型接口
//	 		R apply(T t);
	@Test
	public void test03(){
		int total = getValue03("abcdefg",(x)->x.length());
		System.out.println(total);
	}
	public Integer getValue03(String str,Function<String,Integer> fun){
		return fun.apply(str);
	}
	
//	Predicate<T> : 断言型接口
//	 		boolean test(T t);
	@Test
	public void test04(){
		boolean ok = isBiger(5,(x)-> x>11);
		System.out.println(ok);
	}
	
	public boolean isBiger(Integer num,Predicate<Integer> pre){
		return pre.test(num); 
	}
	
}
