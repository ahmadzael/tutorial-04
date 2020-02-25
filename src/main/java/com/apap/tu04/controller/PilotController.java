package com.apap.tu04.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

@Controller
public class PilotController {

	public PilotController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping("/pilot/view")
	public String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel  pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber); 
		
		model.addAttribute("pilot", pilot);
		model.addAttribute("flights",pilot.getPilotFlight());
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/delete")
	public String deletePilot(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		//PilotModel  pilot = pilotService.getPilotDetailByLicenseNummber(licenseNumber); 
		
		pilotService.deletePilot(licenseNumber);
		return "delete";
	}
	
	
	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "update-pilot";	
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel updatedPilot = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		updatedPilot.setFlyhour(pilot.getFlyhour());
		updatedPilot.setName(pilot.getName());
		pilotService.addPilot(updatedPilot);
		return "update";
	}
	
	

}
