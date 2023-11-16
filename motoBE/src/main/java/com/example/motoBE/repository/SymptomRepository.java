package com.example.motoBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.motoBE.model.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Integer>{
	
}
