package com.dlc.server.service;

import com.dlc.server.model.Week;
import com.dlc.server.repository.WeekRepository;
import org.springframework.stereotype.Service;

@Service
public class WeekServiceImpl implements WeekService {

    private final WeekRepository weekRepository;

    public WeekServiceImpl(WeekRepository theRepo) {
        this.weekRepository = theRepo;
    }

    public Week saveWeek(Week week) {
        return weekRepository.save(week);
    }
}
