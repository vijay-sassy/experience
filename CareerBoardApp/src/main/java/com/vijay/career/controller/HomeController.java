package com.vijay.career.controller;

import java.time.Period;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vijay.career.service.ExperienceService;

@Controller
public class HomeController {
	
	@Autowired
	ExperienceService exService;
	
	@GetMapping("/home")
	public String homeScreen(Model model) {
		
		Map<String, Period> experienceMap = exService.findTotalExperience();		
		model.addAttribute("experience", experienceMap);
		
		return "index";
	}
}
