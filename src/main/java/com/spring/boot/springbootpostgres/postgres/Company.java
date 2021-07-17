package com.spring.boot.springbootpostgres.postgres;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "company")
@Builder
public class Company implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private char[] address;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "joinDate")
    private Date joinDate;

    public Company(Integer id, String name, Integer age, char[] address, Integer salary, Date joinDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public Company() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public char[] getAddress() {
        return address;
    }

    public Integer getSalary() {
        return salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + Arrays.toString(address) +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                '}';
    }
}