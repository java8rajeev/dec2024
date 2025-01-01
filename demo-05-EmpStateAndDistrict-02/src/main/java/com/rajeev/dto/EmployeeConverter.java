package com.rajeev.dto;

import com.rajeev.model.Employee;
import com.rajeev.dto.EmployeeDTO;

public class EmployeeConverter {

    // Method to convert Employee entity to EmployeeDTO
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setPost(employee.getPost());
        dto.setDob(employee.getDob());
        dto.setSalary(employee.getSalary());
        dto.setAddress(employee.getAddress());
        dto.setMobileNumber(employee.getMobile_number());
        dto.setStateId(employee.getState() != null ? employee.getState().getStateId() : null);
        dto.setDistrictId(employee.getDistrict() != null ? employee.getDistrict().getDistrictId() : null);
        return dto;
    }

    // Method to convert EmployeeDTO to Employee entity if needed (e.g., for saving)
    public static Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setPost(employeeDTO.getPost());
        employee.setDob(employeeDTO.getDob());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAddress(employeeDTO.getAddress());
        employee.setMobile_number(employeeDTO.getMobileNumber());
        // If you need to set the state and district objects as well, fetch them by IDs
        return employee;
    }
}
