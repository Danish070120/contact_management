package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Phonetype;

public interface PhonetypeRepository extends JpaRepository<Phonetype, Integer> {

}
