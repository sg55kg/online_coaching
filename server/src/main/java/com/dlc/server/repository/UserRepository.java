package com.dlc.server.repository;
import java.math.BigInteger;

import com.dlc.server.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<User, BigInteger> {
    
}
