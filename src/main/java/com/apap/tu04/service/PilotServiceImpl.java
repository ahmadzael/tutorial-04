package com.apap.tu04.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	
	@Autowired
	private PilotDb pilotDb;

	public PilotServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.save(pilot);
		
	}
	
	@Override
	public void deletePilot(String licenseNumber) {
		pilotDb.delete(getPilotDetailByLicenseNumber(licenseNumber));
	}

	

}
