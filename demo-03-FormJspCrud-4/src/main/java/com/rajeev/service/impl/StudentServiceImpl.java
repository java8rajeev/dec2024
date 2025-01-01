package com.rajeev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeev.model.Student;
import com.rajeev.repo.StudentRepo;
import com.rajeev.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepo repo;
	@Override
	public Long saveStd(Student std) {
		// TODO Auto-generated method stub
		return repo.save(std).getId();
	}

	@Override
	public void deleteStd(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void updateStd(Student std) {
		// TODO Auto-generated method stub
		repo.save(std);
	}

	@Override
	public boolean isPresent(Long id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public Optional<Student> getOne(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
