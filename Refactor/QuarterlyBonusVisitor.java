package com.moncept.test;

public class QuarterlyBonusVisitor implements Visitor {

	public double visit(SalesTrainee trainee) {

		System.out.println("Trainees Yearly Bonus");

		// Find bonus percentage using ternary operator

		double quarterlyBonusPercentage = (trainee.getSickDays() < 2 && trainee.getFailedTests() < 1) ? .01 : 0;

		double quarterlyBonusAmount = trainee.getSalary() * quarterlyBonusPercentage;

		return quarterlyBonusAmount;

	}

	public double visit(Salesman salesman) {

		System.out.println("Salesmans Yearly Bonus");

		double quarterlyBonusPercentage = (salesman.getTotalSalesAmount() > 25000 && salesman.getNewCustomers() > 20)
				? .03
				: 0;

		double quarterlyBonusAmount = salesman.getTotalSalesAmount() * quarterlyBonusPercentage;

		return quarterlyBonusAmount;

	}

	public double visit(Boss boss) {

		System.out.println("Bosses Yearly Bonus");

		double quarterlyBonusPercentage = (boss.getOfficeExpenses() < 12000 && boss.getNewCustomers() > 250) ? .05
				: .01;

		double quarterlyBonusAmount = boss.getTotalSalesAmount() * quarterlyBonusPercentage;

		return quarterlyBonusAmount;

	}

}