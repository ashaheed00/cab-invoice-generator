package com.bl.cabservice.invoice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator;

	@Before
	public void initializer() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceTimeShouldReturnTotalFare() {
		double fare = invoiceGenerator.calculateFare(2.5, 5);
		assertEquals(30, fare, 0);
		fare = invoiceGenerator.calculateFare(0.2, 1);
		assertEquals(5, fare, 0);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.5, 5), new Ride(0.2, 1) };
		InvoiceSummary actualInvoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 35);
		assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

}
