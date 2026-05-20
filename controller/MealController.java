package com.sasank.fitlog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasank.fitlog.entity.MealLog;
import com.sasank.fitlog.service.MealService;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService service;

    public MealController(MealService service){
        this.service = service;
    }

    @PostMapping
    public MealLog addMeal(@RequestBody MealLog log){
        return service.addMeal(log);

    }

    @PutMapping("/{id}")
    public MealLog updateMeal(@PathVariable long id, @RequestBody MealLog log){
        return service.updateMeal(id, log);
    }

    @GetMapping
    public List<MealLog> getAllMeals(){
        return service.getAllMeals();
    }

    @GetMapping("/date/{date}")
    public List<MealLog> getMealsByDate(@PathVariable LocalDate date){
        return service.getMealsByDate(date);
    }

    @DeleteMapping("/{id}")
    public String deleteMeal(@PathVariable long id){
        service.deleteMeal(id);
        return "Delete entry successful";
    }

}
