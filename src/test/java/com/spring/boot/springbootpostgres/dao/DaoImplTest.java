package com.spring.boot.springbootpostgres.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.google.inject.internal.util.ImmutableList;
import com.spring.boot.springbootpostgres.model.CompanyDTO;
import com.spring.boot.springbootpostgres.postgres.Company;
import com.spring.boot.springbootpostgres.postgres.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DaoImplTest {

    @InjectMocks
    private DaoImpl dao = new DaoImpl();

    @Mock
    CompanyRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Testing getCompanies")
    void testGetCompanies() {
        // Given
        when(repository.findAll()).thenReturn(ImmutableList.of(
                Company.builder()
                        .id(122)
                        .name("Test")
                        .age(12)
                        .salary(122)
                        .joinDate(new Date(1222))
                        .address("Address".toCharArray())
                        .build()
        ));

        // When
        List<CompanyDTO> companies = dao.getCompanies();

        // Then
        assertEquals(1, companies.size(), "Got correct number of companies");
        assertEquals(122, companies.get(0).getId(), "Company Id Matched");
    }

    @Test
    @DisplayName("Testing 0 getCompanies")
    void testGetCompaniesEMpty() {
        // Given
        when(repository.findAll()).thenReturn(ImmutableList.of());
        // When
        List<CompanyDTO> companies = dao.getCompanies();

        // Then
        assertEquals(0, companies.size(), "Got correct number of companies");
    }

    @Test
    @DisplayName("Testing getCompanies with Error")
    void testGetCompaniesWithError() {
        // Given
        doThrow(RuntimeException.class).when(repository).findAll();

        // When and Then
        Assertions.assertThrows(RuntimeException.class, () -> {
            dao.getCompanies();
        });
    }
}
