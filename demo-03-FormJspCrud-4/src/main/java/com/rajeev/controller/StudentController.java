package com.rajeev.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rajeev.model.Student;
import com.rajeev.service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService service;
	@GetMapping("/std")
    public String getStdPage() {
		return "std_register";
	}
	@PostMapping("/save")
	public String save(Student std){
		service.saveStd(std);
		return "redirect:/all";
	}
	@GetMapping("/edit/{id}")
    public String geteditPage(@PathVariable("id")Long id,Model model) {
		boolean present = service.isPresent(id);
		if(present) {
			Optional<Student> std= service.getOne(id);
			model.addAttribute("std", std.get());
		}
		return "std_edit";
	}
	@PostMapping("/update")
	public String update(Student std){
		service.saveStd(std);
		return "redirect:/all";
	}
	
	@GetMapping("/delete/{id}")
    public String getdeletePage(@PathVariable("id")Long id) {
		boolean present = service.isPresent(id);
		if(present) {
			service.deleteStd(id);
		}
		return "redirect:/all";
	}
	@GetMapping("/all")
    public String getlistPage(Model model) {
		model.addAttribute("students",service.getAll() );
		return "std_list";
	}
}
