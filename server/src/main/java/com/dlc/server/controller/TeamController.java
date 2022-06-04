package com.dlc.server.controller;

import com.dlc.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/team")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
}
