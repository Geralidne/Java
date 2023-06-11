/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
public class CopyOnWriteArrayListDemo {
    
    public static void main(String[] args) {
        // 非執行緒安全操作
        // ArrayList<String> list = new ArrayList(Arrays.asList("M1", "M2", "M3", "M4", "M5"));
        
        // 執行緒安全操作
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList(Arrays.asList("M1", "M2", "M3", "M4", "M5"));
        
        // 建立執行緒池管理啟動 新增元素、移除元素 的執行緒
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=1; i<3; i++){
            es.execute(new Add(list));
            es.execute(new Remove(list));
        }        
        
        // 顯示集合資料
        for(String s : list){
            System.out.printf("M-%d\t%s%n", Thread.currentThread().getId(), s);
        }
        
        es.shutdown();
        
    }
}

//------------------------------

class Add implements Runnable{
    
    private List<String> list;
    
    public Add(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=1; i<3; i++){
            list.add(String.format("A%d-%d", Thread.currentThread().getId(), i));
            System.out.println("A：" + Thread.currentThread().getId() + "：" + list);
        }
    }
    
}

//-----------------------------------

class Remove implements Runnable{
    private List<String> list;
    
    public Remove(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        list.remove(0);
        System.out.println("R：" + Thread.currentThread().getId() + "：" + list);
    }
} 
