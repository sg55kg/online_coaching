package com.dlc.server.repository;

import com.dlc.server.model.MicroCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MicroCycleRepository extends JpaRepository<MicroCycle, BigInteger> {
}
