package com.spring.boot.springbootpostgres.model;

public class CompanyDTO1 {
    private int id;
    private String name;
    private int age;
    private String address;
    private int salary;
    private long joinDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }


    public static void main(String[] args) {
        CompanyDTO1 dt1 = new CompanyDTO1();
        dt1.setId(1221);

        //callMe(dt1);

        dt1.setId(12233);

    }
}
