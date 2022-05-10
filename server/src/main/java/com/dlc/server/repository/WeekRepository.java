package com.dlc.server.repository;

import com.dlc.server.model.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface WeekRepository extends JpaRepository<Week, BigInteger> {

}
