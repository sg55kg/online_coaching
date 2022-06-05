package com.dlc.server.controller;


import com.dlc.server.model.Day;
import com.dlc.server.service.DayService;
import com.dlc.server.service.DayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/day")
@CrossOrigin("*")
public class DayController {

    private final DayService dayService;

    public DayController(DayService service) {
        this.dayService = service;
    }

    @PostMapping("/add")
    public String add(@RequestBody Day theDay) {
        dayService.saveDay(theDay);
        return "Successfully added new day";
    }
}
