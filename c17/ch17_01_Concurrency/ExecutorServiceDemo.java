/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        // 建立處理固定數量的執行緒池
        ExecutorService es = Executors.newFixedThreadPool(4);       // 有 4 個櫃台
        for(int i=1; i<=15; i++){   // 有 15 位洽公民眾
            // 啟動執行緒
            es.execute(new Service(i));
        }
        es.shutdown();  // 關閉執行緒池
        
    }
}

//--------------------------------------

class Service implements Runnable{
    
    private int num;
    
    public Service(int num){
        this.num = num;
    }

    @Override
    public void run() {
        // 模擬辨理業務時間
        int time = new Random().nextInt(5000);  // 搭配 sleep(時間) 執行執行緒休眠 1000 代表 1 秒鐘
        String threadName = Thread.currentThread().getName();   // 執行緒名稱
        // System.out.println(threadName);
        System.out.printf("%02d 號來賓請到 %s 號櫃台\t%d%n", num, threadName.substring(threadName.length()-1), time );
        
        try {
            // 讓執行緒休眠(暫停)
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
       
    }
    
}

/*
newCacheThreadPool：執行緒 Pool 發現有執行緒執行完之後，會將資源回收重新的再使用。如果沒有回收的資源，那就會再去建立執行緒。

newFixThreadPool：執行緒 Pool 只會有固定數量的執行緒再執行，如果啟動的數量超過 pool 的數量那執行緒就會被放入 Queue 等待被執行。

newSingleThreadExecutor：執行緒 pool 只會有一個執行緒可以執行

newScheduledThreadPool：執行緒 pool 會按照排程去執行執行緒

newSingleThreadScheduledExecutor：執行緒 pool 只會有一個執行緒可以按照 scheduler 的排程去執行
*/
