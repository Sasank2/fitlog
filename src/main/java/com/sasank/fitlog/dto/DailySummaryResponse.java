package com.sasank.fitlog.dto;

import java.time.LocalDate;

public class DailySummaryResponse {

    private LocalDate date;
    private Integer totalCalories;
    private Double totalProteinGrams;
    private Double totalCarbsGrams;
    private Double totalFatGrams;
    private Integer mealCount;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Double getTotalProteinGrams() {
        return totalProteinGrams;
    }

    public void setTotalProteinGrams(Double totalProteinGrams) {
        this.totalProteinGrams = totalProteinGrams;
    }

    public Double getTotalCarbsGrams() {
        return totalCarbsGrams;
    }

    public void setTotalCarbsGrams(Double totalCarbsGrams) {
        this.totalCarbsGrams = totalCarbsGrams;
    }

    public Double getTotalFatGrams() {
        return totalFatGrams;
    }

    public void setTotalFatGrams(Double totalFatGrams) {
        this.totalFatGrams = totalFatGrams;
    }

    public Integer getMealCount() {
        return mealCount;
    }

    public void setMealCount(Integer mealCount) {
        this.mealCount = mealCount;
    }

    public DailySummaryResponse(LocalDate date,Integer totalCalories, Double totalProteinGrams,Double totalCarbsGrams,Double totalFatGrams,Integer mealCount ){
        this.date = date;
        this.totalCalories = totalCalories;
        this.totalProteinGrams = totalProteinGrams;
        this.totalCarbsGrams = totalCarbsGrams;
        this.totalFatGrams = totalFatGrams;
        this.mealCount = mealCount;

    }

}
