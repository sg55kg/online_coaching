package com.dlc.server.service;

import com.dlc.server.model.Athlete;
import com.dlc.server.model.Coach;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface CoachService {

    public Set<Athlete> getAllCoachAthletes(BigInteger coachId);
    public Optional<Coach> getCoachById(BigInteger coachId);
    public void addCoach(Coach coach);
    public List<Coach> getAllCoaches();
    public Optional<Coach> getCoachByEmail(String email);
}
