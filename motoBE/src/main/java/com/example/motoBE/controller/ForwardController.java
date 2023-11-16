package com.example.motoBE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.motoBE.model.Error;
import com.example.motoBE.model.Symptom;

@RestController
@RequestMapping("api/forward")
public class ForwardController {
	public class RequestBody1{
	    private List<Error> errors;
	    private List<Symptom> symptoms;
		public List<Error> getErrors() {
			return errors;
		}
		public void setErrors(List<Error> errors) {
			this.errors = errors;
		}
		public List<Symptom> getSymptoms() {
			return symptoms;
		}
		public void setSymptoms(List<Symptom> symptoms) {
			this.symptoms = symptoms;
		}

	    // getters, setters, constructors
	    
	}
	
	@PostMapping("/get/first")
	public List<Error> getForwardFirst(@RequestBody List<Symptom> listS){
		List<Error> filteredErrors = listS.stream()
	            .flatMap(symptom -> symptom.getRelatedErrors().stream())
	            .distinct() // Đảm bảo không có Error nào bị lặp lại
	            .collect(Collectors.toList());
		// Tiếp tục xử lý các Error trong filteredErrors
		
		Map<Error, Double> errorRatios = new HashMap<>();
	    for (Error error : filteredErrors) {
	        List<Symptom> relatedSymptoms = error.getRelatedSymptoms();

	        // Đặt lại flag của Symptom trong Error thành 1 nếu có trong danh sách nhận vào
	        for (Symptom symptom : relatedSymptoms) {
	            if (listS.contains(symptom)) {
	                symptom.setFlag(1);
	            }
	        }
	        long countFlagOne = relatedSymptoms.stream()
	                .filter(symptom -> symptom.getFlag() == 1)
	                .count();
	        long totalCount = relatedSymptoms.size();

	        // Tính toán tỷ lệ và đặt vào thuộc tính để sử dụng trong việc sắp xếp
	        double ratio = (double) countFlagOne / totalCount;
	        errorRatios.put(error, ratio);
	    }
	    // Sắp xếp danh sách Error theo tỷ lệ giảm dần
	    List<Error> sortedErrors = errorRatios.entrySet().stream()
                .sorted(Map.Entry.<Error, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
	    return sortedErrors;
	}
	@PostMapping("/get/second")
	public List<Error> getForwardSecond(@RequestBody RequestBody1 requestBody1  ){
		List<Symptom> listS = requestBody1.getSymptoms();
		List<Error> listE = requestBody1.getErrors();
		
		
		List<Error> filteredErrors = listS.stream()
	            .flatMap(symptom -> symptom.getRelatedErrors().stream())
	            .distinct() // Đảm bảo không có Error nào bị lặp lại
	            .collect(Collectors.toList());
		// xóa bỏ các Error có flag = 1 khỏi danh sách
		for(Error error:filteredErrors) {
			if(listE.contains(error)) {
				filteredErrors.remove(error);
			}
		}
		
		// Tiếp tục xử lý các Error trong filteredErrors
		Map<Error, Double> errorRatios = new HashMap<>();
	    for (Error error : filteredErrors) {
	        List<Symptom> relatedSymptoms = error.getRelatedSymptoms();

	        // Đặt lại flag của Symptom trong Error thành 1 nếu có trong danh sách nhận vào
	        for (Symptom symptom : relatedSymptoms) {
	            if (listS.contains(symptom)) {
	                symptom.setFlag(1);
	            }
	        }
	        long countFlagOne = relatedSymptoms.stream()
	                .filter(symptom -> symptom.getFlag() == 1)
	                .count();
	        long totalCount = relatedSymptoms.size();

	        // Tính toán tỷ lệ và đặt vào thuộc tính để sử dụng trong việc sắp xếp
	        double ratio = (double) countFlagOne / totalCount;
	        errorRatios.put(error, ratio);
	    }
	    // Sắp xếp danh sách Error theo tỷ lệ giảm dần
	    List<Error> sortedErrors = errorRatios.entrySet().stream()
                .sorted(Map.Entry.<Error, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
	    return sortedErrors;
	}
}

