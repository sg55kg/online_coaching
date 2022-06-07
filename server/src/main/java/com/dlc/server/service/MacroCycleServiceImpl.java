package com.dlc.server.service;

import com.dlc.server.model.MacroCycle;
import com.dlc.server.repository.MacroCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MacroCycleServiceImpl implements MacroCycleService {

    @Autowired
    private MacroCycleRepository macroCycleRepository;


    @Override
    public List<MacroCycle> getMacroCycleByStartDate(Date startDate) {
        return null;
    }

    @Override
    public void save(MacroCycle macroCycle) {
        macroCycleRepository.save(macroCycle);
    }

    @Override
    public List<MacroCycle> getAllMacroCycles() {
        return macroCycleRepository.findAll();
    }
}
