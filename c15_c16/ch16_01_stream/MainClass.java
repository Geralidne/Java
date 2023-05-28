/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

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
        // Stream 建立：Arrays.asList() -> stream()
        Stream<Integer> st1 = Arrays.asList(1, 3, 5, 7, 9).stream();
        System.out.println("st1：" + st1);
        // 終端操作 forEach() 取出 Stream 資料
        st1.forEach(i -> System.out.printf("%d | ", i * 10));  // 執行後 st1 已經沒有資料
        System.out.println("\n--------------------");
        // st1.forEach(i -> System.out.printf("%d | ", i * 20));  // st1 已經沒有資料，再執行取出會發生執行期錯誤 IllegalStateException
        
        // 再放入資料
        st1 = Arrays.asList(2, 4, 6, 8).stream();
        st1.forEach(i -> System.out.printf("%d | ", i / 2));
        System.out.println("\n-------------------");
        
        // Stream 建立：Stream.of()
        Stream<Integer> st2 = Stream.of(1, 2, 3, 4, 5);
        // 終端操作
        // st2.forEach(System.out::println);
        
        // 中間操作              終端操作   
        st2.filter(i -> i%2==0).forEach(i -> System.out.printf("%d | ", i));
        System.out.println("\n-------------------");
        
        // Stream 建立：Arrays.stream()
        Stream<Double> st3 = Arrays.stream(new Double[]{1.1, 2.2, 3.3});
        //               中間操作              終端操作
        double sum1 = st3.mapToDouble(d -> d).sum();
        System.out.println("sum1：" + sum1);
        
        DoubleStream st4 = Arrays.stream(new double[]{1.1, 2.2, 3.3});
        //                終端操作
        double sum2 = st4.sum();
        System.out.println("sum2：" + sum2);
        System.out.println("------------------");
        
        // 應用
        Stream<String> st5 = Stream.of("a1", "b23", "c456");  // 建立原料桶
        OptionalDouble opt = st5.map(s -> s.substring(1))   // 中間操作 取出子字串 "1" "23" "456"   加工
                                .mapToInt(s -> Integer.parseInt(s))  // 中間操作 "1"->1 "23"->23 "456"->456  加工
                                .average();                          // 終端操作 將平均值放入 OptionalDouble   成品
        // 先觀察 opt
        System.out.println("opt：" + opt);
        // 將 opt 內部的資料取出
        double average1 = opt.getAsDouble();
        System.out.println("average1：" + average1);
        
        double average2 = Stream.of("a1", "b23", "c456")
                                .map(s -> s.substring(1))   // 中間操作 取出子字串 "1" "23" "456"   加工
                                .mapToInt(s -> Integer.parseInt(s))  // 中間操作 "1"->1 "23"->23 "456"->456  加工
                                .average()                          // 終端操作 將平均值放入 OptionalDouble   成品
                                .getAsDouble();                     // 將 opt 內部的資料取出
        System.out.println("average2：" + average2);
        
        double average3 = Stream.of("a1", "b23", "c456")
                .map(s -> s.substring(1))
                .collect(Collectors.averagingInt(s -> Integer.parseInt(s)));
        System.out.println("average3：" + average3);
        System.out.println("---------------------------");
        
        Stream<String> st6 = Stream.of("java", "python", "c", "android", "php", "mysql", "c++")
                .peek(s -> System.out.printf("1. %s%n", s))  // 中間操作 peek() 窺視
                .filter(s -> s.length()>3)                             // 中間操作 filter() 保留判別為 true 的資料
                .peek(s -> System.out.printf("2. %s%n", s))  // 中間操作 peek() 窺視
                .map(s -> s.toUpperCase())                             // 中間操作 map() 收集轉換後的資料
                .peek(s -> System.out.printf("3. %s%n", s)); // 中間操作 peek() 窺視
        
        // 測試各種終端操作
        // st6.forEach(s -> System.out.printf("4. %s%n", s));
        
        // long count = st6.count();            // 終端操作 count() 計數器
        // System.out.println("count：" + count);
        
        // List<String> strList = st6.collect(Collectors.toList()); // 終端操作 collect() 收集器得到一個 List
        // System.out.println("strList：" + strList);
        
        String result = st6.collect(Collectors.joining(" - ")); // 終端操作 collect() 收集器將最後取得的資料串接指定的字串並回傳 String
        System.out.println("result：" + result);
        System.out.println("---------------------------");
        
        // 排序
        List<String> list = Arrays.asList("java", "python", "c", "android", "php", "mysql", "c++");
        System.out.println("排序前：" + list);
        System.out.println("------------------------------");
        System.out.print("自然排序：");
        list.stream().sorted().forEach(s -> System.out.printf("%s | ", s));
        System.out.println("\n------------------------------");
        System.out.print("自訂排序：");
        list.stream().sorted((s1, s2) -> s1.compareTo(s2) * -1).forEach(s -> System.out.printf("%s | ", s));
        System.out.println("\n------------------------------");
        System.out.println("排序後：" + list);
        System.out.println("------------------------------");
        
        // 定義多重排序規則
        Comparator<Book> compBook = Comparator.comparing(Book::getPrice) // 先比較價格
                                              .thenComparing(Book::getName) // 價格相同時再比較書名
                                              .reversed();      // 降冪排序
        
        List<Book> bookList = Book.getBookList();
        bookList.stream()
                .sorted(compBook)
                .forEach(System.out::println);
        System.out.println("------------------------------");
        
        // 分組
        List<String> items = Arrays.asList("apple", "banana", "orange", "kiwi", "banana", "apple");
        // 使用 Stream 時，要將它轉換成其他容器或 Map，可以使用 Function.identity()
        // Function.identity() 回傳一個輸出跟輸入一樣的 Lambda 表達式物件，同 t -> t 形式的 Lambda 表達式
        Map<String, List<String>> group1 = items.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println("group1：" + group1);
        
        Map<String, Long> group2 = items.stream().collect(Collectors.groupingBy(t -> t , Collectors.counting()));
        System.out.println("group2：" + group2);
        System.out.println("------------------------------");
        
        // 將集合依條件分成兩組
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitionMap = intList.stream().collect(Collectors.partitioningBy(i -> i%2==0));
        System.out.println("partitionMap：" + partitionMap);
        System.out.println("奇數：" + partitionMap.get(false));
        System.out.println("偶數：" + partitionMap.get(true));
        System.out.println("------------------------------");
        
        // 攤平 flatMap()
        // 建立檔案物件
        Path file = new File("star.txt").toPath();
        
        long matches;
        
        try{
            matches = Files.lines(file)
                    .peek(line -> System.out.println("1. " + line))
                    .flatMap(line -> Stream.of(line.split(", |,|\\.|!| ")))
                    .peek(word -> System.out.println("2. " + word))
                    .filter(word -> word.equals("twinkle"))
                    .peek(word -> System.out.println("3. match：" + word))
                    .count();
            System.out.println("matches：" + matches);
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    
}
