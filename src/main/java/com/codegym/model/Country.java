package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = City.class)
    private List<City> cities;
}
