package com.example.motoBE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motoBE.model.Symptom;
import com.example.motoBE.repository.SymptomRepository;

@RestController
@RequestMapping("/api/symptom")
public class SymptomController {

	@Autowired
	SymptomRepository symptomRepository;
	
	@PostMapping("/add")
	public Symptom addS(@RequestBody Symptom s)
	{
		symptomRepository.save(s);
		return s;
	}
}
