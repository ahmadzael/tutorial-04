package com.apap.tu04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDb flightDb;

	public FlightServiceImpl() {
	}
	
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		return flightDb.findByFlightNumber(flightNumber);
	
	}

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public void deleteFlight(String flightNumber) {
		flightDb.delete(getFlightDetailByFlightNumber(flightNumber));
	}



	

}
