/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sample;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author User
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p1 = new Person.Builder().build();
        System.out.println("p1：" + p1);
        
        Person p2 = new Person.Builder()
                              .name("Amy")
                              .city("台北")
                              .age(18)
                              .email("amy@xxx.xxx")
                              .build();
        System.out.println("p2：" + p2);
        
        Person p3 = new Person.Builder().name("Lisa").age(20).build();
        System.out.println("p3：" + p3);
        System.out.println("-------------------------");
        
        List<Person> list = Person.createList();
        System.out.println(list);
        
        // Consumer 消費型：有參數、沒有回傳值
        // Consumer<T> 的 accept(T t) 方法接收一個參數，執行後無回傳值
        Consumer<Person> action = p -> System.out.println(p);
        list.forEach(action);
        System.out.println("---------------------");
        list.forEach(p -> System.out.println(p));
        System.out.println("---------------------");
        
        // Predicate 診斷型：有參數、有回傳 boolean
        // Predicate<T> 的 test(T t) 方法接收一個參數回傳 boolean
        Predicate<Person> olderThan25 = p -> p.getAge() >= 25;
        for(Person p : list){
            if(olderThan25.test(p)){
                System.out.println(p);
            }
        }
        System.out.println("---------------------");
        list.stream().filter(olderThan25).forEach(System.out::println);
        System.out.println("---------------------");
        
        // Function 功能型：有參數、有回傳值
        // Function<T,R> 的 apply(T t) 方法接收一個參數，執行後回傳指定型態的結果
        Function<Person, String> getPersonName = p -> p.getName();
        for(Person p : list){
            System.out.println(getPersonName.apply(p));
        }
        System.out.println("---------------------");
        list.stream().map(getPersonName).forEach(System.out::println);
        System.out.println("---------------------");        
        
        // Supplier 供應型：沒有參數、有回傳值
        // Supplier<T> 的 get() 方法用來回傳特定的結果，回傳值的型態必須同呼叫的方法的回傳型態
        Supplier<Person> personSupplier = () -> new Person.Builder().name("Gjun").email("gjun@xxx.xxx").build();
        System.out.println(personSupplier.get());
        System.out.println("---------------------");
        
        
        // 補充
        // BiConsumer：有 2 個參數、無回傳值
        // BiConsumer<T, U> 的 accept(T t, U u);傳入 2 個參數、無回傳值
        
        HashMap<String, String> map = new HashMap();
        map.put("A01", "小明");
        map.put("D03", "Amy");
        map.put("B07", "Jason");
        map.put("D01", "小花");
        map.put("C05", "Lisa");
        
        map.forEach((k, v) -> System.out.printf("%s\t%s%n", k, v));
        
        
    }
    
}
