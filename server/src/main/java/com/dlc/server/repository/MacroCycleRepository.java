package com.dlc.server.repository;

import com.dlc.server.model.MacroCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MacroCycleRepository extends JpaRepository<MacroCycle, BigInteger> {
}
