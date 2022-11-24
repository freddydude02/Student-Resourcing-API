package com.nology.java.draft;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository sRepo;
	
	public List<Student> all() {
		return sRepo.findAll();
	}
	
	public void create(StudentDTO student) {
		Student s = new Student(student.getFullname(), student.getCohort());
		sRepo.save(s);
	}
	
	public Optional<Student> get(Long id) {
		return sRepo.findById(id);
	}
	
	public Boolean delete(Long id) {
		Optional<Student> fetchedStudent = get(id);
		if (fetchedStudent.isEmpty()) return null;
		sRepo.deleteById(id);
		return true;
	}
	
   public Student update(Long id, StudentDTO studentData) {
        Optional<Student> fetchedStudent = this.get(id);
        
        if (fetchedStudent.isEmpty()) return null;
        
        Student existentStudent = sRepo.findById(id).get();
        if(studentData.getFullname() != null && !studentData.getFullname().equals("")) {
            existentStudent.setFullname(studentData.getFullname());
        }
        if(studentData.getCohort() != null && !studentData.getCohort().equals("")) {
            existentStudent.setCohort(studentData.getCohort());
        }
        
        return this.sRepo.save(existentStudent);
    }
	
}
