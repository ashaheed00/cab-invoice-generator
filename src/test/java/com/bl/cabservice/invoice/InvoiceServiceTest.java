package com.bl.cabservice.invoice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bl.cabservice.rides.CabRide;
import com.bl.cabservice.rides.Ride;
import com.bl.cabservice.rides.RideRepository;

public class InvoiceServiceTest {
	InvoiceService invoiceService;
	RideRepository rideRepository;

	@Before
	public void initializer() {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
	}

	@Test
	public void givenDistanceTimeShouldReturnTotalFare() {
		double fare = invoiceService.calculateFarePerRide(2.5, 5);
		assertEquals(30, fare, 0);
		fare = invoiceService.calculateFarePerRide(0.2, 1);
		assertEquals(5, fare, 0);
	}

	@Test
	public void givenUserIdAndRides_ForNormaAndPremimum_ShouldReturnInvoiceSummary() {
		String userId = "user@id.com";
		Ride[] rides = { new Ride(CabRide.PREMIUM, 2, 5), new Ride(CabRide.NORMAL, 0.2, 1),
				new Ride(CabRide.NORMAL, 5, 5) };
		invoiceService.setRideRepository(rideRepository);
		invoiceService.addRides(userId, rides);
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 100);
		assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
