package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CntAddress;

public interface CntAddressRepository extends JpaRepository<CntAddress, Integer> {

}
