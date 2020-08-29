package com.exam.system.service;

import java.util.List;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.system.models.ManageExam;
import com.exam.system.models.ManageQuestion;
import com.exam.system.repository.ManageQuestionRepositorty;


@Service
public class ManageQuestionService {

	@Autowired
	private ManageQuestionRepositorty questionRepositorty;
	
	public void saveQuestion(ManageQuestion question)
	{
		questionRepositorty.save(question);
	}
	
	@PrePersist
	public List<ManageQuestion> findByExamid(long examid)
	{
		return questionRepositorty.findByExamid(examid);
	}
	
	public List<ManageQuestion> getQuestionAll()
	{
		return questionRepositorty.findAll();
	}
	
	
	public List<ManageQuestion> getJsonData()
	{
		return questionRepositorty.findAll();
	}
	
			
}
