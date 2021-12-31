package com.lzyd.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JucController {

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
//	private static Integer atomicInteger = 0;

	public static  void main(String[] args) throws InterruptedException {

		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
		map.put("ss","Ss");



		ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
//		AtomicInteger atomicInteger = new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(10);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {

//					atomicInteger++;
					for (int i = 0; i < 10000; i++) {
						System.out.println("进行中" + atomicInteger);
//						atomicInteger++;
						atomicInteger.addAndGet(1);
					}
					latch.countDown();

				}
			});
		}
		latch.await();
		System.out.println("结束时间" + simpleDateFormat.format(new Date()));
		System.out.println(atomicInteger);
	}








}
