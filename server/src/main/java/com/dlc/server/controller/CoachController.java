package com.dlc.server.controller;

import com.dlc.server.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
@CrossOrigin
public class CoachController {

    @Autowired
    private CoachRepository coachRepository;
}
