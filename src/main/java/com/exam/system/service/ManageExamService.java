package com.exam.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.system.models.ManageExam;
import com.exam.system.models.ManageQuestion;
import com.exam.system.models.StudentRegister;
import com.exam.system.repository.ManageExamRepositorty;
import com.exam.system.repository.ManageQuestionRepositorty;
import com.exam.system.repository.StudentRepository;

@Service
public class ManageExamService {

	@Autowired
	private ManageExamRepositorty repository;
	
	@Autowired
	private ManageQuestionRepositorty questionRepositorty;
	
	public void addExam(ManageExam exam)
	{
		repository.save(exam);
	}
	
	public List<ManageExam> getExam()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		repository.deleteById(id);
	}
	
	public Optional<ManageExam> findById(long id)
	{
		return repository.findById(id);
	}
	
	public ManageExam getExamById(long id)
	{
		return repository.findById(id).get();
	}
	
	public void saveQuestion(ManageQuestion question)
	{
		questionRepositorty.save(question);
	}
	
	public List<ManageExam> getseachExam(String keyword)
	{
		return repository.findByKeyword(keyword);
	}
	

	
}
