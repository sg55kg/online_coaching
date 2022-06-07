package com.dlc.server.controller;

import com.dlc.server.model.MacroCycle;
import com.dlc.server.service.MacroCycleService;
import com.dlc.server.service.MacroCycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/macroCycle")
@CrossOrigin("*")
public class MacroCycleController {

    @Autowired
    private MacroCycleServiceImpl macroCycleService;

    @PostMapping("/add")
    public String add(@RequestBody MacroCycle macroCycle) {
        macroCycleService.save(macroCycle);
        return "Successfully saved macro-cycle";
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<MacroCycle> res = macroCycleService.getAllMacroCycles();
        if(res.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
