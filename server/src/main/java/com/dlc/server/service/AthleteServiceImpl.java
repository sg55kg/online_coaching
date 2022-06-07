package com.dlc.server.service;

import com.dlc.server.model.Athlete;
import com.dlc.server.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    AthleteRepository athleteRepository;

    public Optional<Athlete> getAthleteById(BigInteger athleteId) {
        return athleteRepository.findById(athleteId);
    }

    @Override
    public Set<Athlete> getAthletesByCoach(BigInteger coachId) {
        return athleteRepository.findByCoachId(coachId);
    }
}
