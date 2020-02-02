package com.rt.test004;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.rt.test004.User.Status;

/*
 * 终止操作
 */
public class testStreamApi03 {
	/*
	 * 查找与匹配
	 * allMatch--检查是否匹配所有元素
	 * anyMatch--检查是否至少匹配一个元素
	 * noneMatch--检查是否没有匹配所有元素
	 * findFirst--返回第一个元素
	 * findAny--返回当前流中的任一元素
	 * count--返回流中元素的总个数
	 * max--返回流中最大值
	 * min--返回流中最小值
	 */
	/*
	 * 规约
	 * reduce(T identity, BinaryOperator) /reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个值。
	 */
	/*
	 * 收集
	 * collect--将流转化为其他形式。接收一个collector接口的实现，用于给stream中元素做汇总的方法
	 */
//	List<User> users = Arrays.asList(
//			new User(1,"aaa",18,Status.BUSY),
//			new User(2,"bbb",28,Status.FREE),
//			new User(3,"ccc",38,Status.VOVATION),
//			new User(4,"ddd",48,Status.BUSY),
//			new User(5,"eee",58,Status.FREE),
//			new User(6,"fff",68,Status.VOVATION),
//			new User(7,"aaa",38,Status.FREE)
//			);
	
	@Test
	public void test01(){
//		 * 查找与匹配
//		 * allMatch--检查是否匹配所有元素
		boolean res1 = users.stream().allMatch((u) -> u.getId() > 0);
		System.out.println(res1);
		System.out.println("----------------------------------");
//		 * anyMatch--检查是否至少匹配一个元素
		boolean res2 = users.stream().anyMatch((u) -> u.getAge() == 18);
		System.out.println(res2);
		System.out.println("----------------------------------");
//		 * noneMatch--检查是否没有匹配所有元素
		boolean noneMatch = users.stream().noneMatch((u) -> u.getName().equals("edf"));
		System.out.println(noneMatch);
		System.out.println("----------------------------------");
//		 * findFirst--返回第一个元素
		Optional<User> findFirst = users.stream().findFirst();
		System.out.println(findFirst.get());
		System.out.println("----------------------------------");
//		 * findAny--返回当前流中的任一元素
		Optional<Status> findAny = users.stream().map(User::getStatus).findAny();
		System.out.println(findAny.get());
		System.out.println("----------------------------------");
//		 * count--返回流中元素的总个数
		long count = users.stream().count();
		System.out.println(count);
		System.out.println("----------------------------------");
//		 * max--返回流中最大值
		Optional<User> max = users.stream().max((u1,u2) -> Integer.compare(u1.getAge(), u2.getAge()));
		System.out.println(max.get());
		System.out.println("----------------------------------");
//		 * min--返回流中最小值
		Optional<User> min = users.stream().min((u1,u2) -> Integer.compare(u1.getAge(), u2.getAge()));
		System.out.println(min.get());
	}
	
	/*
	 * 规约
	 * reduce(T identity, BinaryOperator) /reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test02(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer reduce = list.stream().reduce(0,(x,y)->x+y);
		System.out.println(reduce);
		
		Optional<Integer> reduce2 = users.stream().map(User::getAge).reduce(Integer::sum);
		System.out.println(reduce2);
		
	}
	//collect--将流转化为其他形式。接收一个collector接口的实现，用于给stream中元素做汇总的方法
	@Test
	public void test03(){
		List<String> collect = users.stream().map(User::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);
		System.out.println("===========================");
		Set<String> collect2 = users.stream().map(User::getName).collect(Collectors.toSet());
		collect2.forEach(System.out::println);
		System.out.println("===========================");
		HashSet<String> collect3 = users.stream().map(User::getName).collect(Collectors.toCollection(HashSet::new));
		collect3.forEach(System.out::println);
	}
	@Test
	public void test04(){
		//总数
		Long collect = users.stream().collect(Collectors.counting());
		System.out.println(collect);
		//平均值
		Double collect2 = users.stream().collect(Collectors.averagingInt(User::getAge));
		System.out.println(collect2);
		//总和
		IntSummaryStatistics collect3 = users.stream().collect(Collectors.summarizingInt(User::getAge));
		System.out.println(collect3.getSum());
		//最大值
		Optional<User> collect4 = users.stream().collect(Collectors.maxBy((u1,u2)->Integer.compare(u1.getAge(), u2.getAge())));
		System.out.println(collect4.get());
		//最小值
		Optional<User> collect5 = users.stream().collect(Collectors.minBy((u1,u2)->Integer.compare(u1.getAge(), u2.getAge())));
		System.out.println(collect5.get());
	}
	List<User> users = Arrays.asList(
			new User(1,"aaa",18,Status.BUSY),
			new User(2,"bbb",28,Status.FREE),
			new User(3,"ccc",38,Status.VOVATION),
			new User(4,"ddd",48,Status.BUSY),
			new User(5,"eee",58,Status.FREE),
			new User(6,"fff",68,Status.VOVATION),
			new User(7,"aaa",38,Status.FREE)
			);
	@Test
	public void test05(){
		//分组   
		//按照状态分组
		Map<Status, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getStatus));
		System.out.println(collect);
		System.out.println("---------------------------");
		//先按状态在按照年龄分组
		Map<Status, Map<String, List<User>>> collect2 = users.stream().collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy(
					(user) -> {
						if(((User) user).getAge()<=35){
							return "青年";
						}else if(user.getAge()<=50){
							return "中年";
						}else{
							return "老年";
						}
					})));
		System.out.println(collect2);
	}
	
	//分区
	@Test
	public void test06(){
		Map<Boolean, List<User>> collect = users.stream().collect(Collectors.partitioningBy((u)->u.getAge() > 38));
		System.out.println(collect);
	}
	
	@Test
	public void test07(){
		IntSummaryStatistics collect = users.stream().collect(Collectors.summarizingInt(User::getAge));
		System.out.println(collect.getMax());
		System.out.println(collect.getMin());
		System.out.println(collect.getSum());
		System.out.println(collect.getAverage());
		System.out.println(Math.floor(collect.getAverage()));
		System.out.println(Math.round(42.578));
	}
	
	@Test
	public void test08(){
		String collect = users.stream().map(User::getName).collect(Collectors.joining(",","---","==="));
		System.out.println(collect);
	}
	
}
