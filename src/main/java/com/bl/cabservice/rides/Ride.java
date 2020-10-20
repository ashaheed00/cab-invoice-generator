package com.bl.cabservice.rides;

public class Ride {

	public double distance;
	public int timeInMinute;
	public CabRide cabRideType;

	public Ride(CabRide cabRideType, double distance, int timeInMinute) {
		this.cabRideType = cabRideType;
		this.distance = distance;
		this.timeInMinute = timeInMinute;
	}
}
