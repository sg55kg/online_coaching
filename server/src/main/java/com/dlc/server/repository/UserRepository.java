package com.dlc.server.repository;
import java.math.BigInteger;
import java.util.Optional;

import com.dlc.server.model.User;

import com.dlc.server.service.UserDetailsImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    @Query("SELECT u FROM User u WHERE u.displayName = :displayName")
    Optional<User> findByDisplayName(@Param("displayName") String displayName);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    Boolean existsByDisplayName(String displayName);
    Boolean existsByEmail(String email);

}
