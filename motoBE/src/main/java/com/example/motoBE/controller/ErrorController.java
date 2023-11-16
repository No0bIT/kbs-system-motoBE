package com.example.motoBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motoBE.model.Error;
import com.example.motoBE.model.ErrorType;
import com.example.motoBE.model.Symptom;
import com.example.motoBE.repository.ErrorRepository;
import com.example.motoBE.repository.ErrorTypeRepository;
import com.example.motoBE.repository.SymptomRepository;
import com.example.motoBE.repository.SymptomTypeRepository;







@RestController
@RequestMapping("/api/error")
public class ErrorController {

	@Autowired
	ErrorTypeRepository errorTypeRepository;
	
	@Autowired
	ErrorRepository errorRepository;
	
	@Autowired
	SymptomTypeRepository symptomTypeRepository;
	
	@Autowired
	SymptomRepository symptomRepository;
	
	@PostMapping("/add")
	public Error error(@RequestBody Error pathError) {
		errorRepository.save(pathError);		
		return pathError;
		
	}

//	@PostMapping("/editById/{id}")
//	public Error editError(@RequestBody Error pathError,@) {
//		errorRepository.save(pathError);		
//		return pathError;
//		
//	}
	@PostMapping("/addES/{ide}/{ids}")
	public Error addES(@PathVariable int ide,@PathVariable int ids) {
		Error e= errorRepository.getById(ide);
		Symptom s= symptomRepository.getById(ids);
		List<Symptom> listS= e.getRelatedSymptoms();
		listS.add(s);
		errorRepository.save(e);
		return errorRepository.getById(ids);
	}
	
}
