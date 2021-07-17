package com.spring.boot.springbootpostgres.dao;

import com.spring.boot.springbootpostgres.model.CompanyDTO;
import com.spring.boot.springbootpostgres.postgres.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service("Dao")
public class DaoImpl implements Dao {

    @Inject
    CompanyRepository repository;

    @Override
    public List<CompanyDTO> getCompanies() {
        List<CompanyDTO> companies = new ArrayList();
        repository.findAll().forEach(company ->
                companies.add(
                        CompanyDTO.fromCompany(company)
                ));
        return companies;
    }

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        return CompanyDTO.fromCompany(repository.findById(id).get());
    }
}
