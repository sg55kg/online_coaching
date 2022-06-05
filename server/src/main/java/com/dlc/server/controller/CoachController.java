package com.dlc.server.controller;

import com.dlc.server.model.Athlete;
import com.dlc.server.model.Coach;
import com.dlc.server.service.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/data/coach")
@CrossOrigin("*")
public class CoachController {

    @Autowired
    private CoachServiceImpl coachService;

    @GetMapping("/athletes/{coachId}")
    public ResponseEntity<Set<Athlete>> getAllAthletes(@PathVariable("coachId") BigInteger coachId) {
        Set<Athlete> athletes = coachService.getAllCoachAthletes(coachId);
        if(athletes.isEmpty()) {
            return new ResponseEntity<>(athletes, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(athletes, HttpStatus.OK);
        }
    }

    @GetMapping("/{coachId}")
    public ResponseEntity<Coach> getCoach(@PathVariable("coachId") BigInteger coachId) {
        Optional<Coach> coachO = coachService.getCoachById(coachId);
        Coach coach = coachO.get();
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Coach> addCoach(Coach coach) {
        coachService.addCoach(coach);
        return new ResponseEntity<Coach>(coach, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }



}
