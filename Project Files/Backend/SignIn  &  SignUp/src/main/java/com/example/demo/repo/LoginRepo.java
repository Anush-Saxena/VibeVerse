package com.example.demo.repo;

import com.example.demo.entity.SignUpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<SignUpDetails, Integer> {

}
