package com.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.data.*;

public class JourneyService {
	private List<Route> routes;
	private List<Order> orders;
	
	public JourneyService(List<Route> routes, List<Order> orders) {
		this.routes = routes;
		this.orders = orders;
	}
	
	public void planJourney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n PLan Journey");
		
		System.out.println("Enter Source: ");
		String source = scanner.nextLine();
		
		System.out.println("Enter destination: ");
		String destination = scanner.nextLine();
		
		System.out.println("Enter journey date (YYYY-MM-DD): ");
		String journeydatas = scanner.nextLine();
		LocalDate journeyDate = LocalDate.parse(journeydatas,DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("Enter number of passengers: ");
		int noOfPassengers = scanner.nextInt();
		scanner.nextLine();
		
		List<Route> matchingRoutes = getRoutes(source, destination, journeyDate, noOfPassengers);
		if(!matchingRoutes.isEmpty()) {
			System.out.println("Available Routes: ");
			for(int i =0; i<matchingRoutes.size(); i++) {
				System.out.println((i+1) + ": "+matchingRoutes.get(i));
			}
			System.out.println("Select a route(number): ");
			int routeNumber = scanner.nextInt();
			Route selectedRoute = matchingRoutes.get(routeNumber-1);
			
			Order newOrder = createOrder(journeyDate,noOfPassengers, selectedRoute);
			orders.add(newOrder);
			System.out.println("Journey planned. Order Details: "+ newOrder);
		}
		else System.out.println("No available routes found....");
		}
	
	public void reScheduleJourney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Re-Schedule Journey");
		
		System.out.print("Enter your OrderId: ");
		int orderId = scanner.nextInt();
		scanner.nextLine();
		
		
		Order orderToReschedule = findOrderById(orderId);
		if(orderToReschedule != null) {
			System.out.print("Enter new journey date (YYYY-MM-DD): ");
			String newdateStr = scanner.nextLine();
			LocalDate newdate = LocalDate.parse(newdateStr, DateTimeFormatter.ISO_LOCAL_DATE);
			
			
			List<Route> availableRoutes = getRoutes(orderToReschedule.getRoute().getSource(),
													orderToReschedule.getRoute().getDestination(),
													newdate,
													orderToReschedule.getRequestedJourneyPlan().getNumberOfPassengers());
			
			if(!availableRoutes.isEmpty()) {
				orderToReschedule.getRequestedJourneyPlan().setJourneyDate(newdate);
				System.out.println("Journey rescheduled successfully...");
			}
			else System.out.println("No available route for the new date");
		}
		else System.out.println("Order not found");
	}
	
	private List<Route> getRoutes(String source, String destination, LocalDate journeyDate, int numberOfPassengers){
		List<Route> matchingRoutes = new ArrayList();
		for(Route route: this.routes) {
			if(route.getSource().equalsIgnoreCase(source)&&
			   route.getDestination().equalsIgnoreCase(destination)&&
				route.getJourneyDate().equals(journeyDate)&&
				route.getNumOfSeatsAvailable() >= numberOfPassengers) {
				matchingRoutes.add(route);
			}
		}
		return matchingRoutes;
		
	}
	
	
	private Order createOrder(LocalDate date, int passengers, Route selectedRoute) {
		Order neworder = new Order();
		double bookingCost = selectedRoute.getTicketPrice() * passengers;
		
		if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			bookingCost+= 300;
			bookingCost += bookingCost* 0.1;
		}
		neworder.setOrderAmount(bookingCost);
		neworder.setRoute(selectedRoute);
		neworder.setRequestedJourneyPlan(new Journey(date, passengers));
		neworder.setOrderStatus("Created");
		neworder.setOrderId(orders.size()+1);
		return neworder;
		
	}
	
	private Order findOrderById(int orderId) {
		for(Order order:orders) {
			if(order.getOrderId()==orderId) {
				
				return order;
			}
		}
		return null;
	}

}
