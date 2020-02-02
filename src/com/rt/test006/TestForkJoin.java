package com.rt.test006;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {
	
	/*
	 * ForkJoin框架
	 */
	@Test
	public void test01(){
		Instant start = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		Instant end = Instant.now();
		System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//12629
	}
	
	/*
	 * java8 并行流
	 */
	@Test
	public void test02(){
		Instant start = Instant.now();
		LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
		Instant end = Instant.now();
		System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//5154
	}
}
