package com.example.motoBE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motoBE.model.SymptomType;
import com.example.motoBE.repository.SymptomTypeRepository;

@RestController
@RequestMapping("/api/symptomtype")
public class SymptomTypeController {
	
	@Autowired
	SymptomTypeRepository  symptomTypeRepository;
	
	@PostMapping("/add")
	public SymptomType addST(@RequestBody SymptomType pathST) {
		symptomTypeRepository.save(pathST);
		return pathST;
	}
}
