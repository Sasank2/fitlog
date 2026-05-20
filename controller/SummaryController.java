package com.sasank.fitlog.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PathVariable;
import com.sasank.fitlog.dto.DailySummaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasank.fitlog.service.SummaryService;
import com.sasank.fitlog.dto.DailySummaryResponse;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    private final SummaryService service;

    public SummaryController(SummaryService service){
        this.service = service;
    }

    @GetMapping("/daily/{date}")
    public DailySummaryResponse getDailySummary(@PathVariable LocalDate date){
        return service.getDailySummary(date);
    }

}
