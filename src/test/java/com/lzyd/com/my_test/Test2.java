package com.lzyd.com.my_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/30]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class Test2 {
    private static Test2 test2 = new Test2();

    private int n;
    private CountDownLatch a;
    private CyclicBarrier  barrier;// 使用CyclicBarrier保证任务按组执行
    public void fooBar(int n) {
        this.n = n;
        a = new CountDownLatch(1);
        barrier = new CyclicBarrier(2);// 保证每组内有两个任务
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                a.countDown();// printFoo方法完成调用countDown
                barrier.await();// 等待printBar方法执行完成
            }
        } catch(Exception e) {}
    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                a.await();// 等待printFoo方法先执行
                printBar.run();
                a = new CountDownLatch(1); // 保证下一次依旧等待printFoo方法先执行
                barrier.await();// 等待printFoo方法执行完成
            }
        } catch(Exception e) {}
    }


    public static void main(String[] args) throws InterruptedException {
        test2.fooBar(1);
        new Thread(() -> {
            try {
                test2.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fooBar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                test2.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }










}
