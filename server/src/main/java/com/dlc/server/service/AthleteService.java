package com.dlc.server.service;

import com.dlc.server.model.Athlete;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public interface AthleteService {
    public Set<Athlete> getAthletesByCoach(BigInteger coachId);
}
