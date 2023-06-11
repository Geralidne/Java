/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.util.stream.IntStream;

/**
 *
 * @author User
 */
public class ReductionDemo {
    
    public static void main(String[] args) {
        
        int sum1 = IntStream.rangeClosed(1, 10)
                    .peek(i -> System.out.printf("%3d", i))
                    .sequential()
                    .reduce(0, (sum, element) -> sum + element);
        System.out.println("\nsum1：" + sum1);
        
        int sum2 = IntStream.rangeClosed(1, 10)
                    .peek(i -> System.out.printf("%3d", i))
                    .parallel()
                    .reduce(0, Integer::sum);
        System.out.println("\nsum2：" + sum2);
                    
    }
    
}
