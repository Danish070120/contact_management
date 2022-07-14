package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CntPerson;

public interface CntPersonRepository extends JpaRepository<CntPerson, Integer> {

}
