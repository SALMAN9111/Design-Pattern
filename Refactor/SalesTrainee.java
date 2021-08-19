package com.moncept.test;

public class SalesTrainee implements Visitable {

	private int sickDays;
	private int failedTests;
	private double salary;

	public SalesTrainee(int sickDays, int failedTests, double salary) {
		this.sickDays = sickDays;
		this.failedTests = failedTests;
		this.salary = salary;
	}

	public double accept(Visitor visitor) {

		return visitor.visit(this);

	}

	// Getters & Setters

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public int getFailedTests() {
		return failedTests;
	}

	public void setFailedTests(int failedTests) {
		this.failedTests = failedTests;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}