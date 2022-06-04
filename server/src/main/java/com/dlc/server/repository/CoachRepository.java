package com.dlc.server.repository;

import com.dlc.server.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CoachRepository extends JpaRepository<Coach, BigInteger> {
}
