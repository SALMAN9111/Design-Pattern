package com.moncept.test;

public class Salesman implements Visitable {

	private double totalSalesAmount;
	private int newCustomers;

	public Salesman(double totalSalesAmount, int newCustomers) {
		this.totalSalesAmount = totalSalesAmount;
		this.newCustomers = newCustomers;
	}

	public double accept(Visitor visitor) {

		return visitor.visit(this);

	}

	// Getters & Setters

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	public int getNewCustomers() {
		return newCustomers;
	}

	public void setNewCustomers(int newCustomers) {
		this.newCustomers = newCustomers;
	}

}