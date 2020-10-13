package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Long area;
    private Long population;
    private Long gdp;

    @Column(columnDefinition = "longtext")
    private String description;
}
