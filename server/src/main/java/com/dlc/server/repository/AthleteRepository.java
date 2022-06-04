package com.dlc.server.repository;

import com.dlc.server.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AthleteRepository extends JpaRepository<Athlete, BigInteger> {
}
