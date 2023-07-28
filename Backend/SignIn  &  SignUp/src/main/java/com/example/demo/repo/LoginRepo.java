package com.example.demo.repo;

import com.example.demo.entity.SignUpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<SignUpDetails, String> {

    boolean existsByUserName(String userName);

    Optional<SignUpDetails> findByUserName(String userName);
}
