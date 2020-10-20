package com.bl.cabservice.invoice;

public class InvoiceSummary {
	private int totalRides;
	private double totalFare;
	private double avgFarePerRide;

	public InvoiceSummary(int totalRides, double totalFare) {
		this.totalRides = totalRides;
		this.totalFare = totalFare;
		this.avgFarePerRide = totalFare / totalRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(avgFarePerRide) != Double.doubleToLongBits(other.avgFarePerRide))
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (totalRides != other.totalRides)
			return false;
		return true;
	}
}
