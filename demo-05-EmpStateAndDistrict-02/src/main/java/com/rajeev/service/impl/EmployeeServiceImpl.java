package com.rajeev.service.impl;

import com.rajeev.dto.EmployeeDTO;
import com.rajeev.model.Employee;
import com.rajeev.model.State;
import com.rajeev.model.District;
import com.rajeev.repo.EmployeeRepo;
import com.rajeev.repo.StateRepo; // Assuming you have a State repository
import com.rajeev.repo.DistrictRepo; // Assuming you have a District repository
import com.rajeev.service.EmployeeService;
import com.rajeev.dto.EmployeeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
	public List<State> getAllState() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}
    
    
	@Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private StateRepo stateRepo; // Inject the State repository

    @Autowired
    private DistrictRepo districtRepo; // Inject the District repository

    @Override
    public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO) {
        // Create the Employee entity from the DTO
        Employee employee = EmployeeConverter.toEntity(employeeDTO);

        // Fetch the actual State and District entities using their IDs
        if (employeeDTO.getStateId() != null) {
            State state = stateRepo.findById(employeeDTO.getStateId()).orElseThrow(() -> new RuntimeException("State not found"));
            employee.setState(state);  // Set the state object (not just the stateId)
        }

        if (employeeDTO.getDistrictId() != null) {
            District district = districtRepo.findById(employeeDTO.getDistrictId()).orElseThrow(() -> new RuntimeException("District not found"));
            employee.setDistrict(district);  // Set the district object (not just the districtId)
        }

        // Save the employee
        Employee savedEmployee = employeeRepo.save(employee);

        // Return the saved employee as a DTO
        return EmployeeConverter.toDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeConverter.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(EmployeeConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        // Fetch the employee by ID, or throw exception if not found
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        // Update other fields
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setPost(employeeDTO.getPost());
        existingEmployee.setDob(employeeDTO.getDob());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setAddress(employeeDTO.getAddress());
        existingEmployee.setMobile_number(employeeDTO.getMobileNumber());

        // Fetch the actual State and District objects if the IDs are provided
        if (employeeDTO.getStateId() != null) {
            State state = stateRepo.findById(employeeDTO.getStateId()).orElseThrow(() -> new RuntimeException("State not found"));
            existingEmployee.setState(state);  // Set the state
        }

        if (employeeDTO.getDistrictId() != null) {
            District district = districtRepo.findById(employeeDTO.getDistrictId()).orElseThrow(() -> new RuntimeException("District not found"));
            existingEmployee.setDistrict(district);  // Set the district
        }

        // Save the updated employee
        Employee updatedEmployee = employeeRepo.save(existingEmployee);

        // Return the updated employee as a DTO
        return EmployeeConverter.toDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
