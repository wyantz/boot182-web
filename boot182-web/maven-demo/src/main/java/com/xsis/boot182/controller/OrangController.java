package com.xsis.boot182.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.boot182.model.Orang;
import com.xsis.boot182.service.OrangService;

@Controller
public class OrangController {
	
	@Autowired
	private OrangService orangService;
	
	@RequestMapping("/orang.html")
	public String orang(Model model) {
		List<Orang> orangList = this.orangService.getList();
		model.addAttribute("budiList", orangList);
		return "orang/orang";
	}
}
