package com.exam.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.system.models.StudentRegister;
import com.exam.system.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public void saveStudent(StudentRegister register)
	{
		repository.save(register);
	}
}
