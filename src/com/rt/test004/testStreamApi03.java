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
 * ��ֹ����
 */
public class testStreamApi03 {
	/*
	 * ������ƥ��
	 * allMatch--����Ƿ�ƥ������Ԫ��
	 * anyMatch--����Ƿ�����ƥ��һ��Ԫ��
	 * noneMatch--����Ƿ�û��ƥ������Ԫ��
	 * findFirst--���ص�һ��Ԫ��
	 * findAny--���ص�ǰ���е���һԪ��
	 * count--��������Ԫ�ص��ܸ���
	 * max--�����������ֵ
	 * min--����������Сֵ
	 */
	/*
	 * ��Լ
	 * reduce(T identity, BinaryOperator) /reduce(BinaryOperator) --���Խ�����Ԫ�ط�������������õ�һ��ֵ��
	 */
	/*
	 * �ռ�
	 * collect--����ת��Ϊ������ʽ������һ��collector�ӿڵ�ʵ�֣����ڸ�stream��Ԫ�������ܵķ���
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
//		 * ������ƥ��
//		 * allMatch--����Ƿ�ƥ������Ԫ��
		boolean res1 = users.stream().allMatch((u) -> u.getId() > 0);
		System.out.println(res1);
		System.out.println("----------------------------------");
//		 * anyMatch--����Ƿ�����ƥ��һ��Ԫ��
		boolean res2 = users.stream().anyMatch((u) -> u.getAge() == 18);
		System.out.println(res2);
		System.out.println("----------------------------------");
//		 * noneMatch--����Ƿ�û��ƥ������Ԫ��
		boolean noneMatch = users.stream().noneMatch((u) -> u.getName().equals("edf"));
		System.out.println(noneMatch);
		System.out.println("----------------------------------");
//		 * findFirst--���ص�һ��Ԫ��
		Optional<User> findFirst = users.stream().findFirst();
		System.out.println(findFirst.get());
		System.out.println("----------------------------------");
//		 * findAny--���ص�ǰ���е���һԪ��
		Optional<Status> findAny = users.stream().map(User::getStatus).findAny();
		System.out.println(findAny.get());
		System.out.println("----------------------------------");
//		 * count--��������Ԫ�ص��ܸ���
		long count = users.stream().count();
		System.out.println(count);
		System.out.println("----------------------------------");
//		 * max--�����������ֵ
		Optional<User> max = users.stream().max((u1,u2) -> Integer.compare(u1.getAge(), u2.getAge()));
		System.out.println(max.get());
		System.out.println("----------------------------------");
//		 * min--����������Сֵ
		Optional<User> min = users.stream().min((u1,u2) -> Integer.compare(u1.getAge(), u2.getAge()));
		System.out.println(min.get());
	}
	
	/*
	 * ��Լ
	 * reduce(T identity, BinaryOperator) /reduce(BinaryOperator) --���Խ�����Ԫ�ط�������������õ�һ��ֵ��
	 */
	@Test
	public void test02(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer reduce = list.stream().reduce(0,(x,y)->x+y);
		System.out.println(reduce);
		
		Optional<Integer> reduce2 = users.stream().map(User::getAge).reduce(Integer::sum);
		System.out.println(reduce2);
		
	}
	//collect--����ת��Ϊ������ʽ������һ��collector�ӿڵ�ʵ�֣����ڸ�stream��Ԫ�������ܵķ���
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
		//����
		Long collect = users.stream().collect(Collectors.counting());
		System.out.println(collect);
		//ƽ��ֵ
		Double collect2 = users.stream().collect(Collectors.averagingInt(User::getAge));
		System.out.println(collect2);
		//�ܺ�
		IntSummaryStatistics collect3 = users.stream().collect(Collectors.summarizingInt(User::getAge));
		System.out.println(collect3.getSum());
		//���ֵ
		Optional<User> collect4 = users.stream().collect(Collectors.maxBy((u1,u2)->Integer.compare(u1.getAge(), u2.getAge())));
		System.out.println(collect4.get());
		//��Сֵ
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
		//����   
		//����״̬����
		Map<Status, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getStatus));
		System.out.println(collect);
		System.out.println("---------------------------");
		//�Ȱ�״̬�ڰ����������
		Map<Status, Map<String, List<User>>> collect2 = users.stream().collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy(
					(user) -> {
						if(((User) user).getAge()<=35){
							return "����";
						}else if(user.getAge()<=50){
							return "����";
						}else{
							return "����";
						}
					})));
		System.out.println(collect2);
	}
	
	//����
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
