package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class HomeController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> categories(){
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCities(){
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cityService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("city/view");
        modelAndView.addObject("city",cityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addForm(){
        ModelAndView modelAndView = new ModelAndView("city/add");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addCity(@ModelAttribute("city") City city) {
        cityService.saveCity(city);
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cityService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCity(@ModelAttribute("city") City city){
        cityService.saveCity(city);
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("city/delete");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCity(@ModelAttribute("city") City city){
        cityService.deleteCity(city.getId());
        return "redirect:";
    }
}
