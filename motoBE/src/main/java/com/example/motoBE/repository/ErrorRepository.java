package com.example.motoBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.motoBE.model.Error;

public interface ErrorRepository extends JpaRepository<Error, Integer> {

}
