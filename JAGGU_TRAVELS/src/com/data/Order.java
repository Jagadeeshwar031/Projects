package com.data;

public class Order {
	private int orderId;
	private Route route;
	private Journey requestedJourneyPlan;
	private double orderAmount;
	private String orderStatus;
//	public Order(int orderId, Route route, Journey requestedJourneyPlan, double orderAmount, String orderStatus) {
//		this.orderId = orderId;
//		this.route = route;
//		this.requestedJourneyPlan = requestedJourneyPlan;
//		this.orderAmount = orderAmount;
//		this.orderStatus = orderStatus;
//	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Journey getRequestedJourneyPlan() {
		return requestedJourneyPlan;
	}
	public void setRequestedJourneyPlan(Journey requestedJourneyPlan) {
		this.requestedJourneyPlan = requestedJourneyPlan;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ",\n route=" + route + ",\n requestedJourneyPlan=" + requestedJourneyPlan
				+ ",\n orderAmount=" + orderAmount + ",\n orderStatus=" + orderStatus + "]";
	}
	
	
}
