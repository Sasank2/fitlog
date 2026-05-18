package com.sasank.fitlog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sasank.fitlog.entity.MealLog;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class MealRepository {

    private List<MealLog> log = new ArrayList<>();

    public MealLog saveMeal(MealLog mealLog){
         log.add(mealLog);
         return mealLog;
    }

    public List<MealLog> getAllMeals(){
        return log;
    }

    public MealLog updateMeal(long id, MealLog updatedMeal){
        for (MealLog meal : log){
            if(id == meal.getId()){
                meal.setDate(updatedMeal.getDate());
                meal.setMealType(updatedMeal.getMealType());
                meal.setFoodName(updatedMeal.getFoodName());
                meal.setCalories(updatedMeal.getCalories());
                meal.setProteinGrams(updatedMeal.getProteinGrams());
                meal.setCarbsGrams(updatedMeal.getCarbsGrams());
                meal.setFatGrams(updatedMeal.getFatGrams());
                return meal;
            }
        }
        return null;
    }


    public boolean deleteMeal(long id){
        MealLog mealToRemove = null;
        for (MealLog mealLog : log){
            if(id == mealLog.getId()){
                mealToRemove = mealLog;
                break;
            }
        }
        if(mealToRemove != null){
            log.remove(mealToRemove);
            return true;
        }

        return false;

    }

    public List<MealLog> getMealsByDate(LocalDate date){
        List<MealLog> result = new ArrayList<>(); 
        for (MealLog mealLog : log){
            if(date.equals(mealLog.getDate())){
                result.add(mealLog);
            }
        }
        return result;
    }

}
