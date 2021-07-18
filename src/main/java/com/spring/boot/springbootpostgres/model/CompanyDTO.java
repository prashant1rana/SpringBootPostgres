package com.spring.boot.springbootpostgres.model;

import com.spring.boot.springbootpostgres.postgres.Company;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class CompanyDTO {
    private int id;
    private String name;
    private int age;
    private String address;
    private int salary;
    private long joinDate;

    public static CompanyDTO fromCompany(Company companyObj) {
        return CompanyDTO.builder()
                .id(null != companyObj.getId() ?
                        companyObj.getId() : 0)
                .name(companyObj.getName())
                .age(null != companyObj.getAge() ?
                        companyObj.getAge() : 0)
                .address(null != companyObj.getAddress() ?
                        companyObj.getAddress().toString() : null)
                .salary(null != companyObj.getSalary() ?
                        companyObj.getSalary() : 0)
                .joinDate(null != companyObj.getJoinDate() ?
                        companyObj.getJoinDate().getTime() : 0)
                .build();
    }

    public Company toCompany() {
        return Company.builder()
                .id(this.getId())
                .name(this.getName())
                .age(this.getAge())
                .address(this.getAddress().toCharArray())
                .salary(this.getSalary())
                .joinDate(new Date(this.getJoinDate()))
                .build();
    }

    public static void main(String[] args) {
        CompanyDTO dtp = CompanyDTO.builder()
                .id(122)
                .address("dkhjjkdhd")
                .build();

    }

}
