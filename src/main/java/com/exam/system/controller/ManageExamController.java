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
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.system.models.ManageExam;
import com.exam.system.models.ManageQuestion;
import com.exam.system.service.ManageExamService;

@Controller
public class ManageExamController {

	@Autowired
	private ManageExamService service;
	
	@GetMapping("/exam")
	public String examList(Model model)
	{
		List<ManageExam> examlist=service.getExam();
		model.addAttribute("examList",examlist);
		return "manageExam";
	}
	
	@GetMapping("/exam/addExam")
	public String AddExam( ManageExam exam)
	{
		service.addExam(exam);
		return "redirect:/exam";
	}
	
	@RequestMapping("/exam/findById")
	@ResponseBody
	public Optional<ManageExam> findById(long id)
	{
		return service.findById(id);
	}
	
	@RequestMapping(value = "/exam/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String updateExam(ManageExam exam)
	{
		service.addExam(exam);
		return "redirect:/exam";
	}
	
	@RequestMapping(value = "/exam/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteExam(long id)
	{
		service.delete(id);
		return "redirect:/exam";
	}
	

	
	
	
	


}
