package com.isen.base.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Isen
 * @date 2020/5/25 20:40
 * @since 1.0
 */
public class PrintABC {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
//    private static Condition[] conditions;

    private static char[] arr;

    private static int state;

    static class MyThread extends Thread {
        int no;
        int count;

        MyThread(int no, int count) {
            this.no = no;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i= 0; i < count; i++) {
                lock.lock();
                try {
                    while (state % arr.length != no) {
//                        conditions[no].await();
                        condition.await();
                    }
                    System.out.println(arr[no]);
                    state++;
                    if (state == arr.length) {
                        state = 0;
                    }
//                    conditions[(no + 1) % arr.length].signal();
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void cyclePrintArray(char[] array, int count) throws InterruptedException {
        arr = array;
//        conditions = new Condition[array.length];
        for (int i = 0; i < array.length; i++) {
//            conditions[i] = lock.newCondition();
        }
        for (int i = 0; i < array.length; i++) {
            new MyThread(i, count).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        char[] array = {'A', 'B', 'C'};
        cyclePrintArray(array, 10);
    }
}
