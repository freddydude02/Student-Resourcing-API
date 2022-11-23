package com.nology.java.draft;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> all() {
		return repository.findAll();
	}
	
	public void create(StudentDTO student) {
		Student s = new Student(student.getFullname(), student.getCohort());
		repository.save(s);
	}
	
	public Student get(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
   public Student update(Long id, StudentDTO studentData) {
        Student fetchedStudent = this.get(id);
        
        if (fetchedStudent == null) return null;
        
        Student existentStudent = fetchedStudent;
        if(studentData.getFullname() != null && !studentData.getFullname().equals("")) {
            existentStudent.setFullname(studentData.getFullname());
        }
        if(studentData.getCohort() != null && !studentData.getCohort().equals("")) {
            existentStudent.setCohort(studentData.getCohort());
        }
        
        return this.repository.save(existentStudent);
    }
	
}
