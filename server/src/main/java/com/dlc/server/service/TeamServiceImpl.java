package com.dlc.server.service;

import com.dlc.server.model.Team;
import com.dlc.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }
}
