/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sample;

import com.sample.Person.City;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author User
 */
public class MainClass {
    
    private static List<Person> people = List.of(
                    new Person.Builder().city(City.Tulsa).firstName("Joe").lastName("Bloggs").age(42).build(),
                    new Person.Builder().city(City.Athens).firstName("Amy").lastName("Laverda").age(51).build(),
                    new Person.Builder().city(City.London).firstName("Bill").lastName("Gordon").age(33).build(),
                    new Person.Builder().city(City.Athens).firstName("Eric").lastName("Vincent").age(33).build(),
                    new Person.Builder().city(City.Tulsa).firstName("Eric").lastName("Dunmore").age(29).build());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(people);
        System.out.println("---------------------");
        List<Person> myList1 = people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("myList1：" + myList1);
        
        List<Person> myList2 = people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("myList2：" + myList2);
        System.out.println("---------------------");
        
        people.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)))
                .ifPresentOrElse(m -> System.out.println(m + ", " + m.getAge() + ", is oldest"),
                        () -> System.out.println("No person of max age found"));
        System.out.println("--------------------------");
        
        List<Integer> numbers = List.of(1, 2, 3, 5, 5, 4, 6, 6, 5);
        Map<Integer, Long> result1 = numbers.stream()
                .filter(i -> i > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("result1：" + result1);
        
        List<Integer> result2 = numbers.stream()
                .filter(i -> i > 3)
                .collect(Collectors.toList());
        System.out.println("result2：" + result2);
        
        HashSet<Integer> set1 = new HashSet(numbers);
        System.out.println("set1：" + set1);
        
        Set<Integer> result3 = numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("result3：" + result3);
        
        Map<Integer, Integer> result4 = Stream.of(1, 3, 5, 7, 9)
                .collect(Collectors.toMap(x -> x, x -> x * x));
        System.out.println("result4：" + result4);
        System.out.println("--------------------------");
        
        List<String> myList3 = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("myList3：" + myList3);
        
        List<String> myList4 = people.stream()
                .collect(Collectors.mapping(Person::getName, Collectors.toList()));
        System.out.println("myList4：" + myList4);
        
        List<String> myList5 = people.stream()
                .collect(Collectors.mapping(p -> p.getCity() + "：" + p.getName(), Collectors.toList()));
        System.out.println("myList5：" + myList5);
        
        
        
        
        
                
        
        
        
        
        
        
        
        
                
        
        
        
    }
    
}
