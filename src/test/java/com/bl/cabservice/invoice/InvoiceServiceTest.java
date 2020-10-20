package com.bl.cabservice.invoice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceService invoiceService;

	@Before
	public void initializer() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceTimeShouldReturnTotalFare() {
		double fare = invoiceService.calculateFare(2.5, 5);
		assertEquals(30, fare, 0);
		fare = invoiceService.calculateFare(0.2, 1);
		assertEquals(5, fare, 0);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		InvoiceSummary actualInvoiceSummary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 35);
		assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	@Test
	public void givenUserIdAndRidesShouldReturnInvoiceSummary() {
		String userId = "user@id.com";
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 35);
		assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
