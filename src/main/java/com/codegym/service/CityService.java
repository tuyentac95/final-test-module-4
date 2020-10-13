package com.codegym.service;


import com.codegym.model.City;

public interface CityService {
    Iterable<City> findAll();

    City findById(Long id);

    void saveCity(City city);

    void deleteCity(Long id);
}
