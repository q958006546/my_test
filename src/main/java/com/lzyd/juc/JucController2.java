package com.lzyd.juc;

public class JucController2 {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		new Thread(new Runnable() {
			@Override
			public void run() {
				b.publicName = "pubThreadBBB";
				b.protectedName = "proThreadBBB";
				b.defaultName = "defThreadBBB";
				System.out.println("将 ThreadB的名字修改为：" + b.defaultName);
			}
		}).start();

		System.out.println(b);
	}
	//新建一个ThreadB.java文件
	public static class ThreadB extends Thread {
		private static ThreadLocal<String> tl = new ThreadLocal<>();
		public String publicName = "ThreadB";
		protected String protectedName = "ThreadB";
		String defaultName = "ThreadB";
		private String privateName = "ThreadB";

	}

}
