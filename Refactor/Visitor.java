package com.moncept.test;

//Each concrete visitor type will implement
//the Visitor interface. Here we define every
//instance of method overloading needed

interface Visitor {
	
	public double visit(SalesTrainee trainee);
	public double visit(Salesman salesman);
	public double visit(Boss boss);

}