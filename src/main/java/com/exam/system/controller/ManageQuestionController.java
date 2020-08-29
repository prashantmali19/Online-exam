package com.exam.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.system.models.ManageExam;
import com.exam.system.models.ManageQuestion;
import com.exam.system.service.ManageExamService;
import com.exam.system.service.ManageQuestionService;

@Controller
public class ManageQuestionController {

	@Autowired
	private ManageExamService examService;
	

	@Autowired
	private ManageQuestionService questionService;
	
	@RequestMapping("/addquestion")
	public String AddQuestiion()
	{
		return "addQuestion";
	}
	
	@RequestMapping("/addquestion/save")
	public String addQuestion(ManageQuestion question)
	{
	questionService.saveQuestion(question);
		return "redirect:/addquestion";
	}
	
	@RequestMapping("/questionPage")
	public String findQuestion()
	{
		return "questionList";
	}
	
	@GetMapping("/questionPage/search")
	public String examList(Model model,long examid)
	{
		if(examid != 0)
		{
			model.addAttribute("questionlist",questionService.findByExamid(examid));
		}else
		{
			model.addAttribute("questionlist",questionService.getQuestionAll());	
		}
		return "questionList";
	}
	

	
	

	@GetMapping("/data")
	public String question_database(Model model)
	{
		
			model.addAttribute("questionlist",questionService.getQuestionAll());	
	
		return "quiz_page";
	}
	
	
	@GetMapping("/viewCategory/test")
	public String test(Model model,long examid)
	{
		if(examid != 0)
		{
			model.addAttribute("questionlist",questionService.findByExamid(examid));
		}else
		{
			model.addAttribute("questionlist",questionService.getQuestionAll());	
		}
		return "quiz_page";
	}
	
	
}




