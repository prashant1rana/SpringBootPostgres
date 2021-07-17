package com.spring.boot.springbootpostgres.handler;

import com.spring.boot.springbootpostgres.dao.Dao;
import com.spring.boot.springbootpostgres.model.CompanyDTO;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class Handler {
    @Inject
    private Dao dao;

    public List<CompanyDTO> getCompanies() {
        return dao.getCompanies();
    }

    public CompanyDTO getCompanyById(Integer id) {
        return dao.getCompanyById(id);
    }
}
