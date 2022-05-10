package com.dlc.server.service;

import com.dlc.server.model.Day;
import com.dlc.server.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;

    public DayServiceImpl(DayRepository theRepo) {
        this.dayRepository = theRepo;
    }

    @Override
    public Day saveDay(Day theDay) {
        return dayRepository.save(theDay);
    }
}
