package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CntPhone;

public interface CntPhoneRepository extends JpaRepository<CntPhone, Integer> {

}
