package com.dlc.server.controller;


import com.dlc.server.model.Day;
import com.dlc.server.service.DayServiceImpl;
import com.dlc.server.service.DayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('coach') || hasRole('athlete')")
@RestController
@RequestMapping("/data/day")
@CrossOrigin("*")
public class DayController {

    @Autowired
    private DayServiceImpl dayService;

    @PostMapping("/add")
    public ResponseEntity<Day> add(@RequestBody Day theDay) {
        dayService.saveDay(theDay);
        return  new ResponseEntity<>(theDay, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Day> update(@RequestBody Day theDay) {
        Day d = dayService.update(theDay);
        if(d == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theDay, HttpStatus.OK);
    }
}
