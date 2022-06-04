package com.dlc.server.controller;

import com.dlc.server.model.Exercise;
import com.dlc.server.service.ExerciseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/exercise")
@CrossOrigin
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    public String add(Exercise exercise) {
        exerciseService.save(exercise);
        return "Successfully saved Exercise";
    }
}
