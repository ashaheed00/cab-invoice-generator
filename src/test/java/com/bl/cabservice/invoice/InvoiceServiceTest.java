package com.bl.cabservice.invoice;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double fare = invoiceGenerator.calculateFare(2.5, 5);
		assertEquals(30, fare, 0);
		fare = invoiceGenerator.calculateFare(0.2, 1);
		assertEquals(5, fare, 0);
	}

	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		double fare = invoiceGenerator.calculateFare(rides);
		assertEquals(35, fare, 0);
	}

}
