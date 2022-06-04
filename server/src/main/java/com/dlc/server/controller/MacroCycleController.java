package com.dlc.server.controller;

import com.dlc.server.model.MacroCycle;
import com.dlc.server.service.MacroCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/macroCycle")
@CrossOrigin
public class MacroCycleController {

    private final MacroCycleService macroCycleService;

    public MacroCycleController(MacroCycleService macroCycleService) {
        this.macroCycleService = macroCycleService;
    }

    @PostMapping("/add")
    public String add(@RequestBody MacroCycle macroCycle) {
        macroCycleService.save(macroCycle);
        return "Successfully saved macro-cycle";
    }

    @GetMapping("/getAll")
    public List<MacroCycle> getAll() {
        List<MacroCycle> res = macroCycleService.getAllMacroCycles();
        return res;
    }


}
