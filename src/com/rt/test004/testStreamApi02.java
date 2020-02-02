package com.rt.test004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
public class testStreamApi02 {
	//�м����
	/*
	   ɸѡ����Ƭ
	 filter--����Lambda���������ų�ĳЩԪ��
	 limit--�ض�����ʹ��Ԫ�ز�������������
	 skip(n)--����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ����������limit(n)����
	 distinct--ɸѡ��ͨ����������Ԫ�ص�hashCode()��equalsȥ���ظ�Ԫ��
	 */
	
	/*
	 * ӳ��
	 * map--����Lambda,��Ԫ��ת����������ʽ����ȡ��Ϣ������һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ�ء�
	 * flatMap--һ��������Ϊ�����������е�ÿһ��ֵ��������һ������Ȼ������������ӳ�һ����
	 */
	
	/*
	 * ����
	 * sorted()---��Ȼ����
	 * sorted(Comparator com)---��������
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
		//filter--����Lambda���������ų�ĳЩԪ��
		nodeList.stream()
				.filter((n) ->n.getId()>3)
				.forEach(System.out::println);
	}
	
	@Test
	public void test02(){
		//limit--�ض�����ʹ��Ԫ�ز�������������
		nodeList.stream()
				.limit(3).forEach(System.out::println);
	}
	
	@Test
	public void test03(){
		//skip(n)--����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ����������limit(n)����
		nodeList.stream()
		.skip(3).forEach(System.out::println);
	}
	
	@Test
	public void test04(){
		//distinct--ɸѡ��ͨ����������Ԫ�ص�hashCode()��equalsȥ���ظ�Ԫ��
		nodeList.stream()
		.distinct().forEach(System.out::println);
	}
	
	@Test
	public void test05(){
		/**
		 * map--����Lambda,��Ԫ��ת����������ʽ����ȡ��Ϣ������һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ�ء�
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
		 * flatMap--һ��������Ϊ�����������е�ÿһ��ֵ��������һ������Ȼ������������ӳ�һ����
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
