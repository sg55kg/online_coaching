package com.dlc.server.repository;

import com.dlc.server.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Set;

public interface AthleteRepository extends JpaRepository<Athlete, BigInteger> {

    public Set<Athlete> findByCoachId(BigInteger coachId);
}
