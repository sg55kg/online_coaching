package com.dlc.server.service;

import com.dlc.server.model.Exercise;
import com.dlc.server.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getExerciseByType(String type) {
        return null;
    }

    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }
}
