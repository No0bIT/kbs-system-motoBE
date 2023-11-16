package com.example.motoBE.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Error {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	 	
	    private String code;
	    private String name;
	    private String linkImg;
	    private String repair;
	    private int flag;
	    
	    @JsonIgnoreProperties("relatedErrors")
	    @ManyToMany
	    @JoinTable(
	        name = "error_symptom",
	        joinColumns = @JoinColumn(name = "error_id"),
	        inverseJoinColumns = @JoinColumn(name = "symptom_id")
	    )
	    private List<Symptom> relatedSymptoms;
	    
	    @JsonIgnoreProperties("errors")
	    @ManyToOne
	    @JoinColumn(name = "error_type_id")
	    private ErrorType errorType;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getRepair() {
			return repair;
		}

		public void setRepair(String repair) {
			this.repair = repair;
		}

		public int getFlag() {
			return flag;
		}

		public void setFlag(int flag) {
			this.flag = flag;
		}

		public List<Symptom> getRelatedSymptoms() {
			return relatedSymptoms;
		}

		public void setRelatedSymptoms(List<Symptom> relatedSymptoms) {
			this.relatedSymptoms = relatedSymptoms;
		}

		public ErrorType getErrorType() {
			return errorType;
		}

		public void setErrorType(ErrorType errorType) {
			this.errorType = errorType;
		}
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLinkImg() {
			return linkImg;
		}

		public void setLinkImg(String linkImg) {
			this.linkImg = linkImg;
		}		
}
