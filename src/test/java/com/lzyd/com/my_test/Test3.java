package com.lzyd.com.my_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/08/01]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Test3 {
    private static Test3 test3 = new Test3();
    private ReentrantLock lock         = new ReentrantLock();
    private Condition     fooCondition = lock.newCondition();
    private Condition     barCondition = lock.newCondition();
    private int count = 1;
    private int n;

    public void fooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 1) {
                fooCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCondition.signal();
            count=2;
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 2) {
                barCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            count=1;
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test3.fooBar(100);
        new Thread(() -> {
            try {
                test3.bar(new Runnable() {
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
                test3.foo(new Runnable() {
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
