package com.dlc.server.controller;

import com.dlc.server.model.Week;
import com.dlc.server.service.WeekServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('coach') || hasRole('athlete')")
@RestController
@RequestMapping("/data/week")
@CrossOrigin("*")
public class WeekController {

    @Autowired
    private WeekServiceImpl weekService;

    @PostMapping(value = "/add")
    //@PreAuthorize("hasRole('coach')")
    public ResponseEntity<Week> add(@RequestBody Week week) {
        Week savedWeek = weekService.saveWeek(week);
        System.out.println(savedWeek);
        return new ResponseEntity<Week>(savedWeek, HttpStatus.CREATED);
    }
}
