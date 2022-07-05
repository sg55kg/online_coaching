package com.dlc.server.service;

import com.dlc.server.model.Day;
import com.dlc.server.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayRepository dayRepository;

    @Override
    public Day saveDay(Day theDay) {
        return dayRepository.save(theDay);
    }

    @Override
    public Day update(Day theDay) {
        Optional<Day> o = dayRepository.findById(theDay.getId());
        if(o.isEmpty()) {
            return null;
        } else {
            Day d = o.get();
            d = theDay;
            return d;
        }
    }
}
