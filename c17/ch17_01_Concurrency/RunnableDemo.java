/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

/**
 *
 * @author User
 */
public class RunnableDemo {
    
    public static void main(String[] args) {
        
        MultiThread2 mt1 = new MultiThread2("MT1");
        MultiThread2 mt2 = new MultiThread2("MT2");
        
        Thread t1 = new Thread(mt1, "THREAD1");
        Thread t2 = new Thread(mt2, "THREAD2");
        
        t1.start();
        t2.start();
        
        System.out.println("結束");
        
    }
}

//-----------------------------------------

class SuperClass{}

class MultiThread2 extends SuperClass implements Runnable{
    private String name;

    public MultiThread2(String name) {
        this.name = name;
    }
    
    // 實作 run() 方法，將執行緒要執行的事情寫在 run() 方法內
    @Override
    public void run(){
        Thread currentThread = Thread.currentThread();
        for(int i=1; i<=3; i++){
            System.out.printf("%s, id：%d, %s 執行 %d 次%n", currentThread, currentThread.getId(), name, i);
        }
    }
}
