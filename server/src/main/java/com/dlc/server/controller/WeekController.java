package com.dlc.server.controller;

import com.dlc.server.model.Week;
import com.dlc.server.service.WeekServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/week")
@CrossOrigin("*")
public class WeekController {

    @Autowired
    private WeekServiceImpl weekService;

    @PostMapping("/add")
    public String add(Week week) {
        weekService.saveWeek(week);
        return "Successfully saved new week";
    }
}
