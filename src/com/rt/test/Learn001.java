package com.rt.test;

import java.util.Arrays;
import java.util.List;

public class Learn001 {
	public static void main(String[] args) {
		List<Node> li = Arrays.asList(
				new Node(1,"aaa",111.11),
				new Node(2,"bbb",222.22),
				new Node(3,"ccc",333.33),
				new Node(4,"ddd",444.44)
				);
		li.stream()
				.filter((ex) -> ex.getSalary() >= 222.22)
				.forEach(System.out::println);
		System.out.println("-----------------------");
		li.stream().map(Node::getName).forEach(System.out::println);
	}
	
}
