package com.dlc.server.service;

import com.dlc.server.model.Exercise;

import java.util.List;

public interface ExerciseService {
    public List<Exercise> getExerciseByType(String type);
    public void save(Exercise exercise);

}
