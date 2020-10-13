package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository repository;

    @Override
    public Iterable<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveCity(City city) {
        repository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        repository.deleteById(id);
    }
}
