package com.dlc.server.controller;

import com.dlc.server.model.MacroCycle;
import com.dlc.server.model.MicroCycle;
import com.dlc.server.service.MicroCycleService;
import com.dlc.server.service.MicroCycleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microCycle")
@CrossOrigin
public class MicroCycleController {

    private final MicroCycleService microCycleService;

    public MicroCycleController(MicroCycleService microCycleService) {
        this.microCycleService = microCycleService;
    }

    @PostMapping("/add")
    public String addMicroCycle(MicroCycle microCycle) {
        microCycleService.saveMicroCycle(microCycle);
        return "Successfully added new micro cycle";
    }

}
