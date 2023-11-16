package com.example.motoBE.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Symptom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String code;
    private String description;
    private int flag;

    @JsonIgnoreProperties("relatedSymptoms")
    @ManyToMany(mappedBy = "relatedSymptoms")
    private List<Error> relatedErrors;
    
    @JsonIgnoreProperties("symptoms")
    @ManyToOne
    @JoinColumn(name = "symptom_type_id")
    private SymptomType symptomType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Error> getRelatedErrors() {
		return relatedErrors;
	}

	public void setRelatedErrors(List<Error> relatedErrors) {
		this.relatedErrors = relatedErrors;
	}



	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public SymptomType getSymptomType() {
		return symptomType;
	}

	public void setSymptomType(SymptomType symptomType) {
		this.symptomType = symptomType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

    
    
}
