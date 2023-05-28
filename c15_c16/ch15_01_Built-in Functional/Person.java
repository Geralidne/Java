/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Person {
    
    // Person 屬性
    private String name;
    private int age;
    private String email;
    private String city;
    
    // 建立接收資料的 static 內部類別，命名為 Builder
    public static class Builder{
        // Builder 屬性，要對應 Person 屬性並明確指定初始值
        private String name = "";
        private int age = 0;
        private String email = "";
        private String city = "台南";
        
        // 建立接收資料的方法，並回傳內部類別物件(return this;)
        public Person.Builder name(String var){
            // this 代表 Builder 內部類別物件
            this.name = var;
            return this;
        }
        
        public Person.Builder age(int var){
            // this 代表 Builder 內部類別物件
            this.age = var;
            return this;
        }
        public Person.Builder email(String var){
            // this 代表 Builder 內部類別物件
            this.email = var;
            return this;
        }
        public Person.Builder city(String var){
            // this 代表 Builder 內部類別物件
            this.city = var;
            return this;
        }
        
        // 資料接收後建立 Person 物件
        public Person build(){
            return new Person(this);
        }        
    }// Builder 內部類別結束
    
    // Person 建構子要指定為 private
    private Person(Builder builder){
        // 將內部類別收集到的資料指定給 Person 屬性，用來初始化 Person 物件
        // this 代表 Person 物件
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.city = builder.city;        
    }
    
    // Person getXXX()、setXXX()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", email=" + email + ", city=" + city + '}';
    }
    
    //---------------------------------------------------------------------------------    
    
    // 建立 Person 集合
    public static List<Person> createList(){
        List<Person> list = new ArrayList();
        list.add( new Person.Builder()
                              .name("Bob")
                              .age(21)
                              .email("bob@xxx.xxx")
                              .city("台中")
                              .build());
        list.add( new Person.Builder()
                              .name("Jane")
                              .age(28)
                              .email("jane@xxx.xxx")
                              .city("台南")
                              .build());
        list.add( new Person.Builder()
                              .name("John")
                              .age(31)
                              .email("john@xxx.xxx")
                              .city("高雄")
                              .build());
        list.add( new Person.Builder()
                              .name("Lisa")
                              .age(22)
                              .email("lisa@xxx.xxx")
                              .city("高雄")
                              .build());
        list.add( new Person.Builder()
                              .name("Betty")
                              .age(30)
                              .email("betty@xxx.xxx")
                              .city("台北")
                              .build());
        list.add( new Person.Builder()
                              .name("Amy")
                              .age(32)
                              .email("amy@xxx.xxx")
                              .city("台南")
                              .build());
        return list;
    }    
    
}
