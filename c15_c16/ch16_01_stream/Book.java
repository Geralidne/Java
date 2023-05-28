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
public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + price + ']';
    }
    
    public static List<Book> getBookList(){
        List<Book> list = new ArrayList();
        list.add(new Book("Java SE 11", 800));
        list.add(new Book("Python 3.9", 600));
        list.add(new Book("Android 13", 800));
        list.add(new Book("MySQL", 600));
        list.add(new Book("PHP", 700));
        return list;
    }
    
}
