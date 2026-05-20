package com.sasank.fitlog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        return mealRepo.save(mealLog);
    }

    public List<MealLog> getAllMeals(){
        return mealRepo.findAll();
    }

    public List<MealLog> getMealsByDate(LocalDate date){
        if (date == null) {
            throw new IllegalArgumentException("Date is required");
        }
        return mealRepo.findByDate(date);
    }

    public MealLog updateMeal(long id, MealLog log){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid meal Id");
        }
        validateMeal(log);
        Optional<MealLog> optionalMeal = mealRepo.findById(id);

        if (optionalMeal.isEmpty()) {
            throw new IllegalArgumentException("No meal found with id: " + id);
        }

        MealLog existingMeal = optionalMeal.get();

        existingMeal.setDate(log.getDate());
        existingMeal.setMealType(log.getMealType());
        existingMeal.setFoodName(log.getFoodName());
        existingMeal.setCalories(log.getCalories());
        existingMeal.setProteinGrams(log.getProteinGrams());
        existingMeal.setCarbsGrams(log.getCarbsGrams());
        existingMeal.setFatGrams(log.getFatGrams());

        return mealRepo.save(existingMeal);

    }

    public void deleteMeal(long id){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid meal Id");
        }
        Optional<MealLog> optionalMeal = mealRepo.findById(id);

        if (optionalMeal.isEmpty()) {
            throw new IllegalArgumentException("No meal found with id: " + id);
        }
        MealLog existingMeal = optionalMeal.get();
        mealRepo.delete(existingMeal);
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
