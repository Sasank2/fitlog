package com.sasank.fitlog.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sasank.fitlog.dto.DailySummaryResponse;
import com.sasank.fitlog.entity.MealLog;

@Service
public class SummaryService {

    private final MealService service;

    public SummaryService(MealService service){
        this.service = service;
    }

    public DailySummaryResponse getDailySummary(LocalDate date){
        if(date ==null){
            throw new IllegalArgumentException("Date is required");
        }

        List<MealLog> meals = service.getMealsByDate(date);
        Integer totalCalories = 0;
        Double totalProteinGrams = 0.0;
        Double totalCarbGrams = 0.0;
        Double totalFatGrams = 0.0;

        for(MealLog mealLog : meals){
            totalCalories = totalCalories + mealLog.getCalories();
            totalProteinGrams = totalProteinGrams + mealLog.getProteinGrams();
            totalCarbGrams = totalCarbGrams + mealLog.getCarbsGrams();
            totalFatGrams = totalFatGrams + mealLog.getFatGrams();
        }
        Integer mealCount = meals.size();
        return new DailySummaryResponse(
            date,
            totalCalories,
            totalProteinGrams,
            totalCarbGrams,
            totalFatGrams,
            mealCount
        );
    }


}
