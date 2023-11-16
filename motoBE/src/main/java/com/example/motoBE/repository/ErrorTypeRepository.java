package com.example.motoBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.motoBE.model.ErrorType;

public interface ErrorTypeRepository extends JpaRepository<ErrorType, Integer>{
	
}