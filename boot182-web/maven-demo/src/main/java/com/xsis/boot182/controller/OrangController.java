package com.xsis.boot182.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xsis.boot182.model.Orang;
import com.xsis.boot182.service.OrangService;

@RestController
public class OrangController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private OrangService orangService;
	
	@RequestMapping("/orang.html")
	public String orang(Model model) {
		List<Orang> orangList = this.orangService.getList();
		model.addAttribute("budiList", orangList);
		return "orang/orang";
	}
	
	@RequestMapping(value="/orang/", method=RequestMethod.POST)
	public ResponseEntity<Orang> save(@RequestBody Orang org) {
		ResponseEntity<Orang> result = null;
		try {
			this.orangService.insert(org);
			result = new ResponseEntity<>(org, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<Orang>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/orang/", method=RequestMethod.GET)
	public ResponseEntity<List<Orang>> getAll() {
		ResponseEntity<List<Orang>> result = null;
		try {
			List<Orang> list = this.orangService.getList();
			result = new ResponseEntity<List<Orang>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
