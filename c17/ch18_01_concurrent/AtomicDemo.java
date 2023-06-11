/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AtomicDemo {
    
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=1; i<=20; i++){
            es.execute(new Test());
        }
        es.shutdown();
    }
}

//---------------------------------------

class Test implements Runnable{

    private static int i = 0;
    private static AtomicInteger ai = new AtomicInteger(1); // 設定起始號碼
    private static CyclicBarrier cb = new CyclicBarrier(5);     // 5 個執行緒到位後才可以繼續執行
    
    @Override
    public void run() {
        int num = ai.getAndIncrement();
        try {
            Thread.sleep(new Random().nextInt(100));
            System.out.printf("報到序號：%02d\t%-20s選手 %02d 就定位%n", ++i, Thread.currentThread().getName(), num);
            cb.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            System.out.println(ex);
        }
        System.out.printf("#### %-20s選手 %02d 起跑%n", Thread.currentThread().getName(), num);
    }
    
    
}
