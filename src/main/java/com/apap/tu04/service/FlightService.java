package com.apap.tu04.service;

import com.apap.tu04.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);

}
