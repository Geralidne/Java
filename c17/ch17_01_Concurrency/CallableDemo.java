/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CallableDemo {
    
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Set> f1 = es.submit(new Lotto("F1"));
        Future<Set> f2 = es.submit(new Lotto("F2"));
        Future<Set> f3 = es.submit(new Lotto("F3"));
        
        try {
            System.out.println("f1.isDone()：" + f1.isDone());
            System.out.println("f2.isDone()：" + f2.isDone());
            System.out.println("f3.isDone()：" + f3.isDone());
            System.out.println("F1：" + f1.get());
            System.out.println("F2：" + f2.get());
            System.out.println("F3：" + f3.get());
            System.out.println("f1.isDone()：" + f1.isDone());
            System.out.println("f2.isDone()：" + f2.isDone());
            System.out.println("f3.isDone()：" + f3.isDone());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        } 
        
        es.shutdown();
        System.out.println("列印完成");        
        
    }
}

//----------------------------------------

class Lotto implements Callable<Set>{
    
    private String name;
    
    public Lotto(String name){
        this.name = name;
    }

    @Override
    public Set call() throws Exception {
        Set<Integer> lotto = new TreeSet();
        Random random = new Random();
        
        while(lotto.size() < 6){
            Thread.sleep(random.nextInt(1234));
            int num = random.nextInt(49) + 1;
            System.out.printf("%s\t%02d\t%b%n", name, num, lotto.add(num));
        }
        
        return lotto;
    }
    
}

/*
Runnable和Callable的區別是，
(1)Callable規定的方法是call(),Runnable規定的方法是run().
(2)Callable在執行後可返回值，而Runnable在執行後不能返回值
(3)call方法可以拋出異常，run方法不可以
(4)執行Callable會返回Future物件，表示非同步計算的結果。它提供了檢查計算是否完成的方法，以等待計算的完成，並檢索計算的結果。
   通過Future物件可以瞭解執行情況，可取消執行，還可獲取執行結果。
*/
