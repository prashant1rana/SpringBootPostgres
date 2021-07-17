package com.spring.boot.springbootpostgres.dao;

import com.spring.boot.springbootpostgres.model.CompanyDTO;

import java.util.List;

public interface Dao {
    List<CompanyDTO> getCompanies();

    CompanyDTO getCompanyById(Integer id);

    CompanyDTO addCompany(CompanyDTO company);
}
