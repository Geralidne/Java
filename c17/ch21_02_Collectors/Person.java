/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

/**
 *
 * @author User
 */
public class Person {
    
    // 列舉
    public enum City{
        // 列舉值
        Belfast,
        Tulsa,
        Athens,
        London;
    }
    
    // Person 屬性
    private City city;
    private String firstName;
    private String lastName;
    private int age;
    
    // 建立接收資料的 static 內部類別，命名為 Builder
    public static class Builder{
        // Builder 屬性，對應到 Person 的屬性並指定預設值
        private City city = City.London;
        private String firstName = "";
        private String lastName = "";
        private int age = 0;
        
        // 建立接收資料的方法
        public Person.Builder city(City var){
            // this 代表內部類別 Builder 物件
            this.city = var;
            return this;
        }
        
        public Person.Builder firstName(String var){
            // this 代表內部類別 Builder 物件
            this.firstName = var;
            return this;
        }
        
        public Person.Builder lastName(String var){
            // this 代表內部類別 Builder 物件
            this.lastName = var;
            return this;
        }
        
        public Person.Builder age(int var){
            // this 代表內部類別 Builder 物件
            this.age = var;
            return this;
        }
        
        // 資料接收後建立 Person 物件
        public Person build(){
            return new Person(this);
        }
        
    }// Builder 內部類別結束
    
    // Person 建構子
    // 建構子宣告 private，禁止直接其他類別 new Person 物件
    private Person(Person.Builder builder){
        // 將內部類別收集到的資料指定給 Person 的欄位，用來建立 Person 物件
        // this 代表 Person 物件
        this.city = builder.city;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;                
    }
    
    // Person 方法
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public String getInfo(){
        return String.format(("[%s, %s, %s, %d]"), city, firstName, lastName, age);
    }
    
    
    
    
}
