package com.dlc.server.repository;

import com.dlc.server.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, BigInteger> {
}
