package com.nology.java.draft;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	

	@GetMapping
	public List<Student> getStudents() {
		return studentService.all();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveStudent(@Valid @RequestBody StudentDTO student) {
		studentService.create(student);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> get(@PathVariable Long id){
		Optional<Student> student = studentService.get(id);
		
		if (Optional.empty().equals(student)) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PatchMapping(value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentDTO data){
        Student student = studentService.update(id, data);
        if(student == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.NO_CONTENT);
    }

   @DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		Boolean student = studentService.delete(id);
		if (student == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
   
}
