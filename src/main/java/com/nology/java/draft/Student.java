package com.nology.java.draft;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String fullname;
		private String cohort;
		
		 
		
		public Student(String fullname, String cohort) {

			this.setFullname(fullname);
			this.setCohort(cohort);
		}

		public Student() {}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
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

