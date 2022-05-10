package com.dlc.server.service;

import com.dlc.server.model.MacroCycle;

import java.util.Date;
import java.util.List;

public interface MacroCycleService {
    public List<MacroCycle> getMacroCycleByStartDate(Date startDate);
    public List<MacroCycle> getAllMacroCycles();
    public void save(MacroCycle macroCycle);
}
