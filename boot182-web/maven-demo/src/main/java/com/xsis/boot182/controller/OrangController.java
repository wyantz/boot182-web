package com.xsis.boot182.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xsis.boot182.model.Orang;
import com.xsis.boot182.service.OrangService;

@Controller
public class OrangController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private OrangService orangService;
	
	@RequestMapping("/orang.html")
	public String orang(Model model) {
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
			log.error(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

	@RequestMapping(value="/orang/abc/{namayangdicari}", method=RequestMethod.GET)
	public ResponseEntity<List<Orang>> getByNama(@PathVariable("namayangdicari") String nama) {
		log.debug("Pencarian by nama");
		ResponseEntity<List<Orang>> result = null;
		try {
			List<Orang> list = this.orangService.getList();
			result = new ResponseEntity<List<Orang>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

	@RequestMapping(value="/orang/{idnyaorang}", method=RequestMethod.GET)
	public ResponseEntity<Orang> get(@PathVariable(name="idnyaorang") Integer id) {
		ResponseEntity<Orang> result = null;
		try {
			Orang orang = this.orangService.getData(id);
			result = new ResponseEntity<Orang>(orang, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/orang/", method=RequestMethod.PUT)
	public ResponseEntity<Orang> update(@RequestBody Orang orang) {
		ResponseEntity<Orang> result = null;
		try {
			this.orangService.update(orang);
			result = new ResponseEntity<Orang>(orang, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;		
	}

	@RequestMapping(value="/orang/{idnyaorang}", method=RequestMethod.DELETE)
	public ResponseEntity<Orang> hapus(@PathVariable(name="idnyaorang") Integer id) {
		try {
			Orang orang = this.orangService.getData(id);
			if (orang!=null) {
				this.orangService.delete(orang);
				return new ResponseEntity<Orang>(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);				
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
