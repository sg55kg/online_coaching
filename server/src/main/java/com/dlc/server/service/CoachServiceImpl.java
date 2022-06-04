package com.dlc.server.service;

import com.dlc.server.model.Athlete;
import com.dlc.server.model.Coach;
import com.dlc.server.repository.AthleteRepository;
import com.dlc.server.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

@Service
public class CoachServiceImpl implements CoachService{

    @Autowired
    CoachRepository coachRepository;
    @Autowired
    AthleteRepository athleteRepository;

    @Override
    public Set<Athlete> getAllCoachAthletes(BigInteger coachId) {
        Set<Athlete> athletes = athleteRepository.findByCoachId(coachId);
        return athletes;
    }

    @Override
    public Optional<Coach> getCoachById(BigInteger coachId) {
        return coachRepository.findById(coachId);
    }
}
