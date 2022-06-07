package com.dlc.server.controller;


import com.dlc.server.model.Day;
import com.dlc.server.service.DayServiceImpl;
import com.dlc.server.service.DayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/day")
@CrossOrigin("*")
public class DayController {

    @Autowired
    private DayServiceImpl dayService;

    @PostMapping("/add")
    public String add(@RequestBody Day theDay) {
        dayService.saveDay(theDay);
        return "Successfully added new day";
    }
}
