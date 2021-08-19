package com.moncept.test;

public class YearlyBonusVisitor implements Visitor {

	public double visit(SalesTrainee trainee) {

		System.out.println("Trainees Yearly Bonus");

		// Find bonus percentage using ternary operator

		double yearlyBonusPercentage = (trainee.getSickDays() < 10 && trainee.getFailedTests() < 2) ? .10 : .02;

		double yearlyBonusAmount = trainee.getSalary() * yearlyBonusPercentage;

		return yearlyBonusAmount;

	}

	public double visit(Salesman salesman) {

		System.out.println("Salesmans Yearly Bonus");

		double yearlyBonusPercentage = (salesman.getTotalSalesAmount() > 100000 && salesman.getNewCustomers() > 50)
				? .12
				: .04;

		double yearlyBonusAmount = salesman.getTotalSalesAmount() * yearlyBonusPercentage;

		return yearlyBonusAmount;

	}

	public double visit(Boss boss) {

		System.out.println("Bosses Yearly Bonus");

		double yearlyBonusPercentage = (boss.getOfficeExpenses() < 50000 && boss.getNewCustomers() > 1000) ? .15 : .04;

		double yearlyBonusAmount = boss.getTotalSalesAmount() * yearlyBonusPercentage;

		return yearlyBonusAmount;

	}

}