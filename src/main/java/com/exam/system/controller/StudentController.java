package com.exam.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.system.models.StudentRegister;
import com.exam.system.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service; 
	
	@GetMapping("/addStudent")
	public String AddStudent(StudentRegister register)
	{
		service.saveStudent(register);
		return "index";
	}
	
	
}
