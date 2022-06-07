package com.dlc.server.service;

import com.dlc.server.model.MicroCycle;
import com.dlc.server.repository.MicroCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroCycleServiceImpl implements MicroCycleService {

    @Autowired
    private MicroCycleRepository microCycleRepository;

    @Override
    public MicroCycle saveMicroCycle(MicroCycle microCycle) {
        return microCycleRepository.save(microCycle);
    }
}
