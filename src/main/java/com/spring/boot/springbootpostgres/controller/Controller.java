package com.spring.boot.springbootpostgres.controller;

import javax.inject.Inject;

import com.spring.boot.springbootpostgres.handler.Handler;
import com.spring.boot.springbootpostgres.model.CompanyDTO;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Inject
    private Handler handler;

    @RequestMapping(value = "/companies", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    List<CompanyDTO> getCompanies() {
        return handler.getCompanies();
    }

    @RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    CompanyDTO getCompanyById(@NonNull @PathVariable final Integer companyId) {
        return handler.getCompanyById(companyId);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    CompanyDTO addCompany(@NonNull @RequestBody final CompanyDTO company) {
        return handler.addCompany(company);
    }
}
