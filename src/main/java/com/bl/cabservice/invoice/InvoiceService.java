package com.bl.cabservice.invoice;

public class InvoiceService {
	private final double COST_PER_KM = 10;
	private final double COST_PER_MINUTE = 1;
	private final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public InvoiceService() {
		rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, int timeInMinute) {
		double fare = distance * COST_PER_KM + timeInMinute * COST_PER_MINUTE;
		return fare < 5 ? MINIMUM_FARE : fare;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += calculateFare(ride.distance, ride.timeInMinute);
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return calculateFare(rideRepository.getUserRides(userId));
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addUserRide(userId, rides);
	}

}
