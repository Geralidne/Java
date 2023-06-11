/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jacki
 */
public class Employee{
	
    // Employee 屬性
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private LocalDate startDate;
    private double salary;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    // 建立接收資料的 static 內部類別，命名為 Builder
    public static class Builder {
        
        // Builder 屬性要對應 Employee 屬性並且明確指定預設值
        private String givenName = "";
        private String surName = "";
        private int age = 0;
        private Gender gender = Gender.FEMALE;
        private Role role = Role.STAFF;
        private String dept = "";
        private LocalDate startDate = LocalDate.of(1, 1, 1);
        private double salary = 0;
        private String eMail = "";
        private String phone = "";
        private String address = "";
        private String city = "";
        private String state = "";
        private String code = "";

        // 建立接收資料方法
        public Employee.Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Employee.Builder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public Employee.Builder age(int val) {
            age = val;
            return this;
        }

        public Employee.Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Employee.Builder role(Role val) {
            role = val;
            return this;
        }

        public Employee.Builder dept(String val) {
            dept = val;
            return this;
        }

        public Employee.Builder startDate(LocalDate val) {
            startDate = val;
            return this;
        }

        public Employee.Builder salary(double val) {
            salary = val;
            return this;
        }

        public Employee.Builder email(String val) {
            eMail = val;
            return this;
        }

        public Employee.Builder phoneNumber(String val) {
            phone = val;
            return this;
        }

        public Employee.Builder address(String val) {
            address = val;
            return this;
        }

        public Employee.Builder city(String val) {
            city = val;
            return this;
        }

        public Employee.Builder state(String val) {
            state = val;
            return this;
        }

        public Employee.Builder code(String val) {
            code = val;
            return this;
        }

        // 資料接收後建立 Employee 物件
        public Employee build() {
            return new Employee(this);
        }
    }// Builder 內部類別結束 

    private Employee() {
        super();
    }

    // Employee 建構子
    // 建構子宣告 private，禁止直接其他類別 new Employee 物件
    private Employee(Employee.Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        startDate = builder.startDate;
        salary = builder.salary;
        eMail = builder.eMail;
        phone = builder.phone;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    // Employee 方法
    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String name) {
        this.surName = name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    // 顯示相關資訊
    public void printSummary() {
        System.out.printf(
                "Name: " + givenName + " " + surName
                + " Role: " + role
                + " Dept: " + dept
                + " St: " + state
                + " Salary: $%,9.2f %n", salary
        );
    }

    @Override
    public String toString() {
        return "Name: " + givenName + " " + surName
                + " Age: " + age
                + " Gender: " + gender
                + " Role: " + role
                + " Dept: " + dept
                + " Start date: " + startDate
                + " Salary: " + salary
                + " eMail: " + eMail
                + " Phone: " + phone
                + " Address: " + address
                + " City: " + city
                + " State: " + state
                + " Code: " + code + "\n";

    }

    // 先準備好的 Employee 集合
    public static List<Employee> createEmployeeList() {
        List<Employee> employees = new ArrayList<>();

        employees.add(
                new Employee.Builder()
                        .givenName("Bob")
                        .surName("Baker")
                        .age(23)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .dept("Eng")
                        .startDate(LocalDate.of(2013, 1, 10))
                        .salary(40000)
                        .email("bob.baker@example.com")
                        .phoneNumber("201-121-4678")
                        .address("44 4th St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("Jane")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Sales")
                        .startDate(LocalDate.of(2011, 7, 14))
                        .salary(45000)
                        .email("jane.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("Amy")
                        .surName("Doe")
                        .age(30)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("Eng")
                        .startDate(LocalDate.of(2005, 8, 1))
                        .salary(70000)
                        .email("amy.doe@example.com")
                        .phoneNumber("202-123-1112")
                        .address("66 3rd St")
                        .city("Smallville")
                        .state("CO")
                        .code("13579")
                        .build()
        );
		
		employees.add(
                new Employee.Builder()
                        .givenName("John")
                        .surName("Doe")
                        .age(28)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Eng")
                        .startDate(LocalDate.of(2007, 3, 1))
                        .salary(65000)
                        .email("john.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("James")
                        .surName("Johnson")
                        .age(45)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Eng")
                        .startDate(LocalDate.of(1999, 5, 1))
                        .salary(85000)
                        .email("james.johnson@example.com")
                        .phoneNumber("333-456-1233")
                        .address("201 2nd St")
                        .city("BrainTree")
                        .state("MA")
                        .code("11111")
                        .build()
        );
		
		employees.add(
                new Employee.Builder()
                        .givenName("Tom")
                        .surName("Lee")
                        .age(45)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Sales")
                        .startDate(LocalDate.of(1995, 6, 1))
                        .salary(70000)
                        .email("tom.lee@example.com")
                        .phoneNumber("112-111-3333")
                        .address("111 1st St")
                        .city("Braintree")
                        .state("CO")
                        .code("11111")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("John")
                        .surName("Adams")
                        .age(52)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Sales")
                        .startDate(LocalDate.of(1994, 2, 1))
                        .salary(90000)
                        .email("john.adams@example.com")
                        .phoneNumber("112-111-1111")
                        .address("111 1st St")
                        .city("Braintree")
                        .state("MA")
                        .code("11111")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("Joe")
                        .surName("Bailey")
                        .age(62)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("Eng")
                        .startDate(LocalDate.of(1992, 1, 5))
                        .salary(120000)
                        .email("joebob.bailey@example.com")
                        .phoneNumber("112-111-1111")
                        .address("111 1st St")
                        .city("Town")
                        .state("CO")
                        .code("11111")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("Phil")
                        .surName("Smith")
                        .age(55)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("HR")
                        .startDate(LocalDate.of(2000, 10, 10))
                        .salary(110000)
                        .email("phil.smith@examp;e.com")
                        .phoneNumber("222-33-1234")
                        .address("22 2nd St")
                        .city("New Park")
                        .state("CO")
                        .code("222333")
                        .build()
        );

        employees.add(
                new Employee.Builder()
                        .givenName("Betty")
                        .surName("Jones")
                        .age(65)
                        .gender(Gender.FEMALE)
                        .role(Role.EXECUTIVE)
                        .dept("Sales")
                        .startDate(LocalDate.of(1984, 7, 10))
                        .salary(140000)
                        .email("betty.jones@example.com")
                        .phoneNumber("211-33-5678")
                        .address("25 4th St")
                        .city("New Park")
                        .state("CO")
                        .code("333444")
                        .build()
        );

        return employees;
    }
}


// CO	Colorado	科羅拉多州
// KS	Kansas          堪薩斯州
// MA	Massachusetts	麻薩諸塞州
