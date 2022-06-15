package com.dlc.server.controller;

import com.dlc.server.model.Athlete;
import com.dlc.server.repository.AthleteRepository;
import com.dlc.server.service.AthleteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@PreAuthorize("hasRole('athlete') || hasRole('coach')")
@RestController
@RequestMapping("/data/athlete")
@CrossOrigin("*")
public class AthleteController {

    @Autowired
    private AthleteServiceImpl athleteService;

    @GetMapping("/{athleteID}")
    public ResponseEntity<?> getAthleteById(@PathVariable("athleteID") BigInteger athleteId) {
        Optional<Athlete> athlete = athleteService.getAthleteById(athleteId);
        if(athlete.isPresent()) {
            return new ResponseEntity<>(athlete.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/coach/{coachID}")
    public ResponseEntity<?> getAthletesByCoach(@RequestParam("coachID") BigInteger coachId) {
        Set<Athlete> athletes = athleteService.getAthletesByCoach(coachId);
        if(athletes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(athletes, HttpStatus.OK);
        }
    }
}
