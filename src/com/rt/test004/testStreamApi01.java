package com.rt.test004;

import java.util.ArrayList;
import java.util.Arrays;
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
public class testStreamApi01 {

	//创建Stream
	@Test
	public void test01(){
		//1.可以通过Collection系列集合提供的stream()或parallelStream()
		List<String> li = new ArrayList<>();
		Stream<String> stream1 = li.stream();
		//2.通过Arrays中的静态方法stream()获取数组流
		Node[] node  = new Node[10];
		Stream<Node> stream2 = Arrays.stream(node);
		//3.通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("a","b","c");
		//4.创建无线流
		//迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x)->x+2);
		stream4.limit(10).forEach(System.out::println);
		//生成
		Stream.generate(() ->Math.random())
			  .limit(5)
			  .forEach(System.out::println);
	}
}
