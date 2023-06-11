/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SynchronizedDemo {
    
    public static void main(String[] args) {
        Company company = new Company();
        Thread t1 = new Thread(company, "銷售員A");
        Thread t2 = new Thread(company, "銷售員B");
        Thread t3 = new Thread(company, "銷售員C");
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            // join() 主執行緒須等到 t1、t2、t3 執行緒執行完成，才可以繼續往下執行
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        System.out.println("--------------------------------------");
        System.out.println("balance：" + company.balance);
        
        
    }
}

//------------------------------------

class Company implements Runnable{
    
    int balance;

    @Override
    public void run() {
        for(int i=1; i<=3; i++){
            // 同步化區塊
            synchronized(this){
                int temp = balance;
                try {
                    Thread.sleep(new Random().nextInt(1234));
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                temp += 100;
                balance = temp;
                System.out.printf("%d. %s\tbalance：%d%n", i, Thread.currentThread().getName(), balance);
            }
        }
    }
    
}
