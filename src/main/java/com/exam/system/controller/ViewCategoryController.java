package com.exam.system.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.system.models.ManageQuestion;
import com.exam.system.models.TestRecord;
import com.exam.system.repository.TestRepository;
import com.exam.system.service.ManageExamService;
import com.exam.system.service.ManageQuestionService;
import com.exam.system.service.TestService;

@Controller
public class ViewCategoryController {

	@Autowired
	private ManageExamService examService;
	
	@Autowired
	private ManageQuestionService questionService;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/viewCategory")
	public String ViewCategoryPage()
	{
		return "viewCategory";
	}
	
	@GetMapping("/viewCategory/search")
	public String examList(Model model,String keyword)
	{
		if(keyword != null)
		{
			model.addAttribute("examList",examService.getseachExam(keyword));
		}else
		{
			model.addAttribute("examList",examService.getExam());	
		}
		return "viewCategory";
	}
	
	@RequestMapping("/viewCategory/test")
	public String GiveTest(TestRecord record)
	{
		testService.saveTest(record);
		return "redirect:/viewCategory/search";
	}
	
	@RequestMapping("/question")
	public String quiz(Model model,ManageQuestion manageQuestion)
	{
		model.addAttribute("question",questionService.getQuestionAll());
		return "question";
	}
	
	@RequestMapping("/jsonData")
	public String fatchdata()
	{
		return "fatch";
	}
}
