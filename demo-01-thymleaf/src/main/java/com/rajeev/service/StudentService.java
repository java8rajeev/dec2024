package com.rajeev.service;

import java.util.List;
import java.util.Optional;

import com.rajeev.model.Student;

public interface StudentService {
  
	
	Long saveStd(Student std);
	List<Student> getAll();
	Optional<Student> getOne(Long id);
	void deleteStd(Long id);
	void updateStd(Student std);
	boolean isPresent(Long id);
}
