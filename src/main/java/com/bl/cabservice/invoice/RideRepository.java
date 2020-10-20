package com.bl.cabservice.invoice;

import java.util.*;

public class RideRepository {
	private Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<>();
	}

	public RideRepository(Map<String, ArrayList<Ride>> userRides) {
		this.userRides = userRides;
	}

	public void addUserRide(String userId, Ride[] rides) {
		if (userRides.get(userId) == null)
			userRides.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
	}

	public Ride[] getUserRides(String userId) {
		return userRides.get(userId).toArray(new Ride[0]);
	}
}
