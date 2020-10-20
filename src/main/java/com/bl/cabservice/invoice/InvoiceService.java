package com.bl.cabservice.invoice;

import com.bl.cabservice.rides.Ride;
import com.bl.cabservice.rides.RideRepository;

public class InvoiceService {
	private RideRepository rideRepository;

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += ride.cabRideType.calculateFarePerRide(ride.distance, ride.timeInMinute);
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return calculateFare(rideRepository.getUserRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addUserRide(userId, rides);
	}

}
