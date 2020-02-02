package com.rt.test004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.rt.test.Node;
/*
 * 一、Stream的三个操作步骤
 * 
 * 1.创建Stream
 * 
 * 2.中间操作
 * 
 * 3.终止操作
 */
public class testStreamApi02 {
	//中间操作
	/*
	   筛选与切片
	 filter--接收Lambda，从流中排除某些元素
	 limit--截断流，使其元素不超过给定数量
	 skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
	 distinct--筛选，通过流所生成元素的hashCode()和equals去除重复元素
	 */
	
	/*
	 * 映射
	 * map--接收Lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * flatMap--一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流
	 */
	
	/*
	 * 排序
	 * sorted()---自然排序
	 * sorted(Comparator com)---定制排序
	 */
	List<Node> nodeList = Arrays.asList(
			new Node(3, "aac", 111.11),
			new Node(1, "aac", 111.11),
			new Node(4, "aad", 111.14),
			new Node(1, "aab", 111.12),
			new Node(5, "aae", 111.15)
			);
	@Test
	public void test07(){
//		List<String> li = Arrays.asList("aaa","ccc","ddd","bbb");
//		li.stream().sorted().forEach(System.out::println);
		nodeList.stream().sorted((n1,n2)->{
			if(n1.getId() == n2.getId()){
				return n1.getName().compareTo(n2.getName());
			}else{
				return Integer.compare(n1.getId(), n2.getId());
			}
		}).forEach(System.out::println);
	}
	
	@Test
	public void test01(){
		//filter--接收Lambda，从流中排除某些元素
		nodeList.stream()
				.filter((n) ->n.getId()>3)
				.forEach(System.out::println);
	}
	
	@Test
	public void test02(){
		//limit--截断流，使其元素不超过给定数量
		nodeList.stream()
				.limit(3).forEach(System.out::println);
	}
	
	@Test
	public void test03(){
		//skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
		nodeList.stream()
		.skip(3).forEach(System.out::println);
	}
	
	@Test
	public void test04(){
		//distinct--筛选，通过流所生成元素的hashCode()和equals去除重复元素
		nodeList.stream()
		.distinct().forEach(System.out::println);
	}
	
	@Test
	public void test05(){
		/**
		 * map--接收Lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		 */
		List<String> li = Arrays.asList("abc","def","ghi");
//		li.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
//		nodeList.stream().map(Node::getName).forEach(System.out::println);
		Stream<Stream<Character>> sm = 
				li.stream()
				  .map(testStreamApi02::filterCharacter);//{{a,b,c},{d,e,f},{g,h,i}}
		sm.forEach((s)->{
			s.forEach(System.out::println);
		});
	}
	@Test
	public void test06(){
		/**
		 * flatMap--一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流
		 */
		List<String> li = Arrays.asList("aaa","bbb","ccc");
		Stream<Character> sm = 
				li.stream()
				  .flatMap(testStreamApi02::filterCharacter);//{a,a,a,b,b,b,c,c,c}
		sm.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
}
