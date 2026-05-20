package com.sasank.fitlog.entity;

import java.time.LocalDate;

public class MealLog {
    private long id;
    private LocalDate date;
    private MealType mealType;
    private String foodName;

    private Integer calories;
    private Double proteinGrams;
    private Double carbsGrams;
    private Double fatGrams;

    public MealLog(long id, LocalDate date, MealType mealType, String foodName, Integer calories, Double proteinGrams, Double carbsGrams, Double fat){
        this.id = id;
        this.date = date;
        this.mealType = mealType;
        this.foodName = foodName;
        this.calories = calories;
        this.proteinGrams = proteinGrams;
        this.carbsGrams = carbsGrams;
        this.fatGrams = fat;

    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public LocalDate getDate() {
        return date;
    }
    public MealType getMealType() {
        return mealType;
    }
    public String getFoodName() {
        return foodName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public Double getProteinGrams() {
        return proteinGrams;
    }
    public void setProteinGrams(double proteinGrams) {
        this.proteinGrams = proteinGrams;
    }
    public Double getCarbsGrams() {
        return carbsGrams;
    }
    public void setCarbsGrams(double carbsGrams) {
        this.carbsGrams = carbsGrams;
    }
    public Double getFatGrams() {
        return fatGrams;
    }
    public void setFatGrams(double fatGrams) {
        this.fatGrams = fatGrams;
    }


}
