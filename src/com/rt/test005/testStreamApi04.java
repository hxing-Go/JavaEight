package com.rt.test005;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class testStreamApi04 {
	
	@Test
	public void test01(){
		Integer[] nums = new Integer[]{1,2,3,4,5};
		List<Integer> collect = Arrays.stream(nums).map((x)->x*x).collect(Collectors.toList());
		System.out.println(collect);
		System.out.println("=======================");
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> map = list.stream().map((x)->x*x);
		map.forEach(System.out::println);
		System.out.println("=======================");
		Optional<Integer> reduce = Arrays.stream(nums).map((x)->1).reduce(Integer::sum);
		System.out.println(reduce.get());
		System.out.println("=======================");
	}
}
