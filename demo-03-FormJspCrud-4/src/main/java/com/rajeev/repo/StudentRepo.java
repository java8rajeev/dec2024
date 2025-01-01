package com.rajeev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
