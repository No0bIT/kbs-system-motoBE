package com.example.motoBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motoBE.model.ErrorType;
import com.example.motoBE.repository.ErrorRepository;
import com.example.motoBE.repository.ErrorTypeRepository;

@RestController
@RequestMapping("/api/errortype")
public class ErrorTypeController {
	
	@Autowired
	ErrorTypeRepository errorTypeRepository;
	@PostMapping("/add")
	public ErrorType addET(@RequestBody ErrorType e) {
		errorTypeRepository.save(e);	
		return errorTypeRepository.getById(e.getId());
	}
	@PostMapping("/edit")
	public ErrorType editET(@RequestBody ErrorType e) {
		errorTypeRepository.save(e);		
		return errorTypeRepository.getById(e.getId());
	}
	@GetMapping("/getall")
	public List<ErrorType> getAll(){
		return errorTypeRepository.findAll();
	}

}
