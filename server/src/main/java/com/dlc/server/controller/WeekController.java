package com.dlc.server.controller;

import com.dlc.server.model.Week;
import com.dlc.server.service.WeekServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/week")
@CrossOrigin
public class WeekController {

    private final WeekServiceImpl weekService;

    public WeekController(WeekServiceImpl theService) {
        this.weekService = theService;
    }

    @PostMapping("/add")
    public String add(Week week) {
        weekService.saveWeek(week);
        return "Successfully saved new week";
    }
}
