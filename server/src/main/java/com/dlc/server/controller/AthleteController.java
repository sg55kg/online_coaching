package com.dlc.server.controller;

import com.dlc.server.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/athlete")
@CrossOrigin("*")
public class AthleteController {

    @Autowired
    private AthleteRepository athleteRepository;


}
