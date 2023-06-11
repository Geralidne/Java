/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sample;

import java.util.List;
import java.util.Optional;

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
        List<Employee> eList = Employee.createEmployeeList();
        System.out.println(eList);
        System.out.println("-----------------------");
        
        // 指令式編輯
        double sum1 = 0;
        for(Employee e : eList){
            if(e.getState().equals("CO") && e.getRole().equals(Role.EXECUTIVE)){
                e.printSummary();
                sum1 += e.getSalary();
            }
        }
        System.out.printf("Total CO Executive Pay:$%,9.2f %n", sum1);
        System.out.println("--------------------------------------------------");
        
        // stream 平行化、流暢性編輯
        // stream() + 循序處理 sequential (default) 由 stream 啟動平行化
        double sum2 = eList.stream()
                        .filter(e -> e.getState().equals("CO"))
                        .filter(e ->  e.getRole().equals(Role.EXECUTIVE))
                        .peek(e -> e.printSummary())
                        .mapToDouble(e -> e.getSalary())
                        .sequential()  // 循序處理(預設)，可以省略不寫
                        .sum();
        System.out.printf("Total CO Executive Pay:$%,9.2f %n", sum2);
        System.out.println("--------------------------------------------------");
        
        // stream() + 平行處理 parallel 由 stream 啟動平行化
        double sum3 = eList.stream()
                        .filter(e -> e.getState().equals("CO"))
                        .filter(e ->  e.getRole().equals(Role.EXECUTIVE))
                        .peek(e -> e.printSummary())
                        .mapToDouble(e -> e.getSalary())
                        .parallel()  // 平行處理
                        .sum();
        System.out.printf("Total CO Executive Pay:$%,9.2f %n", sum3);
        System.out.println("--------------------------------------------------");
        
        // 由 Collection(集合物件) 發動，使用 parallelStream()
        double sum4 = eList.parallelStream()
                        .filter(e -> e.getState().equals("CO"))
                        .filter(e ->  e.getRole().equals(Role.EXECUTIVE))
                        .peek(e -> e.printSummary())
                        .mapToDouble(e -> e.getSalary())
                        .sum();
        System.out.printf("Total CO Executive Pay:$%,9.2f %n", sum4);
        System.out.println("--------------------------------------------------");
        
        // 短路型終端操作 findAny()，循序處理和平行處理的結果可能不同
        Optional<Employee> o1 = eList.stream()
                                    .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                                    .sequential()
                                    .findAny();
        Optional<Employee> o2 = eList.stream()
                                    .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                                    .parallel()
                                    .findAny();
        String o1_mail = o1.get().getEmail();
        String o2_mail = o2.get().getEmail();
        System.out.println("o1：" + o1_mail);
        System.out.println("o2：" + o2_mail);
        System.out.println(o1_mail.equals(o2_mail));
    }
    
}
