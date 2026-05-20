package com.sasank.fitlog.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sasank.fitlog.entity.MealLog;
import com.sasank.fitlog.repository.MealRepository;

@Service
public class MealService {

    private final MealRepository mealRepo;

    public MealService(MealRepository mealRepo){
        this.mealRepo = mealRepo;
    }

    public MealLog addMeal(MealLog mealLog){
        validateMeal(mealLog);
        return mealRepo.saveMeal(mealLog);
    }

    public List<MealLog> getAllMeals(){
        return mealRepo.getAllMeals();
    }

    public List<MealLog> getMealsByDate(LocalDate date){
        if (date == null) {
            throw new IllegalArgumentException("Date is required");
        }
        return mealRepo.getMealsByDate(date);
    }

    public MealLog updateMeal(long id, MealLog log){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid meal Id");
        }
        validateMeal(log);
        MealLog updatedLog = mealRepo.updateMeal(id, log);
        if(updatedLog == null){
            throw new IllegalArgumentException("No meal found with id: "+ id);
        }
        return updatedLog;
    }

    public void deleteMeal(long id){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid meal Id");
        }
        boolean deleted =   mealRepo.deleteMeal(id);
        
        if(!deleted){
            throw new IllegalArgumentException("No meal found with id: " + id);
        }
    }

    private void validateMeal(MealLog mealLog){

        if (mealLog == null) {
            throw new IllegalArgumentException("Meal data is required");
        }
        if (mealLog.getDate() == null) {
            throw new IllegalArgumentException("Meal date is required");
        }
        if (mealLog.getMealType() == null) {
            throw new IllegalArgumentException("Meal type is required");
        }
        if (mealLog.getFoodName() == null || mealLog.getFoodName().trim().isEmpty()) {
            throw new IllegalArgumentException("Food name is required");
        }
        if (mealLog.getCalories() == null || mealLog.getCalories() < 0) {
            throw new IllegalArgumentException("Calories are required and cannot be negative");
        }
        if (mealLog.getProteinGrams() == null || mealLog.getProteinGrams() < 0) {
            throw new IllegalArgumentException("Protein grams are required and cannot be negative");
        }
        if (mealLog.getCarbsGrams() == null || mealLog.getCarbsGrams() < 0) {
            throw new IllegalArgumentException("Carbs grams are required and cannot be negative");
        }
        if (mealLog.getFatGrams() == null || mealLog.getFatGrams() < 0) {
            throw new IllegalArgumentException("Fat grams are required and cannot be negative");
        }
    }


}
