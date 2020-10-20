package com.bl.cabservice.rides;

public enum CabRide {

	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

	private final double COST_PER_KM;
	private final double COST_PER_MINUTE;
	private final double MINIMUM_FARE;

	private CabRide(double costPerKm, double costPerMin, double mimumFare) {
		this.COST_PER_KM = costPerKm;
		this.COST_PER_MINUTE = costPerMin;
		this.MINIMUM_FARE = mimumFare;
	}

	public double calculateFarePerRide(double distance, int timeInMinute) {
		double fare = distance * COST_PER_KM + timeInMinute * COST_PER_MINUTE;
		return fare < MINIMUM_FARE ? MINIMUM_FARE : fare;
	}
}
