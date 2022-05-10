package com.dlc.server.service;

import com.dlc.server.model.MicroCycle;
import com.dlc.server.repository.MicroCycleRepository;
import org.springframework.stereotype.Service;

@Service
public class MicroCycleServiceImpl implements MicroCycleService {

    private final MicroCycleRepository microCycleRepository;

    public MicroCycleServiceImpl(MicroCycleRepository theRepo) {
        this.microCycleRepository = theRepo;
    }

    public MicroCycle saveMicroCycle(MicroCycle microCycle) {
        return microCycleRepository.save(microCycle);
    }
}
