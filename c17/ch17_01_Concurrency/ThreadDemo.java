/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

/**
 *
 * @author User
 */
public class ThreadDemo {
    
    public static void main(String[] args) {
        // 建立目前執行緒物件
        Thread mainThread = Thread.currentThread();
        System.out.println("目前執行緒的名稱：" + mainThread.getName());
        System.out.println("目前執行緒ID：" + mainThread.getId());
        System.out.println("--------------");
        
        MultiThread1 mt1 = new MultiThread1("MT1");
        MultiThread1 mt2 = new MultiThread1("MT2");
        
        // 不可以直接呼叫 run()
        // mt1.run();
        // mt2.run();
        
        // 要呼叫 Thread 的 start() 先啟動執行緒
        mt1.start();
        mt2.start();
        
        System.out.println("結束!");
    }
    
}

//----------------------------------------------

class MultiThread1 extends Thread{
    private String name;

    public MultiThread1(String name) {
        this.name = name;
    }
    
    // 重新定義 run() 方法，將執行緒要執行的事情寫在 run() 方法內
    @Override
    public void run(){
        Thread currentThread = Thread.currentThread();
        for(int i=1; i<=3; i++){
            System.out.printf("%s, id：%d, %s 執行 %d 次%n", currentThread, currentThread.getId(), name, i);
        }
    }
}
