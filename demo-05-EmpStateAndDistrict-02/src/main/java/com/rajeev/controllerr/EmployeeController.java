package com.rajeev.controllerr;

import com.rajeev.dto.EmployeeDTO;
import com.rajeev.model.District;
import com.rajeev.model.State;
import com.rajeev.repo.StateRepo;
import com.rajeev.service.DistrictService;
import com.rajeev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private StateRepo repo;

 
    @GetMapping("/states")
    @ResponseBody
    public List<State> getAllStates() {
        return repo.findAll();  
    }
    
    
   
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("states", employeeService.getAllState());
        return "emp_register";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, Model model) {
        EmployeeDTO savedEmployee = employeeService.registerEmployee(employeeDTO);
        model.addAttribute("employee", savedEmployee);
        return "emp_register_success"; 
    }

    
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeDTOList);
        return "emp_list"; 
    }

    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        model.addAttribute("employeeDTO", employeeDTO);
        return "emp_register"; 
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, Model model) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        model.addAttribute("employee", updatedEmployee);
        return "emp_register_success"; 
    }

   
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list"; 
    }
    
    @GetMapping("/districts/{stateId}")
    @ResponseBody
    public List<District> getDistrictsByStateId(@PathVariable Long stateId) {
    	   List<District> districts = districtService.getDistrictsByStateId(stateId);  // Fetch districts based on stateId
           return districts;
    }
}
