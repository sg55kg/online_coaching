package com.dlc.server.controller;

import com.dlc.server.model.Exercise;
import com.dlc.server.service.ExerciseService;
import com.dlc.server.service.ExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/exercise")
@CrossOrigin("*")
public class ExerciseController {

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @PostMapping("/add")
    public String add(Exercise exercise) {
        exerciseService.save(exercise);
        return "Successfully saved Exercise";
    }

    @DeleteMapping("/delete/{id}")
   // @PreAuthorize("hasRole('coach')")
    public String delete(Exercise exercise) {
        return null;
    }
}
