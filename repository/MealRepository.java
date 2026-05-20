package com.sasank.fitlog.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasank.fitlog.entity.MealLog;

@Repository

public interface MealRepository extends JpaRepository<MealLog, Long> {

    List<MealLog> findByDate(LocalDate date);

}