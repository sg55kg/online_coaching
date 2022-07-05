package com.dlc.server.service;

import com.dlc.server.model.Week;
import com.dlc.server.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    private WeekRepository weekRepository;

    @Override
    public Week saveWeek(Week week) {
        Week newWeek = weekRepository.save(week);
        System.out.println(newWeek);
        return newWeek;
    }
}
