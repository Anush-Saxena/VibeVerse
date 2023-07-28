package com.example.demo.repo;

import com.example.demo.entity.SignedInDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Check extends JpaRepository<SignedInDetails, String> {
}
