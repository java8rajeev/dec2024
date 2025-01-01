package com.rajeev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
