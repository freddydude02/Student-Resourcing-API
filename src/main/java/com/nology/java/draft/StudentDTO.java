package com.nology.java.draft;

import javax.validation.constraints.NotNull;

public class StudentDTO {
	
	@NotNull
	public String fullname;
	
	@NotNull
	public String cohort;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getCohort() {
		return cohort;
	}
	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
	
	
}
