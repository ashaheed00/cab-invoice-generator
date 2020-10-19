package com.bl.cabservice.invoice;

public class InvoiceGenerator {
	private final double COST_PER_KM = 10;
	private final double COST_PER_MINUTE = 1;
	private final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int timeInMinute) {
		double fare = distance * COST_PER_KM + timeInMinute * COST_PER_MINUTE;
		return fare < 5 ? MINIMUM_FARE : fare;
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += calculateFare(ride.distance, ride.timeInMinute);
		return totalFare;
	}

}
