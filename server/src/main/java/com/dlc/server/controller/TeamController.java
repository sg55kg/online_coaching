package com.dlc.server.controller;

import com.dlc.server.model.Team;
import com.dlc.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/team")
@CrossOrigin("*")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/add")
    public ResponseEntity<Team> createTeam(Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
