package com.rt.test009;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTime {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Callable<Date> task = new Callable<Date>() {
			
			@Override
			public Date call() throws Exception {
//				return sdf.parse("20200202");
				return DateFormateThreadLocal.convert("20200202");
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> results = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			results.add(pool.submit(task));
		}
		for(Future<Date> future : results){
			System.out.println(future.get());
		}
		
		pool.shutdown();*/
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			
			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20200202",dtf);
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<LocalDate>> results = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			results.add(pool.submit(task));
		}
		for(Future<LocalDate> future : results){
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}

}
