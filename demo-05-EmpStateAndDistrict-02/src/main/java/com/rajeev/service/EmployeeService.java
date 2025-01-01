package com.rajeev.service;

import com.rajeev.dto.EmployeeDTO;
import com.rajeev.model.State;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO registerEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    
    List<State> getAllState();
}
