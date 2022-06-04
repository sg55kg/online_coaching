package com.dlc.server.repository;

import com.dlc.server.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TeamRepository extends JpaRepository<Team, BigInteger> {
}
