package com.data;

import java.time.LocalDate;

public class Route {
	private int routeId;
	private String source;
	private String destination;
	private LocalDate journeyDate;
	private double ticketPrice;
	private int numOfSeatsAvailable;
	
	public Route(int routeId, String source, String destination, LocalDate journeyDate, double ticketPrice,
			int numOfSeatsAvailable) {
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.ticketPrice = ticketPrice;
		this.numOfSeatsAvailable = numOfSeatsAvailable;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getNumOfSeatsAvailable() {
		return numOfSeatsAvailable;
	}

	public void setNumOfSeatsAvailable(int numOfSeatsAvailable) {
		this.numOfSeatsAvailable = numOfSeatsAvailable;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", journeyDate="
				+ journeyDate + ", ticketPrice=" + ticketPrice + ", numOfSeatsAvailable=" + numOfSeatsAvailable + "]";
	}
	
	
}
