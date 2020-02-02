package com.rt.test004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.rt.test.Node;

/*
 * һ��Stream��������������
 * 
 * 1.����Stream
 * 
 * 2.�м����
 * 
 * 3.��ֹ����
 */
public class testStreamApi01 {

	//����Stream
	@Test
	public void test01(){
		//1.����ͨ��Collectionϵ�м����ṩ��stream()��parallelStream()
		List<String> li = new ArrayList<>();
		Stream<String> stream1 = li.stream();
		//2.ͨ��Arrays�еľ�̬����stream()��ȡ������
		Node[] node  = new Node[10];
		Stream<Node> stream2 = Arrays.stream(node);
		//3.ͨ��Stream���еľ�̬����of()
		Stream<String> stream3 = Stream.of("a","b","c");
		//4.����������
		//����
		Stream<Integer> stream4 = Stream.iterate(0, (x)->x+2);
		stream4.limit(10).forEach(System.out::println);
		//����
		Stream.generate(() ->Math.random())
			  .limit(5)
			  .forEach(System.out::println);
	}
}
