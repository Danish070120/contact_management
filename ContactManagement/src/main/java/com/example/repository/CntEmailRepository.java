package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CntEmail;

public interface CntEmailRepository extends JpaRepository<CntEmail, Integer> {

}
