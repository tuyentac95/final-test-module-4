package com.codegym.service;

import com.codegym.model.Country;
import com.codegym.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository repository;

    @Override
    public Iterable<Country> findAll() {
        return repository.findAll();
    }
}
