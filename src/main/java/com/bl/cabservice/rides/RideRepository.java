package com.bl.cabservice.rides;

import java.util.*;

public class RideRepository {
	private Map<String, ArrayList<Ride>> userRidesMap;

	public RideRepository() {
		userRidesMap = new HashMap<>();
	}

	public RideRepository(Map<String, ArrayList<Ride>> userRides) {
		this.userRidesMap = userRides;
	}

	public void addUserRide(String userId, Ride[] rides) {
		if (userRidesMap.get(userId) == null)
			userRidesMap.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
	}

	public Ride[] getUserRides(String userId) {
		return userRidesMap.get(userId).toArray(new Ride[0]);
	}
}
